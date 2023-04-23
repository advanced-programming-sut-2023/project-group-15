package org.example.controller;
import org.example.model.map;
import org.example.model.tile;

public class mapMenuController {
    private void showMap(int x , int y)
    {
        tile currentTile = map.getCurrentMap()[x-1][y-1] ;
        tile[][] mapToShow = new tile[10][10];


    }

    /*private String showDetails(int x , int y) {
        if (map.getCurrentMap()[x - 1][y - 1].getBuilding() == null) {
            // return map.findATile(x-1 , y-1).

        }
    }*/

    private void setTexture(int x , int y,String type)
    {

    }
    private void setTexture(int x1, int y1,int x2, int y2,String type)
    {

    }
    private void clear()
    {

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
    private boolean checkLand(int x , int y) {
        return true;
    }
}

