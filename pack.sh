#!/bin/bash
set -e

# Paths
SRC_DIR="./src/main/com/guardmansduck/beer"
CLASS_DIR="./build/classes"
OUTPUT_DIR="./dist"
JAR_NAME="BeerCompat.jar"

# Clean old build
rm -rf "$CLASS_DIR" "$OUTPUT_DIR"
mkdir -p "$CLASS_DIR" "$OUTPUT_DIR"

# Compile all Java files
echo "Compiling Java sources..."
find "$SRC_DIR" -name "*.java" > sources.txt
javac -d "$CLASS_DIR" @sources.txt
rm sources.txt

# Package into a single JAR
echo "Packaging JAR..."
cd "$CLASS_DIR"
jar cf "$JAR_NAME" *
mv "$JAR_NAME" "$OUTPUT_DIR/"
cd -

echo "✅ JAR created at $OUTPUT_DIR/$JAR_NAME"
