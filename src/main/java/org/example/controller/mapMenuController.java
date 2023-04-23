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


}

