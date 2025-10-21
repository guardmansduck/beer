package com.guardmansduck.beer.compat._12103;

import net.minecraft.util.Identifier;
import java.util.Map;
import java.util.HashMap;

public class BeerCompatData12103 {
    public static final Map<String, Identifier> ENTITIES = new HashMap<>();
    public static final Map<String, Identifier> BLOCKS = new HashMap<>();
    public static final Map<String, String> WORLDGEN_STRUCTURES = new HashMap<>();
    public static final Map<String, String> BUG_FIX_FLAGS = new HashMap<>();
    public static final Map<String, String> NBT_KEYS = new HashMap<>();

    static {
        // === ENTITIES ===
        // No new entities in 1.21.3

        // === BLOCKS ===
        // No new blocks in 1.21.3

        // === WORLDGEN STRUCTURES ===
        WORLDGEN_STRUCTURES.put("tree_density_adjustment", "Minor adjustments to tree density in forest and plains biomes.");
        WORLDGEN_STRUCTURES.put("biome_feature_placement", "Tweaks to moss, flowers, and other small vegetation features.");

        // === BUG FIXES ===
        BUG_FIX_FLAGS.put("fix_1", "Fixed rare crash when interacting with waterlogged blocks.");
        BUG_FIX_FLAGS.put("fix_2", "Resolved leaf decay bug causing invisible blocks in some biomes.");

        // === NBT KEYS ===
        // No new NBT keys in 1.21.3
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
