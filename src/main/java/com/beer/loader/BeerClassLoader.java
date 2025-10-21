package com.beer.loader;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.jar.JarFile;
import java.util.Enumeration;
import java.util.zip.ZipEntry;

import com.beer.remap.BeerRemapper;

/**
 * BeerClassLoader
 *
 * Simple class loader that can accept a remapper implementation to transform
 * classes before definition. Currently implemented to accept an array of JARs.
 *
 * NOTE: This is a minimal loader for the prototype. Classloader isolation, resource
 * delegation, and Mixin interactions are complex and will need careful expansion.
 */
public class BeerClassLoader extends URLClassLoader {
    private final BeerRemapper remapper;
    private final File[] jars;

    public BeerClassLoader(File[] jarFiles, BeerRemapper remapper) throws IOException {
        super(filesToURLs(jarFiles), BeerClassLoader.class.getClassLoader());
        this.remapper = remapper;
        this.jars = jarFiles;
        // Optionally preload or remap on construction
        // preloadAndRemap();
    }

    private static URL[] filesToURLs(File[] f) throws IOException {
        URL[] urls = new URL[f.length];
        for (int i = 0; i < f.length; i++) urls[i] = f[i].toURI().toURL();
        return urls;
    }

    // Example hook: transform class bytes before defineClass
    // For prototype we rely on remapper.transformClassBytes() when used.
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // Default to parent behavior — later we'll attempt to read class bytes, remap, and define.
        return super.findClass(name);
    }

    // Utility: list top-level entries (for debugging)
    public void listJarContents() {
        for (File jar : jars) {
            try (JarFile j = new JarFile(jar)) {
                Enumeration<? extends ZipEntry> en = j.entries();
                System.out.println("[Beer] Contents of " + jar.getName() + ":");
                while (en.hasMoreElements()) {
                    ZipEntry e = en.nextElement();
                    System.out.println("  - " + e.getName());
                }
            } catch (IOException ex) {
                System.err.println("[Beer] Failed to list " + jar.getName() + ": " + ex.getMessage());
            }
        }
    }
}
