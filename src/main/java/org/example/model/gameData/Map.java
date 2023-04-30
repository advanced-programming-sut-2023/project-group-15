package org.example.model.gameData;

import org.example.model.Tile;

public abstract class Map {
     private static int  mapSize;
     private int playerMapLength;
     private int playerMapWidth;
     public static Tile[][] currentMap = new Tile[400][];


    public static void setCurrentMap(int size)
     {

             for (int i = 0; i <size; i++) {
                 for (int j = 0; j < size; j++) {
                     currentMap[i][j] = new Tile();
                 }
             }
         }

    public static void setMapSize(int mapSize) {
        Map.mapSize = mapSize;
    }

    public void setPlayerMapLength(int playerMapLength) {
        this.playerMapLength = playerMapLength;
    }

    public void setPlayerMapWidth(int playerMapWidth) {
        this.playerMapWidth = playerMapWidth;
    }

    public static Tile[][] getCurrentMap() {
        return currentMap;
    }

    public static Tile findATile(int x , int y )
    {
         return currentMap[x][y];
    }
}
