package com.guardmansduck.beer.compat._12109;

import net.minecraft.util.Identifier;
import java.util.Map;
import java.util.HashMap;

public class BeerCompatData12109 {
    public static final Map<String, Identifier> ENTITIES = new HashMap<>();
    public static final Map<String, Identifier> BLOCKS = new HashMap<>();
    public static final Map<String, String> WORLDGEN_STRUCTURES = new HashMap<>();
    public static final Map<String, String> BUG_FIX_FLAGS = new HashMap<>();
    public static final Map<String, String> NBT_KEYS = new HashMap<>();

    static {
        // === ENTITIES ===
        ENTITIES.put("copper_golem", new Identifier("minecraft:copper_golem"));

        // === BLOCKS ===
        BLOCKS.put("copper_shelf", new Identifier("minecraft:copper_shelf"));
        BLOCKS.put("copper_chest", new Identifier("minecraft:copper_chest"));

        // === WORLDGEN STRUCTURES ===
        WORLDGEN_STRUCTURES.put("copper_golem_statue_spawn", "Generates oxidized Copper Golem statues in certain biomes.");

        // === BUG FIXES ===
        BUG_FIX_FLAGS.put("fix_1", "Fixed Copper Golem behavior when walking on slime blocks.");
        BUG_FIX_FLAGS.put("fix_2", "Resolved inventory duplication bug with Copper Chest.");

        // === NBT KEYS ===
        NBT_KEYS.put("CopperGolemAge", "Tracks oxidation stage of Copper Golem.");
        NBT_KEYS.put("CopperChestContents", "Stores inventory for Copper Chest block.");
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
