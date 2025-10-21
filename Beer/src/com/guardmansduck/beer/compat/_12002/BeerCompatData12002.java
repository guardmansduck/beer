package com.guardmansduck.beer.compat._12002;

import net.minecraft.util.Identifier;
import java.util.Map;
import java.util.HashMap;

public class BeerCompatData12002 {
    public static final Map<String, Identifier> ENTITIES = new HashMap<>();
    public static final Map<String, Identifier> BLOCKS = new HashMap<>();
    public static final Map<String, String> WORLDGEN_STRUCTURES = new HashMap<>();
    public static final Map<String, String> BUG_FIX_FLAGS = new HashMap<>();
    public static final Map<String, String> NBT_KEYS = new HashMap<>();

    static {
        // === ENTITIES ===
        // No new entities in 1.20.2

        // === BLOCKS ===
        BLOCKS.put("azalea_leaves", new Identifier("minecraft:azalea_leaves"));
        BLOCKS.put("flowering_azalea_leaves", new Identifier("minecraft:flowering_azalea_leaves"));
        BLOCKS.put("moss_block", new Identifier("minecraft:moss_block"));
        BLOCKS.put("moss_carpet", new Identifier("minecraft:moss_carpet"));

        // === WORLDGEN STRUCTURES ===
        WORLDGEN_STRUCTURES.put("lush_biome_vegetation", "Adjusted placement of azalea trees, flowering azaleas, and moss in lush biomes.");

        // === BUG FIXES ===
        BUG_FIX_FLAGS.put("fix_1", "Fixed leaf decay issues causing invisible blocks.");
        BUG_FIX_FLAGS.put("fix_2", "Corrected plant placement and lighting inconsistencies.");
        BUG_FIX_FLAGS.put("fix_3", "Adjusted moss carpet placement to prevent clipping.");

        // === NBT KEYS ===
        NBT_KEYS.put("AzaleaBloom", "Tracks bloom state of azalea leaves.");
        NBT_KEYS.put("MossWetness", "Tracks wetness level of moss blocks.");
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
