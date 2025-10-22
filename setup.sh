#!/bin/bash
set -e

# --- Variables ---
MC_VERSION="1.21.10"
FABRIC_INSTALLER_VERSION="0.14.28"
FABRIC_API_BUILD="1.21.10+build.30"

LIBS_DIR="./libs"
SRC_DIR="./.Beer/src"
PACK_SCRIPT="./pack.sh"

# --- Create libs folder ---
mkdir -p "$LIBS_DIR"

echo "📥 Downloading Fabric installer..."
curl -L -o "$LIBS_DIR/fabric-installer.jar" \
  "https://maven.fabricmc.net/net/fabricmc/fabric-installer/$FABRIC_INSTALLER_VERSION/fabric-installer-$FABRIC_INSTALLER_VERSION.jar"

echo "📥 Downloading Fabric API for $MC_VERSION..."
curl -L -o "$LIBS_DIR/fabric-api-$MC_VERSION.jar" \
  "https://maven.fabricmc.net/net/fabricmc/fabric-api/fabric-api/$FABRIC_API_BUILD/fabric-api-$FABRIC_API_BUILD.jar"

echo "✅ Downloads complete."

# --- Make pack.sh executable ---
if [ -f "$PACK_SCRIPT" ]; then
    chmod +x "$PACK_SCRIPT"
    echo "✅ pack.sh is now executable."
else
    echo "⚠️ pack.sh not found. Make sure it exists in the repo root."
fi

echo "🎉 Setup complete. You can now run ./pack.sh to build BeerCompat."
