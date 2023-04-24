package org.example.model.gameData;

import java.util.ArrayList;
import org.example.model.tile;

public abstract class map {
    int height;
    int weight;
     public static tile[][] currentMap = new tile[200][200];
     public static tile[][]  currentMapB = new tile[400][400];
     public static void setCurrentMap()
     {

             for (int i = 0; i < 200; i++) {
                 for (int j = 0; j < 200; j++) {
                     currentMap[i][j] = new tile();
                 }
             }
         }
    public static void setCurrentMapB()
    {

        for (int i = 0; i < 400; i++) {
            for (int j = 0; j < 400; j++) {
                currentMapB[i][j] = new tile();
            }
        }
    }

    public static tile[][] getCurrentMap() {
        return currentMap;
    }

    public static tile[][] getCurrentMapB() {
        return currentMapB;
    }

    public static tile findATile(int x , int y )
    {
         return currentMap[x][y];
    }
}
