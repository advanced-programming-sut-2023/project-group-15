package org.example.view;

import org.example.InputScanner;
import org.example.controller.GameInformationController;
import org.example.controller.LoginMenuController;
import org.example.model.User;
import org.example.model.gameData.GameDataBase;
import org.example.view.enums.outputs.GameStartMenuOutput;

import java.util.regex.Matcher;

public class GameStartMenu{
    static GameInformationController controller = new GameInformationController();
    public void newGame(Matcher loginMenuMatcher, LoginMenuController loginMenuController) {
        int mapNumber;
        int mapSize;
        GameDataBase.getCurrentUser().setUserNO(1);
        System.out.println("please enter the size of map that you prefer between 200 & 400");
        mapSize = InputScanner.getScanner().nextInt();
        System.out.println("now please choose between these 2 maps");
        mapNumber = InputScanner.getScanner().nextInt();
        controller.setMap(mapSize, mapNumber);
        MapInitialization.run();
    }
    public void addUser(Matcher loginMenuMatcher, LoginMenuController loginMenuController) {
        int mapNumber = 0;
        if (GameDataBase.getCurrentUser().getUserNO() != 1)
            System.out.println(GameStartMenuOutput.ADD_USER_FORBIDDEN);
        else if (GameDataBase.getUserByUsername(loginMenuMatcher.group("name")) == null)
            System.out.println(GameStartMenuOutput.USER_NOT_FOUND);
        else {
            User newPlayer = GameDataBase.getUserByUsername(loginMenuMatcher.group("name"));
            controller.generateEachPlayerMap(mapNumber);
            controller.playerAdder(newPlayer);
            System.out.println(GameStartMenuOutput.ADD_USER_SUCCESS);
        }
    }
    public void loadGame(Matcher loginMenuMatcher, LoginMenuController loginMenuController) {
        //TODO: later...
    }
}
