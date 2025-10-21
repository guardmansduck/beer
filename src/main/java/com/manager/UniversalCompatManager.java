package com.beer.manager;

import com.beer.loader.BeerCompatLoader;
import com.beer.mapping.MappingRegistry;
import com.beer.remap.BeerRemapper;
import com.beer.shim.BeerShim;

/**
 * UniversalCompatManager
 *
 * Central coordinator for Beer. Designed to be loader- and-version-agnostic.
 * Responsibilities:
 *  - initialize mapping registry
 *  - initialize shims (Fabric API stubs, registry aliases, etc)
 *  - start compat loader that scans and loads installed mods
 *
 * Expand by adding new mapping modules to MappingRegistry and implementing
 * remappers inside remap package.
 */
public class UniversalCompatManager {

    public static void init() {
        System.out.println("[Beer] Initializing MappingRegistry...");
        MappingRegistry.init(); // load any embedded mapping tables (1.18, 1.19, ...)
        System.out.println("[Beer] Initializing API shims...");
        BeerShim.init();
        System.out.println("[Beer] Starting compat loader...");
        BeerCompatLoader.init();
        System.out.println("[Beer] UniversalCompatManager initialised.");
    }

    /**
     * Expose remapper selection for other code.
     * For now returns a simple stub remapper — replace with a real implementation later.
     */
    public static BeerRemapper remapperFor(String fromVersion, String toVersion) {
        // In later iterations choose TinyRemapper-backed implementation for heavy lifting.
        return new BeerRemapper.StubRemapper(fromVersion, toVersion);
    }
}
