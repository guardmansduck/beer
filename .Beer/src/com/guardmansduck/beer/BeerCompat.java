package com.guardmansduck.beer;

import net.minecraft.util.Identifier;
import net.fabricmc.loader.api.FabricLoader;
import java.util.*;
import java.util.jar.*;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

public class BeerCompat {
    private static Object compatData;

    private static Method getEntityMethod;
    private static Method getBlockMethod;
    private static Method getWorldgenMethod;
    private static Method getBugFixMethod;
    private static Method getNBTMethod;
    private static Method getModelMethod;

    private static Map<String, Identifier> entityCache = new HashMap<>();
    private static Map<String, Identifier> blockCache = new HashMap<>();
    private static Map<String, String> worldgenCache = new HashMap<>();
    private static Map<String, String> bugFixCache = new HashMap<>();
    private static Map<String, String> nbtCache = new HashMap<>();
    private static Map<String, String> modelCache = new HashMap<>();

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

            // Cache methods
            getEntityMethod = clazz.getMethod("getEntity", String.class);
            getBlockMethod = clazz.getMethod("getBlock", String.class);
            getWorldgenMethod = clazz.getMethod("getWorldgenStructure", String.class);
            getBugFixMethod = clazz.getMethod("getBugFix", String.class);
            getNBTMethod = clazz.getMethod("getNBTKey", String.class);
            getModelMethod = clazz.getMethod("getModel", String.class); // New for ModelRegistry

        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize BeerCompatData for version: " + chosenVersion, e);
        }
    }

    /** Discover BeerCompatData classes in the JAR */
    private static void discoverVersions() {
        if (!availableVersions.isEmpty()) return;

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

    /** Pick closest lower or equal version */
    private static String getClosestVersion(String mcVersion) {
        for (String v : availableVersions) {
            if (Integer.parseInt(mcVersion) >= Integer.parseInt(v)) return v;
        }
        return null;
    }

    /** Cached typed getters */
    public static Identifier getEntity(String name) {
        if (entityCache.containsKey(name)) return entityCache.get(name);
        try {
            Identifier id = (Identifier) getEntityMethod.invoke(compatData, name);
            entityCache.put(name, id);
            return id;
        } catch (Exception e) { return null; }
    }

    public static Identifier getBlock(String name) {
        if (blockCache.containsKey(name)) return blockCache.get(name);
        try {
            Identifier id = (Identifier) getBlockMethod.invoke(compatData, name);
            blockCache.put(name, id);
            return id;
        } catch (Exception e) { return null; }
    }

    public static String getWorldgenStructure(String name) {
        if (worldgenCache.containsKey(name)) return worldgenCache.get(name);
        try {
            String value = (String) getWorldgenMethod.invoke(compatData, name);
            worldgenCache.put(name, value);
            return value;
        } catch (Exception e) { return null; }
    }

    public static String getBugFix(String name) {
        if (bugFixCache.containsKey(name)) return bugFixCache.get(name);
        try {
            String value = (String) getBugFixMethod.invoke(compatData, name);
            bugFixCache.put(name, value);
            return value;
        } catch (Exception e) { return null; }
    }

    public static String getNBTKey(String name) {
        if (nbtCache.containsKey(name)) return nbtCache.get(name);
        try {
            String value = (String) getNBTMethod.invoke(compatData, name);
            nbtCache.put(name, value);
            return value;
        } catch (Exception e) { return null; }
    }

    public static String getModel(String name) {
        if (modelCache.containsKey(name)) return modelCache.get(name);
        try {
            String value = (String) getModelMethod.invoke(compatData, name);
            modelCache.put(name, value);
            return value;
        } catch (Exception e) { return null; }
    }

    /** List all keys dynamically for each type */
    public static Set<String> listEntities() { return listMapKeys("ENTITIES"); }
    public static Set<String> listBlocks() { return listMapKeys("BLOCKS"); }
    public static Set<String> listWorldgen() { return listMapKeys("WORLDGEN_STRUCTURES"); }
    public static Set<String> listBugFixes() { return listMapKeys("BUG_FIX_FLAGS"); }
    public static Set<String> listNBTKeys() { return listMapKeys("NBT_KEYS"); }
    public static Set<String> listModels() { return listMapKeys("MODEL_REGISTRY"); }

    private static Set<String> listMapKeys(String fieldName) {
        if (compatData == null) return Collections.emptySet();
        Set<String> keys = new HashSet<>();
        try {
            Map<?, ?> map = (Map<?, ?>) compatData.getClass().getField(fieldName).get(compatData);
            for (Object k : map.keySet()) keys.add(k.toString());
        } catch (Exception e) { /* ignore */ }
        return keys;
    }
}
