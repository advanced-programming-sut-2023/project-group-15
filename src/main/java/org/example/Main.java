package org.example;

import org.example.model.enums.LandType;
<<<<<<< HEAD
import org.example.model.enums.WaterArea;
=======
>>>>>>> 5b2d190069a17219a3b79b0ff745eb8211fc2fd1
import org.example.model.gameData.Map;
import org.example.model.gameData.MapTemplates;
import org.example.view.GameMenu;
import org.example.view.MainMenu;
import org.example.view.MapMenu;

import static org.example.model.gameData.Map.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the game!");
<<<<<<< HEAD
        //Map.setCurrentMap(400);
      /*  for (int i = 10; i < 15; i++){
            for(int j=60 ; j<65 ;j++)
            {
                Map.getCurrentMap()[i][j].setLandType(LandType.RIVER);
            }
        }
         MapTemplates mapTemplates = new MapTemplates();
=======
       //  MainMenu mainMenu = new MainMenu();
      //   mainMenu.run();
       /* setCurrentMap(400);
        for (int i = 10; i < 15; i++){
            for(int j=60 ; j<65 ;j++)
            {
                getCurrentMap()[i][j].setLandType(LandType.RIVER);
            }
        }*/
      /*   MapTemplates mapTemplates = new MapTemplates();
>>>>>>> 5b2d190069a17219a3b79b0ff745eb8211fc2fd1
        mapTemplates.setMapTemplate1();
        mapTemplates.setJasonFile1();
        mapTemplates.setMapTemplate2();
        mapTemplates.setJasonFile2();
        mapTemplates.setMapTemplate3();
        mapTemplates.setJasonFile3();
        mapTemplates.setMapTemplate4();
        mapTemplates.setJasonFile4();*/
<<<<<<< HEAD
        new GameMenu().run();
        //new MainMenu().run();
=======
       // new GameMenu().run();
        new MainMenu().run();
>>>>>>> 5b2d190069a17219a3b79b0ff745eb8211fc2fd1
        //Map.setCurrentMap();
       // new MapMenu().run(0,0);
    }
}