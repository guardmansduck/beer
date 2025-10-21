package com.guardmansduck.beer.compat._12003;

import net.minecraft.util.Identifier;
import java.util.Map;
import java.util.HashMap;

public class BeerCompatData12003 {
    public static final Map<String, Identifier> ENTITIES = new HashMap<>();
    public static final Map<String, Identifier> BLOCKS = new HashMap<>();
    public static final Map<String, String> WORLDGEN_STRUCTURES = new HashMap<>();
    public static final Map<String, String> BUG_FIX_FLAGS = new HashMap<>();
    public static final Map<String, String> NBT_KEYS = new HashMap<>();

    static {
        // === ENTITIES ===
        // No new entities in 1.20.3

        // === BLOCKS ===
        BLOCKS.put("dripstone_block", new Identifier("minecraft:dripstone_block"));
        BLOCKS.put("pointed_dripstone", new Identifier("minecraft:pointed_dripstone"));
        BLOCKS.put("cave_vines", new Identifier("minecraft:cave_vines"));

        // === WORLDGEN STRUCTURES ===
        WORLDGEN_STRUCTURES.put("cave_biome_updates", "Updated dripstone and cave vine placement in cave biomes.");

        // === BUG FIXES ===
        BUG_FIX_FLAGS.put("fix_1", "Fixed mob spawning issues in caves.");
        BUG_FIX_FLAGS.put("fix_2", "Corrected dripstone block physics and pointed dripstone behavior.");
        BUG_FIX_FLAGS.put("fix_3", "Fixed cave vine placement and growth inconsistencies.");

        // === NBT KEYS ===
        NBT_KEYS.put("DripstoneHeight", "Tracks height growth of pointed dripstone.");
        NBT_KEYS.put("CaveVineAge", "Tracks growth stage of cave vines.");
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
