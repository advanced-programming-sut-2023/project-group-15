package org.example;

import org.example.model.gameData.Map;
import org.example.view.GameMenu;
import org.example.view.MainMenu;
import org.example.view.MapMenu;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the game!");
        /*new GameMenu().run();

        new MainMenu().run();*/
        //Map.setCurrentMap();
        new MapMenu().run(0,0);
        new MainMenu().run();

        //Map.setCurrentMap();
        //dropBuildingController controller = new dropBuildingController();
       // controller.dropProductiveBuilding(0 , 0 , MILL);
       // new mapMenu().run();
        //System.out.println(map.findATile(0 , 0).getLandType());
       //System.out.println(map.getCurrentMap()[0][0].getBuilding().getName());
    }
}