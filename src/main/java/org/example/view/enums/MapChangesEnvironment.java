package org.example.view.enums;

import org.example.InputScanner;
import org.example.model.gameData.GameDataBase;

public class MapChangesEnvironment {
     private static int mapSize;
     private static int playerMapSize;
    public void run()
    {
        if(GameDataBase.getCurrentUser().getUserNO() == 1)
            System.out.println("please enter the size of map that you prefer between 200 & 400");
        mapSize = InputScanner.getScanner().nextInt();
        playerMapSize = mapSize / 8 ;
        System.out.println("now please choose between the map templates");

    }
    private void chooseMap()
    {
        //System.out.println("please choose map template do you prefer");
    }
}
