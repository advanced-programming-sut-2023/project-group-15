package org.example.model.gameData;

import org.example.model.Tile;
import org.example.model.enums.LandType;

public class MapTemplates {
    Tile[][] mapTemplate1 = new Tile[200][200];
    Tile[][] mapTemplate2 = new Tile[200][200];
    Tile[][] mapTemplate3 = new Tile[400][400];
    Tile[][] mapTemplate4 = new Tile[400][400];
    /*private void setMapTemplate1()
    {
        for(int i=0 ; i<200 ; i++)
        {
            for(int j=0 ; j<200 ; j++)
            {
                mapTemplate1[i][j] = new Tile;
            }
        }
        for(int i=10 ; i<15 ; i++)
        {
            for(int j=10 ; j<15 ; j++)
            {
                mapTemplate1[i][j].setLandType(LandType.DENSE_GRASSLAND);
            }
        }
    }*/
    //TODO : map ready templates should be made and saved on a json file
    //TODO : user should be able to choose between maps in the first of the game

}
