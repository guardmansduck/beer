package com.guardmansduck.beer;

import net.minecraft.util.Identifier;
import net.fabricmc.loader.api.FabricLoader;
import java.util.*;
import java.util.jar.*;
import java.io.InputStream;
import java.lang.reflect.Method;

public class BeerCompat {
    private static Object compatData;
    private static Method getEntityMethod;
    private static Method getBlockMethod;
    private static Map<String, Identifier> entityCache = new HashMap<>();
    private static Map<String, Identifier> blockCache = new HashMap<>();
    private static List<String> availableVersions = new ArrayList<>();

    /** Auto-initialize BeerCompat by discovering available versions */
    public static void init() {
        discoverVersions();

        String mcVersion = FabricLoader.getInstance()
                              .getMinecraftVersion()
                              .replace(".", "");

        String chosenVersion = getClosestVersion(mcVersion);
        if (chosenVersion == null) {
            throw new RuntimeException("No compatible BeerCompatData found for Minecraft version: " + mcVersion);
        }

        try {
            String className = "com.guardmansduck.beer.compat._" + chosenVersion +
                               ".BeerCompatData" + chosenVersion;
            Class<?> clazz = Class.forName(className);
            compatData = clazz.getDeclaredConstructor().newInstance();

            // Cache reflection methods
            getEntityMethod = clazz.getMethod("getEntity", String.class);
            getBlockMethod = clazz.getMethod("getBlock", String.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize BeerCompatData for version: " + chosenVersion, e);
        }
    }

    /** Scan the JAR for BeerCompatData classes and extract version numbers */
    private static void discoverVersions() {
        if (!availableVersions.isEmpty()) return; // already discovered

        try {
            String packagePath = "com/guardmansduck/beer/compat/";
            InputStream jarStream = BeerCompat.class.getProtectionDomain()
                                        .getCodeSource()
                                        .getLocation()
                                        .openStream();
            JarInputStream jar = new JarInputStream(jarStream);
            JarEntry entry;
            while ((entry = jar.getNextJarEntry()) != null) {
                String name = entry.getName();
                if (name.startsWith(packagePath) && name.endsWith(".class") && name.contains("BeerCompatData")) {
                    String classFile = name.substring(name.lastIndexOf("/") + 1, name.length() - 6);
                    String version = classFile.replace("BeerCompatData", "");
                    availableVersions.add(version);
                }
            }
            jar.close();
        } catch (Exception e) {
            throw new RuntimeException("Failed to discover BeerCompatData versions", e);
        }

        Collections.sort(availableVersions, Collections.reverseOrder());
    }

    /** Pick the closest lower or equal version to mcVersion */
    private static String getClosestVersion(String mcVersion) {
        for (String v : availableVersions) {
            if (Integer.parseInt(mcVersion) >= Integer.parseInt(v)) {
                return v;
            }
        }
        return null;
    }

    /** Retrieve an entity Identifier by name (cached) */
    public static Identifier getEntity(String name) {
        if (entityCache.containsKey(name)) return entityCache.get(name);
        if (compatData == null) return null;
        try {
            Identifier id = (Identifier) getEntityMethod.invoke(compatData, name);
            entityCache.put(name, id);
            return id;
        } catch (Exception e) {
            return null;
        }
    }

    /** Retrieve a block Identifier by name (cached) */
    public static Identifier getBlock(String name) {
        if (blockCache.containsKey(name)) return blockCache.get(name);
        if (compatData == null) return null;
        try {
            Identifier id = (Identifier) getBlockMethod.invoke(compatData, name);
            blockCache.put(name, id);
            return id;
        } catch (Exception e) {
            return null;
        }
    }

    /** List all available entity names for the current version */
    public static Set<String> listEntities() {
        if (compatData == null) return Collections.emptySet();
        Set<String> names = new HashSet<>();
        // Since BeerCompatData holds a Map called ENTITIES, we access it via reflection
        try {
            Map<?, ?> entitiesMap = (Map<?, ?>) compatData.getClass()
                .getField("ENTITIES")
                .get(compatData);
            for (Object key : entitiesMap.keySet()) {
                names.add(key.toString());
            }
        } catch (Exception e) {
            // ignore
        }
        return names;
    }

    /** List all available block names for the current version */
    public static Set<String> listBlocks() {
        if (compatData == null) return Collections.emptySet();
        Set<String> names = new HashSet<>();
        try {
            Map<?, ?> blocksMap = (Map<?, ?>) compatData.getClass()
                .getField("BLOCKS")
                .get(compatData);
            for (Object key : blocksMap.keySet()) {
                names.add(key.toString());
            }
        } catch (Exception e) {
            // ignore
        }
        return names;
    }
}
