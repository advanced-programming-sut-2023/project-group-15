package org.example;

import org.example.model.building.buildingName;
import org.example.view.MainMenu;
import org.example.model.*;

import static org.example.model.building.buildingName.MILL;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the game!");
        new MainMenu().run();
    }
}