package com.guardmansduck.beer.compat._11902;

import net.minecraft.util.Identifier;
import java.util.Map;
import java.util.HashMap;

public class BeerCompatData11902 {
    public static final Map<String, Identifier> ENTITIES = new HashMap<>();
    public static final Map<String, Identifier> BLOCKS = new HashMap<>();
    public static final Map<String, String> WORLDGEN_STRUCTURES = new HashMap<>();
    public static final Map<String, String> BUG_FIX_FLAGS = new HashMap<>();
    public static final Map<String, String> NBT_KEYS = new HashMap<>();

    static {
        // === ENTITIES ===
        // No new entities in 1.19.2

        // === BLOCKS ===
        BLOCKS.put("deepslate_ore", new Identifier("minecraft:deepslate_ore"));
        BLOCKS.put("copper_ore", new Identifier("minecraft:copper_ore"));
        BLOCKS.put("amethyst_block", new Identifier("minecraft:amethyst_block"));
        BLOCKS.put("tuff", new Identifier("minecraft:tuff"));

        // === WORLDGEN STRUCTURES ===
        WORLDGEN_STRUCTURES.put("deepslate_and_geode_adjustments", "Adjusted deepslate ore distribution and amethyst geode placement.");

        // === BUG FIXES ===
        BUG_FIX_FLAGS.put("fix_1", "Fixed block physics for deepslate and tuff.");
        BUG_FIX_FLAGS.put("fix_2", "Corrected mob AI in caves near ores and geodes.");
        BUG_FIX_FLAGS.put("fix_3", "Resolved ore generation inconsistencies.");

        // === NBT KEYS ===
        NBT_KEYS.put("DeepslateVariant", "Tracks variant type of deepslate ores.");
        NBT_KEYS.put("AmethystGrowthStage", "Tracks growth stage of amethyst clusters.");
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
