package com.guardmansduck.beer.compat._12101;

import net.minecraft.util.Identifier;
import java.util.Map;
import java.util.HashMap;

public class BeerCompatData12101 {
    public static final Map<String, Identifier> ENTITIES = new HashMap<>();
    public static final Map<String, Identifier> BLOCKS = new HashMap<>();
    public static final Map<String, String> WORLDGEN_STRUCTURES = new HashMap<>();
    public static final Map<String, String> BUG_FIX_FLAGS = new HashMap<>();
    public static final Map<String, String> NBT_KEYS = new HashMap<>();

    static {
        // === ENTITIES ===
        // No new entities in 1.21.1

        // === BLOCKS ===
        // No new blocks in 1.21.1

        // === WORLDGEN STRUCTURES ===
        WORLDGEN_STRUCTURES.put("loot_table_adjustments", "Tweaks to loot tables in naturally generated structures.");
        WORLDGEN_STRUCTURES.put("biome_feature_fixes", "Minor adjustments to placement of vegetation and rocks in biomes.");

        // === BUG FIXES ===
        BUG_FIX_FLAGS.put("fix_1", "Fixed texture glitches on newly placed blocks.");
        BUG_FIX_FLAGS.put("fix_2", "Resolved mob AI quirks with pathfinding and attacks.");
        BUG_FIX_FLAGS.put("fix_3", "Corrected block placement issues for corner and slab blocks.");

        // === NBT KEYS ===
        // No new NBT keys in 1.21.1
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
