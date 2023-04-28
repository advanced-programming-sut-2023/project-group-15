package org.example.controller;

import org.example.model.Tile;
import org.example.model.gameData.Map;

public class MapMenuEnvironmentController {
    private void setTexture(int x , int y,String type)
    {

    }
    private void setTexture(int x1, int y1,int x2, int y2,String type)
    {

    }
    private void clear(int x , int y)
    {
        Tile currentTile = Map.findATile(x,y);
        currentTile.setBuilding(null);
        currentTile.setTreeName(null);
        currentTile.setSoldier(null);
        currentTile.setRock(false);
    }
    private void dropUnit(int x , int y, String type)
    {

    }
    private void dropBuilding(int x , int y)
    {

    }
    private void dropTree(int x , int y, String type)
    {

    }
    private void dropRock(int x , int y , char direction)
    {

    }

}
