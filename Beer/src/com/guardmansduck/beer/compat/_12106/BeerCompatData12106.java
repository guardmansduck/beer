package com.guardmansduck.beer.compat._12106;

import net.minecraft.util.Identifier;
import java.util.Map;
import java.util.HashMap;

public class BeerCompatData12106 {
    public static final Map<String, Identifier> ENTITIES = new HashMap<>();
    public static final Map<String, Identifier> BLOCKS = new HashMap<>();
    public static final Map<String, String> WORLDGEN_STRUCTURES = new HashMap<>();
    public static final Map<String, String> BUG_FIX_FLAGS = new HashMap<>();
    public static final Map<String, String> NBT_KEYS = new HashMap<>();

    static {
        // === ENTITIES ===
        ENTITIES.put("happy_ghast", new Identifier("minecraft:happy_ghast"));

        // === BLOCKS ===
        BLOCKS.put("dried_ghast", new Identifier("minecraft:dried_ghast"));

        // === WORLDGEN STRUCTURES ===
        WORLDGEN_STRUCTURES.put("dried_ghast_spawn", "Dried Ghast blocks can spawn naturally in specific biomes.");

        // === BUG FIXES ===
        BUG_FIX_FLAGS.put("fix_1", "Fixed Happy Ghast mob behavior with waterlogged blocks.");
        BUG_FIX_FLAGS.put("fix_2", "Resolved block placement issues for Dried Ghast.");

        // === NBT KEYS ===
        NBT_KEYS.put("HappyGhastMood", "Tracks mood state of Happy Ghast entity.");
        NBT_KEYS.put("DriedGhastBlockState", "Tracks the hydration/age state of Dried Ghast block.");
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
