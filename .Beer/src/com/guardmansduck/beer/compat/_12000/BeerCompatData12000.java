package com.guardmansduck.beer.compat._12000;

import net.minecraft.util.Identifier;
import java.util.Map;
import java.util.HashMap;

public class BeerCompatData12000 {
    public static final Map<String, Identifier> ENTITIES = new HashMap<>();
    public static final Map<String, Identifier> BLOCKS = new HashMap<>();
    public static final Map<String, String> WORLDGEN_STRUCTURES = new HashMap<>();
    public static final Map<String, String> BUG_FIX_FLAGS = new HashMap<>();
    public static final Map<String, String> NBT_KEYS = new HashMap<>();

    static {
        // === ENTITIES ===
        ENTITIES.put("sniffer", new Identifier("minecraft:sniffer"));
        ENTITIES.put("camel", new Identifier("minecraft:camel"));

        // === BLOCKS ===
        BLOCKS.put("mangrove_log", new Identifier("minecraft:mangrove_log"));
        BLOCKS.put("mangrove_planks", new Identifier("minecraft:mangrove_planks"));
        BLOCKS.put("mud", new Identifier("minecraft:mud"));
        BLOCKS.put("azalea_leaves", new Identifier("minecraft:azalea_leaves"));
        BLOCKS.put("flowering_azalea_leaves", new Identifier("minecraft:flowering_azalea_leaves"));

        // === WORLDGEN STRUCTURES ===
        WORLDGEN_STRUCTURES.put("mangrove_swamp_biome", "Generates Mangrove Swamp biome with mangroves and mud patches.");
        WORLDGEN_STRUCTURES.put("lush_caves_biome", "Generates lush caves with azalea trees and moss.");
        WORLDGEN_STRUCTURES.put("camel_spawn", "Camels spawn naturally in desert and plains biomes.");

        // === BUG FIXES ===
        BUG_FIX_FLAGS.put("fix_1", "Fixed mangrove and azalea growth mechanics.");
        BUG_FIX_FLAGS.put("fix_2", "Corrected mob AI and spawning issues in new biomes.");
        BUG_FIX_FLAGS.put("fix_3", "Fixed block physics for mud and moss.");

        // === NBT KEYS ===
        NBT_KEYS.put("CamelSaddle", "Tracks whether Camel is saddled and rider inventory.");
        NBT_KEYS.put("SnifferEggs", "Tracks eggs collected or laid by Sniffer.");
        NBT_KEYS.put("MangroveAge", "Tracks growth stage of Mangrove trees.");
        NBT_KEYS.put("AzaleaBloom", "Tracks bloom state of azalea leaves.");
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
