#!/bin/bash
set -e

# Paths
SRC_DIR="./.Beer/src"
CLASS_DIR="./build/classes"
OUTPUT_DIR="./dist"
OUTPUT_JAR="BeerCompat.jar"
LIBS_DIR="./libs"

echo "Using source directory: $SRC_DIR"

# Clean old build
rm -rf "$CLASS_DIR" "$OUTPUT_DIR"
mkdir -p "$CLASS_DIR" "$OUTPUT_DIR"

# Compile all Java sources with raw javac
echo "Compiling Java sources..."
javac -cp "$LIBS_DIR/*" -d "$CLASS_DIR" $(find "$SRC_DIR" -name "*.java")

# Package into JAR
echo "Packaging JAR..."
cd "$CLASS_DIR"
jar cf "$OUTPUT_JAR" *
mv "$OUTPUT_JAR" "$OUTPUT_DIR/"
cd -

echo "✅ JAR created at $OUTPUT_DIR/$OUTPUT_JAR"
