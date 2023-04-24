package org.example.model.gameData;

import org.example.model.Tile;

public class Map {
    int height;
    int weight;
     public static Tile[][] currentMap = new Tile[200][200];

    public static Tile[][] getCurrentMap() {
        return currentMap;
    }
    public static Tile findATile(int x , int y )
    {
         return currentMap[x-1][y-1];
    }
}
