package org.example;

import org.example.model.enums.Products;
import org.example.model.enums.StoreProducts;
import org.example.model.gameData.GameDataBase;
import org.example.view.MainMenu;

import org.example.model.User;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the game!");
        new MainMenu().checkUsersFlag();
        new MainMenu().run();
        for (User user : GameDataBase.getAllUsers()) {
            System.out.println("username: " + user.getUsername());
            System.out.println("password: " + user.getPassword());
            System.out.println("email: " + user.getEmail());
            System.out.println("slogan: " + user.getSlogan());
        }
//        new GameMenu().run();
        System.out.println("Welcome to the game!");
        if (Products.APPLE.name().equals(String.valueOf(StoreProducts.APPLE)))
            System.out.println(Products.APPLE.name());
        //new GameMenu().run();
//        new MapChangesEnvironment().testRun();
        //Map.setCurrentMap(400);
      /*  for (int i = 10; i < 15; i++){
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
        mapTemplates.setJasonFile4();*/
//        new GameMenu().run();
        //new MainMenu().run();
        //Map.setCurrentMap();
        // new MapMenu().run(0,0);
        //  new MainMenu().run();

        //Map.setCurrentMap();
        //dropBuildingController controller = new dropBuildingController();
        // controller.dropProductiveBuilding(0 , 0 , MILL);
        // new mapMenu().run();
        //System.out.println(map.findATile(0 , 0).getLandType());
        //System.out.println(map.getCurrentMap()[0][0].getBuilding().getName());
    }
}