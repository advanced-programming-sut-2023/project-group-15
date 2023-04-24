package org.example;

import org.example.controller.dropBuildingController;
import org.example.model.building.buildingName;
import org.example.model.gameData.map;
import org.example.view.*;
import org.example.model.*;
import org.example.model.GameInformation.*;

import java.util.regex.Matcher;

import static org.example.model.building.buildingName.MILL;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the game!");
        map.setCurrentMap();
        //dropBuildingController controller = new dropBuildingController();
       // controller.dropProductiveBuilding(0 , 0 , MILL);
       // new mapMenu().run();
        //System.out.println(map.findATile(0 , 0).getLandType());
       //System.out.println(map.getCurrentMap()[0][0].getBuilding().getName());

        //new MainMenu().run();
    }
}