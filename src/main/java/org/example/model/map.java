package org.example.model;

import java.util.ArrayList;

public abstract class map {
    int height;
    int weight;
     public static tile [][] currentMap = new tile[200][200];


    public static tile[][] getCurrentMap() {
        return currentMap;
    }
    public static tile findATile(int x , int y )
    {
         return currentMap[x-1][y-1];
    }
}
