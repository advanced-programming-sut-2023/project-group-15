//this class is completed!
package org.example.controller;

import org.example.controller.userControllers.LoginMenuController;
import org.example.model.User;
import org.example.model.gameData.GameDataBase;
import org.example.model.gameData.GameInformation;
import org.example.model.gameData.Government;
import org.example.view.enums.outputs.GameStartMenuOutput;


public class StartingGameMenuController {
    private final User gameOwner;
    private int userNumberForMapSelection = 2;
    private final GameInformationController gameInformationController = new GameInformationController();

    public StartingGameMenuController(LoginMenuController controller) {
        this.gameOwner = GameDataBase.getUserByUsername(controller.getUsername());
    }

    public GameStartMenuOutput newGame(int mapSize, int mapNumber) {
        gameInformationController.setMap(mapSize, mapNumber);
        GameInformation.setNewGameAccess(false);
        gameOwner.setUserNO(1);
        gameInformationController.generateEachPlayerMap(gameOwner, mapSize);
        gameOwner.setGovernment(new Government(gameOwner.getUsername()));
        GameInformation.addPlayer(gameOwner);
        return GameStartMenuOutput.GAME_STARTED_SUCCESSFULLY;
    }

    public GameStartMenuOutput addUser(String gameOwner, String playerToBeAdded) {
        User owner = GameDataBase.getUserByUsername(gameOwner);
        if (GameInformation.getAllPlayers().size() > 7) {
            return GameStartMenuOutput.PLAYER_CAPACITY_IS_FULL;
        } else if (GameInformation.isNewGameAccess()) {
            return GameStartMenuOutput.GAME_IS_NOT_STARTED;
        } else if (owner.getUserNO() != 1)
            return GameStartMenuOutput.ADD_USER_FORBIDDEN;
        else {
            User newPlayer = GameDataBase.getUserByUsername(playerToBeAdded);
            newPlayer.setGovernment(new Government(newPlayer.getUsername()));
            GameInformation.addPlayer(newPlayer);
            newPlayer.setUserNO(userNumberForMapSelection);
            gameInformationController.generateEachPlayerMap(newPlayer, GameInformation.getGameMap().length);
            userNumberForMapSelection++;
            return GameStartMenuOutput.ADD_USER_SUCCESS;
        }
    }

    public boolean newGameCheck() {
        return GameInformation.isNewGameAccess();
    }
}
