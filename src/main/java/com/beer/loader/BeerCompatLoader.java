package com.beer.loader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.beer.mapping.VersionDetector;
import com.beer.manager.UniversalCompatManager;
import com.beer.remap.BeerRemapper;

/**
 * BeerCompatLoader
 *
 * Scans the mods folder, detects mod target versions, and attempts to load them
 * under compatibility using the remapper + classloader pipeline.
 *
 * For "all versions" support, this class stays generic: it delegates mapping lookups
 * and remapper selection to UniversalCompatManager / MappingRegistry.
 */
public class BeerCompatLoader {

    private static final File MODS_DIR = new File("mods");

    public static void init() {
        if (!MODS_DIR.exists() || !MODS_DIR.isDirectory()) {
            System.out.println("[Beer] No mods directory found at: " + MODS_DIR.getAbsolutePath());
            return;
        }

        File[] jars = MODS_DIR.listFiles(f -> f.isFile() && f.getName().toLowerCase().endsWith(".jar"));
        if (jars == null || jars.length == 0) {
            System.out.println("[Beer] No mod jars found in mods/.");
            return;
        }

        List<String> loaded = new ArrayList<>();
        for (File jar : jars) {
            try {
                String target = VersionDetector.detectMinecraftVersion(jar);
                if (target == null || target.isEmpty()) {
                    System.out.println("[Beer] Could not detect target MC for " + jar.getName() + " — skipping (will be handled by normal loader).");
                    continue;
                }
                System.out.println("[Beer] Detected mod " + jar.getName() + " targeting MC " + target);

                // Decide whether to attempt compatibility. For now attempt for anything older than current runtime.
                String runtime = VersionDetector.getRuntimeMinecraftVersion();
                if (shouldAttemptCompatibility(target, runtime)) {
                    System.out.println("[Beer] Attempting compatibility load for " + jar.getName() + " (" + target + " -> " + runtime + ")");
                    BeerRemapper remapper = UniversalCompatManager.remapperFor(target, runtime);
                    BeerClassLoader loader = new BeerClassLoader(new File[] { jar }, remapper);
                    // At prototype level, just instantiate loader so classes can be loaded lazily.
                    // In future, call loader.loadEntrypoints() to invoke mod entrypoints.
                    loaded.add(jar.getName());
                } else {
                    System.out.println("[Beer] Skipping compatibility for " + jar.getName() + " (target=" + target + ", runtime=" + runtime + ")");
                }
            } catch (Throwable t) {
                System.err.println("[Beer] Failed to handle mod " + jar.getName() + ": " + t.getMessage());
                t.printStackTrace();
            }
        }

        System.out.println("[Beer] Compatibility load attempted for " + loaded.size() + " mod(s).");
    }

    private static boolean shouldAttemptCompatibility(String targetVersion, String runtimeVersion) {
        // Basic policy: if target is older than runtime, attempt compatibility.
        // In later versions, this can be replaced by granular allowlist/denylist.
        if (targetVersion == null || runtimeVersion == null) return false;
        try {
            String[] tv = targetVersion.split("\\.");
            String[] rv = runtimeVersion.split("\\.");
            int tMajor = Integer.parseInt(tv[0]);
            int rMajor = Integer.parseInt(rv[0]);
            if (tMajor < rMajor) return true;
            if (tMajor == rMajor) {
                int tMinor = tv.length > 1 ? Integer.parseInt(tv[1]) : 0;
                int rMinor = rv.length > 1 ? Integer.parseInt(rv[1]) : 0;
                return tMinor < rMinor;
            }
            return false;
        } catch (Exception e) {
            // If parsing fails, default to conservative attempt false
            return false;
        }
    }
}
