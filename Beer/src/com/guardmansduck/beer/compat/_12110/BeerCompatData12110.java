package com.guardmansduck.beer.compat._12110;

import net.minecraft.util.Identifier;
import java.util.Map;
import java.util.HashMap;

public class BeerCompatData12110 {
    public static final Map<String, Identifier> ENTITIES = new HashMap<>();
    public static final Map<String, Identifier> BLOCKS = new HashMap<>();
    public static final Map<String, String> WORLDGEN_STRUCTURES = new HashMap<>();
    public static final Map<String, String> BUG_FIX_FLAGS = new HashMap<>();
    public static final Map<String, String> NBT_KEYS = new HashMap<>();

    static {
        // === ENTITIES ===
        // No new entities in 1.21.10

        // === BLOCKS ===
        // No new blocks in 1.21.10

        // === WORLDGEN STRUCTURES ===
        // No new worldgen changes in 1.21.10

        // === BUG FIXES ===
        BUG_FIX_FLAGS.put("fix_1", "Resolved incorrect texture flashing on copper blocks.");
        BUG_FIX_FLAGS.put("fix_2", "Fixed mob pathfinding issues with villagers near doors.");

        // === NBT KEYS ===
        // No new NBT keys in 1.21.10
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
