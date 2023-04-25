package org.example;

import org.example.view.MainMenu;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the game!");
//        Map.setCurrentMap();
        //dropBuildingController controller = new dropBuildingController();
       // controller.dropProductiveBuilding(0 , 0 , MILL);
       // new mapMenu().run();
        new GameMenu().run();

        //System.out.println(map.findATile(0 , 0).getLandType());
       //System.out.println(map.getCurrentMap()[0][0].getBuilding().getName());
        new MainMenu().run();
    }
}