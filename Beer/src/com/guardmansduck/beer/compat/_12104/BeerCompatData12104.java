package com.guardmansduck.beer.compat._12104;

import net.minecraft.util.Identifier;
import java.util.Map;
import java.util.HashMap;

public class BeerCompatData12104 {
    public static final Map<String, Identifier> ENTITIES = new HashMap<>();
    public static final Map<String, Identifier> BLOCKS = new HashMap<>();
    public static final Map<String, String> WORLDGEN_STRUCTURES = new HashMap<>();
    public static final Map<String, String> BUG_FIX_FLAGS = new HashMap<>();
    public static final Map<String, String> NBT_KEYS = new HashMap<>();

    static {
        // === ENTITIES ===
        ENTITIES.put("creaking", new Identifier("minecraft:creaking"));

        // === BLOCKS ===
        BLOCKS.put("pale_oak", new Identifier("minecraft:pale_oak"));
        BLOCKS.put("pale_moss", new Identifier("minecraft:pale_moss"));
        BLOCKS.put("creaking_heart", new Identifier("minecraft:creaking_heart"));
        BLOCKS.put("eyeblossoms", new Identifier("minecraft:eyeblossoms"));

        // === WORLDGEN STRUCTURES ===
        WORLDGEN_STRUCTURES.put("pale_oak_tree", "Generates Pale Oak trees in Pale Forest biomes.");
        WORLDGEN_STRUCTURES.put("pale_moss_patch", "Generates Pale Moss in swampy biomes.");
        WORLDGEN_STRUCTURES.put("creaking_heart_plant", "Generates Creaking Heart plants in forest biomes.");

        // === BUG FIXES ===
        BUG_FIX_FLAGS.put("fix_1", "Fixed plant placement and growth issues with Pale Oak and Moss.");
        BUG_FIX_FLAGS.put("fix_2", "Resolved Eyeblossoms interaction bug with players.");

        // === NBT KEYS ===
        NBT_KEYS.put("CreakingHeartState", "Tracks animation/state of Creaking Heart plant.");
        NBT_KEYS.put("EyeblossomBloom", "Tracks whether Eyeblossoms are blooming.");
        NBT_KEYS.put("PaleOakAge", "Tracks growth stage of Pale Oak trees.");
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
