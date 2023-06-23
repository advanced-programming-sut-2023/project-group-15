package org.example;


import javafx.stage.Stage;
import org.example.controller.userControllers.MainMenuController;
import org.example.view.ScoreBoard;


public class Main {

    public static void main(String[] args) {
        new ScoreBoard().start(new Stage());
        //this is the push
        System.out.println("Welcome to the game!");
       // new MainMenuController().checkJsonDirectory();
    }
}