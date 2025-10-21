#!/bin/bash

# Accept version from command line
MC_VERSION=$1

if [ -z "$MC_VERSION" ]; then
    echo "Usage: ./loom.sh <Minecraft version>"
    exit 1
fi

LIBS_DIR="libs"
SRC_DIR="src"
BIN_DIR="bin"

mkdir -p "$LIBS_DIR"
mkdir -p "$BIN_DIR"

# Example: Minecraft jar URLs (replace with real hashes)
MC_CLIENT_JAR_URL="https://launcher.mojang.com/v1/objects/<hash>/${MC_VERSION}_client.jar"
MC_SERVER_JAR_URL="https://launcher.mojang.com/v1/objects/<hash>/${MC_VERSION}_server.jar"

# Download jars if missing
[ ! -f "$LIBS_DIR/minecraft_client_${MC_VERSION}.jar" ] && curl -L -o "$LIBS_DIR/minecraft_client_${MC_VERSION}.jar" "$MC_CLIENT_JAR_URL"
[ ! -f "$LIBS_DIR/minecraft_server_${MC_VERSION}.jar" ] && curl -L -o "$LIBS_DIR/minecraft_server_${MC_VERSION}.jar" "$MC_SERVER_JAR_URL"

# Compile modules
javac -cp "$LIBS_DIR/*" -d "$BIN_DIR" $(find "$SRC_DIR/com/guardmansduck/beer/compat/_${MC_VERSION//./}/" -name "*.java")

echo "Compiled modules for Minecraft $MC_VERSION into $BIN_DIR/"
