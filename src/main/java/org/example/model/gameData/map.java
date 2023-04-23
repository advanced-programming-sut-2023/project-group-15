package org.example.model.gameData;

import java.util.ArrayList;
import org.example.model.tile;

public abstract class map {
    int height;
    int weight;
     public static tile[][] currentMap = new tile[200][200];


    public static tile[][] getCurrentMap() {
        return currentMap;
    }
    public static tile findATile(int x , int y )
    {
         return currentMap[x-1][y-1];
    }
}
