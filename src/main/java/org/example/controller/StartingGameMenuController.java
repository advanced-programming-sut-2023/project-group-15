package org.example.controller;

import org.example.model.User;
import org.example.model.gameData.GameDataBase;
import org.example.model.gameData.GameInformation;
import org.example.model.gameData.Government;
import org.example.view.enums.outputs.GameStartMenuOutput;


public class StartingGameMenuController {
    private final User gameOwner;
    private int userNumberForMapSelection = 2;
    private final GameInformationController controller = new GameInformationController();
    public StartingGameMenuController(LoginMenuController controller) {
        this.gameOwner = GameDataBase.getUserByUsername(controller.getUsername());
    }
    public GameStartMenuOutput newGame(int mapSize,int mapNumber) {
        controller.setMap(mapSize, mapNumber);
        GameInformation.setNewGameAccess(false);
        gameOwner.setUserNO(1);
        controller.generateEachPlayerMap(gameOwner,1);
        gameOwner.setGovernment(new Government(gameOwner.getUsername()));
        GameInformation.addPlayer(gameOwner);
        return GameStartMenuOutput.GAME_STARTED_SUCCESSFULLY;
    }
    public GameStartMenuOutput addUser(String gameOwner,String playerToBeAdded) {
        User owner = GameDataBase.getUserByUsername(gameOwner);
        if (GameInformation.getAllPlayers().size()>8) {
            return GameStartMenuOutput.PLAYER_CAPACITY_IS_FULL;
        } else if (GameInformation.isNewGameAccess()) {
            return GameStartMenuOutput.GAME_IS_NOT_STARTED;
        }
        else if (owner.getUserNO() != 1)
            return GameStartMenuOutput.ADD_USER_FORBIDDEN;
        else {
            User newPlayer = GameDataBase.getUserByUsername(playerToBeAdded);
            newPlayer.setGovernment(new Government(newPlayer.getUsername()));
            GameInformation.addPlayer(newPlayer);
            newPlayer.setUserNO(userNumberForMapSelection);
            controller.generateEachPlayerMap(newPlayer,userNumberForMapSelection);
            userNumberForMapSelection++;
            return GameStartMenuOutput.ADD_USER_SUCCESS;
        }
    }

    public boolean newGameCheck() {
        return GameInformation.isNewGameAccess();
    }
}
