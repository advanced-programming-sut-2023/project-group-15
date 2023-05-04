package org.example;

import org.example.model.enums.LandType;
import org.example.model.enums.WaterArea;
import org.example.model.gameData.Map;
import org.example.model.gameData.MapTemplates;
import org.example.view.GameMenu;
import org.example.view.MainMenu;
import org.example.view.MapMenu;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the game!");
        Map.setCurrentMap(400);
        for (int i = 10; i < 15; i++){
            for(int j=60 ; j<65 ;j++)
            {
                Map.getCurrentMap()[i][j].setLandType(LandType.RIVER);
            }
        }
         MapTemplates mapTemplates = new MapTemplates();
        mapTemplates.setMapTemplate1();
        mapTemplates.setJasonFile1();
        mapTemplates.setMapTemplate2();
        mapTemplates.setJasonFile2();
        mapTemplates.setMapTemplate3();
        mapTemplates.setJasonFile3();
        mapTemplates.setMapTemplate4();
        mapTemplates.setJasonFile4();
        new GameMenu().run();
        //new MainMenu().run();
        //Map.setCurrentMap();
       // new MapMenu().run(0,0);
    }
}