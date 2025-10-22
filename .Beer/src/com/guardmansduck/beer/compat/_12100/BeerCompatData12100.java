package com.guardmansduck.beer.compat._12100;

import net.minecraft.util.Identifier;
import java.util.Map;
import java.util.HashMap;

public class BeerCompatData12100 {
    public static final Map<String, Identifier> ENTITIES = new HashMap<>();
    public static final Map<String, Identifier> BLOCKS = new HashMap<>();
    public static final Map<String, String> WORLDGEN_STRUCTURES = new HashMap<>();
    public static final Map<String, String> BUG_FIX_FLAGS = new HashMap<>();
    public static final Map<String, String> NBT_KEYS = new HashMap<>();

    static {
        // === ENTITIES ===
        ENTITIES.put("camel", new Identifier("minecraft:camel"));

        // === BLOCKS ===
        BLOCKS.put("cherry_log", new Identifier("minecraft:cherry_log"));
        BLOCKS.put("cherry_planks", new Identifier("minecraft:cherry_planks"));
        BLOCKS.put("cherry_door", new Identifier("minecraft:cherry_door"));
        BLOCKS.put("cherry_trapdoor", new Identifier("minecraft:cherry_trapdoor"));
        BLOCKS.put("cherry_fence", new Identifier("minecraft:cherry_fence"));
        BLOCKS.put("cherry_fence_gate", new Identifier("minecraft:cherry_fence_gate"));
        BLOCKS.put("cherry_sign", new Identifier("minecraft:cherry_sign"));
        BLOCKS.put("cherry_hanging_sign", new Identifier("minecraft:cherry_hanging_sign"));
        BLOCKS.put("cherry_sapling", new Identifier("minecraft:cherry_sapling"));
        BLOCKS.put("cherry_flower", new Identifier("minecraft:cherry_flower"));

        // === WORLDGEN STRUCTURES ===
        WORLDGEN_STRUCTURES.put("cherry_grove_biome", "Generates Cherry Grove biome with Cherry trees and flowers.");
        WORLDGEN_STRUCTURES.put("camel_spawn", "Camels spawn naturally in desert and plains biomes.");

        // === BUG FIXES ===
        BUG_FIX_FLAGS.put("fix_1", "Fixed Cherry Tree growth mechanics in certain biomes.");
        BUG_FIX_FLAGS.put("fix_2", "Corrected Camel AI behavior near water and hills.");
        BUG_FIX_FLAGS.put("fix_3", "Fixed door placement and interaction in cherry structures.");

        // === NBT KEYS ===
        NBT_KEYS.put("CamelSaddle", "Tracks whether Camel is saddled and rider inventory.");
        NBT_KEYS.put("CherryTreeAge", "Tracks growth stage of Cherry trees.");
        NBT_KEYS.put("CherryFlowerBloom", "Tracks bloom stage of Cherry flowers.");
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
