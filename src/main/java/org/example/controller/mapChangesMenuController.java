package org.example.controller;
import org.example.model.enums.LandType;
import org.example.model.map;

public class mapChangesMenuController {
    /*private void setTexture(int x , int y,String type)
    {
        for(LandType l : LandType.values())
            if(l.equals(type)) {
                 newLandType = l;
            }

        map.findATile(x , y).setLandType(newLandType);


    }*/
    private void setTexture(int x1, int y1,int x2, int y2,String type)
    {

    }
    private void clear(int x , int y)
    {
        map.findATile(x ,y).setBuilding(null);
        map.findATile(x , y).setSoldier(null);


    }
    private void dropRock()
    {

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
