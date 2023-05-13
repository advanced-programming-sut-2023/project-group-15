package org.example.controller;

import org.example.model.User;
import org.example.model.gameData.GameDataBase;
import org.example.view.MapChangesEnvironment;
import org.example.view.enums.outputs.GameStartMenuOutput;

import java.util.ArrayList;
import java.util.regex.Matcher;

public class StartingGameMenuController {
    private int addingPlayerValidation = 2;
    private boolean newGameAccess = true;
    private final User gameOwner;
    private final ArrayList<User> players = new ArrayList<>();
    static GameInformationController controller = new GameInformationController();
    public StartingGameMenuController(LoginMenuController controller) {
        this.gameOwner = GameDataBase.getUserByUsername(controller.getUsername());
    }
    public void newGame(int mapSize,int mapNumber) {
//        gameOwner.setUserNO(1);
//        GameDataBase.getCurrentUser().setUserNO(1);
        mapSize = InputScanner.getScanner().nextInt();
        System.out.println("now please choose between these 2 maps");
        mapNumber = InputScanner.getScanner().nextInt();
        controller.setMap(mapSize, mapNumber);
//        MapInitialization.run();
        newGameAccess = false;
        players.add(this.gameOwner);
        System.out.println("new game created successfully(test)");
        new MapChangesEnvironment().run();
    }
    public GameStartMenuOutput addUser(Matcher loginMenuMatcher) {
        GameDataBase.setCurrentUser(gameOwner);
        int mapNumber = 0;
        if (addingPlayerValidation>8) {
            return GameStartMenuOutput.PLAYER_CAPACITY_IS_FULL;
        }
        if (GameDataBase.getCurrentUser().getUserNO() == 0) {
            return GameStartMenuOutput.GAME_IS_NOT_STARTED;
        }
        if (GameDataBase.getCurrentUser().getUserNO() != 1)
            return GameStartMenuOutput.ADD_USER_FORBIDDEN;
        else if (GameDataBase.getUserByUsername(loginMenuMatcher.group("name")) == null)
            return GameStartMenuOutput.USER_NOT_FOUND;
        else {
            User newPlayer = GameDataBase.getUserByUsername(loginMenuMatcher.group("name"));
            controller.generateEachPlayerMap(mapNumber);
            controller.playerAdder(newPlayer);
            newPlayer.setUserNO(addingPlayerValidation);
            addingPlayerValidation++;
            players.add(newPlayer);
            return GameStartMenuOutput.ADD_USER_SUCCESS;
        }
    }

    public boolean newGameCheck() {
        return newGameAccess;
    }
}
