package org.example.controller;

import org.example.model.User;
import org.example.model.gameData.GameDataBase;
import org.example.model.gameData.GameInformation;
import org.example.model.gameData.Government;
import org.example.model.gameData.Map;
import org.example.view.MapChangesEnvironment;
import org.example.view.enums.outputs.GameStartMenuOutput;

import java.util.ArrayList;
import java.util.regex.Matcher;

public class StartingGameMenuController {
    private boolean newGameAccess = true;
    private final User gameOwner;
    private int userNumberForMapSelection = 2;
    private final GameInformationController controller = new GameInformationController();
    public StartingGameMenuController(LoginMenuController controller) {
        this.gameOwner = GameDataBase.getUserByUsername(controller.getUsername());
    }
    public void newGame(int mapSize,int mapNumber) {
        controller.setMap(mapSize, mapNumber);
        gameOwner.setUserNO(1);
        controller.generateEachPlayerMap(1);
        newGameAccess = false;
        gameOwner.setGovernment(new Government(gameOwner.getUsername()));
        GameInformation.addPlayer(gameOwner);
        System.out.println("new game created successfully(test)");
        new MapChangesEnvironment().run();
    }
    public GameStartMenuOutput addUser(String playerToBeAdded) {
        GameDataBase.setCurrentUser(gameOwner);
        if (GameInformation.getAllPlayers().size()>8) {
            return GameStartMenuOutput.PLAYER_CAPACITY_IS_FULL;
        }
        else if (newGameAccess) {
            return GameStartMenuOutput.GAME_IS_NOT_STARTED;
        }
        else if (gameOwner.getUserNO() != 1)
            return GameStartMenuOutput.ADD_USER_FORBIDDEN;
        else {
            User newPlayer = GameDataBase.getUserByUsername(playerToBeAdded);
            newPlayer.setGovernment(new Government(newPlayer.getUsername()));
            GameInformation.addPlayer(newPlayer);
            controller.generateEachPlayerMap(userNumberForMapSelection);
            userNumberForMapSelection++;
            return GameStartMenuOutput.ADD_USER_SUCCESS;
        }
    }

    public boolean newGameCheck() {
        return newGameAccess;
    }
}
