package com.guardmansduck.beer.compat._11903;

import net.minecraft.util.Identifier;
import java.util.Map;
import java.util.HashMap;

public class BeerCompatData11903 {
    public static final Map<String, Identifier> ENTITIES = new HashMap<>();
    public static final Map<String, Identifier> BLOCKS = new HashMap<>();
    public static final Map<String, String> WORLDGEN_STRUCTURES = new HashMap<>();
    public static final Map<String, String> BUG_FIX_FLAGS = new HashMap<>();
    public static final Map<String, String> NBT_KEYS = new HashMap<>();

    static {
        // === ENTITIES ===
        // No new entities in 1.19.3

        // === BLOCKS ===
        BLOCKS.put("ancient_debris", new Identifier("minecraft:ancient_debris"));
        BLOCKS.put("copper_ore", new Identifier("minecraft:copper_ore"));
        BLOCKS.put("copper_block", new Identifier("minecraft:copper_block"));

        // === WORLDGEN STRUCTURES ===
        WORLDGEN_STRUCTURES.put("ore_distribution_adjustments", "Adjusted ore distribution for ancient debris and copper.");
        WORLDGEN_STRUCTURES.put("dripstone_caves", "Tweaks to dripstone cave generation for better formation.");

        // === BUG FIXES ===
        BUG_FIX_FLAGS.put("fix_1", "Fixed mob pathfinding near ores and cave formations.");
        BUG_FIX_FLAGS.put("fix_2", "Corrected block physics for ores and dripstone.");
        BUG_FIX_FLAGS.put("fix_3", "Resolved anomalies in ore generation rates.");

        // === NBT KEYS ===
        NBT_KEYS.put("AncientDebrisAge", "Tracks smelting/age state of ancient debris blocks.");
        NBT_KEYS.put("CopperOxidation", "Tracks oxidation stage of copper blocks.");
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
