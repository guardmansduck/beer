package com.guardmansduck.beer.compat._1215;

import net.minecraft.util.Identifier;
import java.util.Map;
import java.util.HashMap;

public class BeerCompatData1215 {
    public static final Map<String, Identifier> ENTITIES = new HashMap<>();
    public static final Map<String, Identifier> BLOCKS = new HashMap<>();

    static {
        // Entities
        ENTITIES.put("bogged", new Identifier("minecraft:bogged"));
        ENTITIES.put("breeze", new Identifier("minecraft:breeze"));

        // Blocks
        BLOCKS.put("vault", new Identifier("minecraft:ominous_vault"));
        BLOCKS.put("copper_door", new Identifier("minecraft:copper_door"));
        BLOCKS.put("oak_door", new Identifier("minecraft:oak_door"));
    }

    public static Identifier getEntity(String name) {
        return ENTITIES.get(name);
    }

    public static Identifier getBlock(String name) {
        return BLOCKS.get(name);
    }
}
