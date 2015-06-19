#!/bin/bash

BIN_REPO=http://localhost
BIN_LIST=bin-list

while read FILE; do
      echo "$FILE"
      BASENAME=$(basename "$FILE")
      DIRNAME=$(dirname "$FILE")
      mkdir -p "$DIRNAME"
      curl "$BIN_REPO/$BASENAME" > "$FILE"
      echo ""
done < "$BIN_LIST"
