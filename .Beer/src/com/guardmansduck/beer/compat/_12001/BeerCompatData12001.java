package com.guardmansduck.beer.compat._12001;

import net.minecraft.util.Identifier;
import java.util.Map;
import java.util.HashMap;

public class BeerCompatData12001 {
    public static final Map<String, Identifier> ENTITIES = new HashMap<>();
    public static final Map<String, Identifier> BLOCKS = new HashMap<>();
    public static final Map<String, String> WORLDGEN_STRUCTURES = new HashMap<>();
    public static final Map<String, String> BUG_FIX_FLAGS = new HashMap<>();
    public static final Map<String, String> NBT_KEYS = new HashMap<>();

    static {
        // === ENTITIES ===
        // No new entities in 1.20.1

        // === BLOCKS ===
        BLOCKS.put("mangrove_roots", new Identifier("minecraft:mangrove_roots"));
        BLOCKS.put("mud", new Identifier("minecraft:mud"));
        BLOCKS.put("hanging_roots", new Identifier("minecraft:hanging_roots"));

        // === WORLDGEN STRUCTURES ===
        WORLDGEN_STRUCTURES.put("mangrove_swamp_updates", "Adjusted mangrove swamp generation and hanging roots placement.");

        // === BUG FIXES ===
        BUG_FIX_FLAGS.put("fix_1", "Fixed mob spawning issues in mangrove biomes.");
        BUG_FIX_FLAGS.put("fix_2", "Corrected block physics for mud and mangrove roots.");
        BUG_FIX_FLAGS.put("fix_3", "Resolved hanging roots placement inconsistencies.");

        // === NBT KEYS ===
        NBT_KEYS.put("HangingRootLength", "Tracks length of hanging roots in mangrove biomes.");
        NBT_KEYS.put("MudWetness", "Tracks hydration level of mud blocks.");
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
