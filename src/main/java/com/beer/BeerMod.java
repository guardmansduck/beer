package com.beer;

import net.fabricmc.api.ModInitializer;
import com.beer.manager.UniversalCompatManager;

public class BeerMod implements ModInitializer {
    @Override
    public void onInitialize() {
        System.out.println("[Beer] Starting universal compatibility core...");
        UniversalCompatManager.init();
    }
}
