package com.guardmansduck.beer.compat._11904;

import net.minecraft.util.Identifier;
import java.util.Map;
import java.util.HashMap;

public class BeerCompatData11904 {
    public static final Map<String, Identifier> ENTITIES = new HashMap<>();
    public static final Map<String, Identifier> BLOCKS = new HashMap<>();
    public static final Map<String, String> WORLDGEN_STRUCTURES = new HashMap<>();
    public static final Map<String, String> BUG_FIX_FLAGS = new HashMap<>();
    public static final Map<String, String> NBT_KEYS = new HashMap<>();

    static {
        // === ENTITIES ===
        // No new entities in 1.19.4

        // === BLOCKS ===
        BLOCKS.put("sculk_sensor", new Identifier("minecraft:sculk_sensor"));
        BLOCKS.put("sculk_catalyst", new Identifier("minecraft:sculk_catalyst"));
        BLOCKS.put("deepslate", new Identifier("minecraft:deepslate"));

        // === WORLDGEN STRUCTURES ===
        WORLDGEN_STRUCTURES.put("deep_dark_biome", "Generates Deep Dark biome and Ancient City structures.");
        WORLDGEN_STRUCTURES.put("sculk_spread", "Controls Sculk spread behavior in Deep Dark.");

        // === BUG FIXES ===
        BUG_FIX_FLAGS.put("fix_1", "Fixed mob spawning in Deep Dark biome.");
        BUG_FIX_FLAGS.put("fix_2", "Resolved Sculk duplication and spread issues.");
        BUG_FIX_FLAGS.put("fix_3", "Corrected deepslate block placement errors.");

        // === NBT KEYS ===
        NBT_KEYS.put("SculkCharge", "Tracks charge state of Sculk Sensor and Catalyst blocks.");
        NBT_KEYS.put("DeepslateVariant", "Tracks variant type of deepslate blocks.");
    }

    public static Identifier getEntity(String name) {
        return ENTITIES.get(name);
    }

    public static Identifier getBlock(String name) {
        return BLOCKS.get(name);
    }

    public static String getWorldgenStructure(String name) {
        return WORLDGEN_STRUCTURES.get(name);
    }

    public static String getBugFix(String name) {
        return BUG_FIX_FLAGS.get(name);
    }

    public static String getNBTKey(String name) {
        return NBT_KEYS.get(name);
    }
}
