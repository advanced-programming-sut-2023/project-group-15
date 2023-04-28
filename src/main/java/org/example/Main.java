package org.example;

import org.example.view.GameMenu;
import org.example.view.MainMenu;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the game!");
//        new GameMenu().run();
        new MainMenu().run();
    }
}