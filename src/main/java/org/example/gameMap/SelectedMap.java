package org.example.gameMap;

public class SelectedMap {
    private final int mapSize;
    private final int mapType;
    private static SelectedMap selectedMap;

    public SelectedMap(int mapSize, int mapType) {
        this.mapSize = mapSize;
        this.mapType = mapType;
        selectedMap = this;
    }

    public int getMapSize() {
        return mapSize;
    }

    public int getMapType() {
        return mapType;
    }

    public static SelectedMap getSelectedMap() {
        return selectedMap;
    }
}
