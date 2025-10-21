package com.guardmansduck.beer.compat._12004;

import net.minecraft.util.Identifier;
import java.util.Map;
import java.util.HashMap;

public class BeerCompatData12004 {
    public static final Map<String, Identifier> ENTITIES = new HashMap<>();
    public static final Map<String, Identifier> BLOCKS = new HashMap<>();
    public static final Map<String, String> WORLDGEN_STRUCTURES = new HashMap<>();
    public static final Map<String, String> BUG_FIX_FLAGS = new HashMap<>();
    public static final Map<String, String> NBT_KEYS = new HashMap<>();

    static {
        // === ENTITIES ===
        ENTITIES.put("sniffer", new Identifier("minecraft:sniffer"));

        // === BLOCKS ===
        BLOCKS.put("mangrove_log", new Identifier("minecraft:mangrove_log"));
        BLOCKS.put("mangrove_planks", new Identifier("minecraft:mangrove_planks"));
        BLOCKS.put("mud", new Identifier("minecraft:mud"));
        BLOCKS.put("mangrove_roots", new Identifier("minecraft:mangrove_roots"));

        // === WORLDGEN STRUCTURES ===
        WORLDGEN_STRUCTURES.put("mangrove_swamp_biome", "Generates Mangrove Swamp biome with mangroves and mud patches.");
        WORLDGEN_STRUCTURES.put("sniffer_spawn", "Sniffer entity spawns in swamp areas.");

        // === BUG FIXES ===
        BUG_FIX_FLAGS.put("fix_1", "Fixed mangrove growth and root placement mechanics.");
        BUG_FIX_FLAGS.put("fix_2", "Corrected mud block physics to avoid pathing glitches.");
        BUG_FIX_FLAGS.put("fix_3", "Fixed Sniffer AI behavior when searching for items.");

        // === NBT KEYS ===
        NBT_KEYS.put("SnifferEggs", "Tracks eggs collected or laid by Sniffer.");
        NBT_KEYS.put("MangroveAge", "Tracks growth stage of Mangrove trees.");
        NBT_KEYS.put("MudWetness", "Tracks hydration level of Mud blocks.");
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
