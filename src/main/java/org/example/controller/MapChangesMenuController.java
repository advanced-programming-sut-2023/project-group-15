package org.example.controller;
import org.example.model.enums.LandType;
import org.example.model.gameData.Map;

public class MapChangesMenuController {
    private void setTexture(int x , int y,String type)
    {
        for(LandType l : LandType.values())
            if(l.equals(type)) {
             LandType  newLandType = l;
             Map.findATile(x , y).setLandType(newLandType);
            }


    }
    private void setTexture(int x1, int y1,int x2, int y2,String type)
    {

    }
    private void clear(int x , int y)
    {
        Map.findATile(x ,y).setBuilding(null);
        Map.findATile(x , y).setSoldier(null);


    }
    private void dropUnit(int x , int y, String type)
    {
        //TODO list of units should be added to make this method work

    }
    private void dropBuilding(int x , int y , String type)
    {


    }
    private void dropTree(int x , int y, String type)
    {
        // TODO the input string should be matched with the one in enum
        Map.findATile(x , y).setTreeName(type);

    }
    private void dropRock(int x , int y , char direction)
    {
        //TODO direction should be added
        Map.findATile(x,y).setRock();

    }

}