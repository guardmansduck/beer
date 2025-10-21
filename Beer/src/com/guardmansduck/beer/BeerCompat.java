package com.guardmansduck.beer;

import java.lang.reflect.Method;
import java.util.Set;
import java.util.HashSet;

public class BeerCompat {

    public static void init() {
        System.out.println("Beer 1.21.5 compat layer initialized!");
        loadModules("_1215");
    }

    private static void loadModules(String versionPackageSuffix) {
        String basePackage = "com.epicd.beer.compat." + versionPackageSuffix;

        try {
            // Get all classes in the package using ClassLoader
            // Note: In plain Java, you can’t list packages directly,
            // so we must manually register module classes OR use a small registry file.
            Set<Class<?>> modules = ModuleRegistry.getModules(basePackage);

            for (Class<?> moduleClass : modules) {
                try {
                    Method initMethod = moduleClass.getMethod("init");
                    initMethod.invoke(null); // static init
                } catch (NoSuchMethodException e) {
                    System.out.println("No init() method in " + moduleClass.getName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
