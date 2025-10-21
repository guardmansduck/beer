#!/bin/bash

# Usage: ./extract-minecraft-data.sh <Minecraft version>
if [ -z "$1" ]; then
    echo "Usage: ./extract-minecraft-data.sh <Minecraft version>"
    exit 1
fi

VERSION=$1
LIBS_DIR="libs"
DATA_DIR="minecraft-data/$VERSION"

mkdir -p "$LIBS_DIR"
mkdir -p "$DATA_DIR/entities" "$DATA_DIR/blocks" "$DATA_DIR/loot_tables"

# Fetch version manifest
MANIFEST_JSON=$(curl -s https://launchermeta.mojang.com/mc/game/version_manifest.json)

# Get version-specific JSON URL
VERSION_URL=$(echo "$MANIFEST_JSON" | jq -r ".versions[] | select(.id==\"$VERSION\") | .url")

if [ -z "$VERSION_URL" ]; then
    echo "Version $VERSION not found in manifest!"
    exit 1
fi

# Fetch version JSON
VERSION_JSON=$(curl -s "$VERSION_URL")

# Get client JAR URL
CLIENT_JAR_URL=$(echo "$VERSION_JSON" | jq -r '.downloads.client.url')

CLIENT_JAR="$LIBS_DIR/minecraft_client_$VERSION.jar"

# Download client JAR if missing
if [ ! -f "$CLIENT_JAR" ]; then
    echo "Downloading Minecraft client $VERSION..."
    curl -L -o "$CLIENT_JAR" "$CLIENT_JAR_URL"
fi

# Extract entity tags
echo "Extracting entity tags..."
unzip -o "$CLIENT_JAR" "data/minecraft/tags/entities/*" -d "$DATA_DIR/entities" >/dev/null

# Extract block tags
echo "Extracting block tags..."
unzip -o "$CLIENT_JAR" "data/minecraft/tags/blocks/*" -d "$DATA_DIR/blocks" >/dev/null

# Extract loot tables
echo "Extracting loot tables..."
unzip -o "$CLIENT_JAR" "data/minecraft/loot_tables/*" -d "$DATA_DIR/loot_tables" >/dev/null

echo "Extraction complete! Data is in $DATA_DIR/"
