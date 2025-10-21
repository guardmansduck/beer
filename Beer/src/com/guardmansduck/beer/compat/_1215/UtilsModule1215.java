package com.guardmansduck.beer.compat._1215;

public class UtilsModule1215 {
    public static void init() {
        System.out.println("Utils module for 1.21.5 loaded!");
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static void log(String msg) {
        System.out.println("[BeerUtils] " + msg);
    }
}
