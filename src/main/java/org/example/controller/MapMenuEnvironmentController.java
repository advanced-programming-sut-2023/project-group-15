package org.example.controller;

import org.example.model.Tile;
import org.example.model.enums.LandType;
import org.example.model.enums.Tree;
import org.example.model.gameData.Map;

public class MapMenuEnvironmentController {
    private void setTexture(int x , int y,String type)
    {
        Tile currentTile = Map.findATile(x , y);
        for(LandType landType : LandType.values())
            if(landType.equals(type))
                currentTile.setLandType(landType);


    }
    private void setTexture(int x1, int y1,int x2, int y2,String type)
    {

        for(int i=x1 ; i<x2 ; i++)
        {
            for(int j=y1 ; j<y2 ; j++)
            {
                for(LandType landType : LandType.values())
                    if(landType.equals(type))
                        Map.findATile(i,j).setLandType(landType);
            }
        }

    }
    private void clear(int x , int y)
    {
        Tile currentTile = Map.findATile(x,y);
        currentTile.setBuilding(null);
        currentTile.setTreeName(null);
        currentTile.setSoldier(null);
        currentTile.setRock(false,null);
    }
    private void dropUnit(int x , int y, String type)
    {
        //Mobina
    }
    private void dropBuilding(int x , int y)
    {
        //Mahdi
    }
    private void dropTree(int x , int y, String type)
    {
        Tile currentTile = Map.findATile(x , y);
        for(Tree tree : Tree.values())
            if(tree.equals(type))
        currentTile.setTreeName(tree);

    }
    private void dropRock(int x , int y , String direction)
    {
        Tile currentTile = Map.findATile(x , y);
        currentTile.setRock(true,direction);


    }

}
