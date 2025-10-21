package com.guardmansduck.beer;

public class BeerCompat {
    public static void init() {
        System.out.println("Beer compatibility layer initialized!");
    }

    // Example: version-specific hooks
    public static void doSomethingFor1215() {
        System.out.println("Running code for 1.21.5");
    }

    public static void doSomethingFor120x() {
        System.out.println("Running code for 1.20.x");
    }
}
