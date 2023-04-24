package org.example.model.gameData;


import org.example.model.Tile;

public abstract class Map {
    int height;
    int weight;
    public static Tile[][] currentMap = new Tile[200][200];
    public static void setCurrentMap()
    {
        for( int i=0 ; i<200 ; i++)
        {
            for (int j=0 ; j<200 ; j++)
            {
                currentMap[i][j] = new Tile();
            }
        }

    }


    public static Tile[][] getCurrentMap() {
        return currentMap;
    }
    public static Tile findATile(int x , int y )
    {
        return currentMap[x][y];
    }
}