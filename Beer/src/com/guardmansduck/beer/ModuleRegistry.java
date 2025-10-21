package com.guardmansduck.beer;

import java.util.Set;
import java.util.HashSet;

public class ModuleRegistry {

    public static Set<Class<?>> getModules(String basePackage) {
        Set<Class<?>> modules = new HashSet<>();

        if (basePackage.endsWith("_1215")) {
            modules.add(com.epicd.beer.compat._1215.rendering.RenderModule1215.class);
            modules.add(com.epicd.beer.compat._1215.items.ItemModule1215.class);
            modules.add(com.epicd.beer.compat._1215.utils.UtilsModule1215.class);
            modules.add(com.epicd.beer.compat._1215.firstperson.FirstPersonModule1215.class);
        }

        // Later, add other versions here similarly
        return modules;
    }
}
