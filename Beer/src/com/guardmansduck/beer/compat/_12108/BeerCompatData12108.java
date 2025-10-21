package com.guardmansduck.beer.compat._12108;

import net.minecraft.util.Identifier;
import java.util.Map;
import java.util.HashMap;

public class BeerCompatData12108 {
    public static final Map<String, Identifier> ENTITIES = new HashMap<>();
    public static final Map<String, Identifier> BLOCKS = new HashMap<>();
    public static final Map<String, String> WORLDGEN_STRUCTURES = new HashMap<>();
    public static final Map<String, String> BUG_FIX_FLAGS = new HashMap<>();
    public static final Map<String, String> NBT_KEYS = new HashMap<>();

    static {
        // === ENTITIES ===
        // No new entities in 1.21.8

        // === BLOCKS ===
        // No new blocks in 1.21.8

        // === WORLDGEN STRUCTURES ===
        WORLDGEN_STRUCTURES.put("tricky_trials", "Adds Tricky Trials structure for adventure/worldgen events.");

        // === BUG FIXES ===
        BUG_FIX_FLAGS.put("fix_1", "Corrected loot generation for Tricky Trials structure.");
        BUG_FIX_FLAGS.put("fix_2", "Fixed structure placement offset bug in superflat worlds.");

        // === NBT KEYS ===
        // No new NBT keys in 1.21.8
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
