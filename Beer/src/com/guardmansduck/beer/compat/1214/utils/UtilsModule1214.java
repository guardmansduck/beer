package com.guardmansduck.beer.compat._1214.utils;

public class UtilsModule1214 {
    public static void init() {
        System.out.println("Utils module for 1.21.4 loaded!");
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static void log(String msg) {
        System.out.println("[BeerUtils] " + msg);
    }
}
