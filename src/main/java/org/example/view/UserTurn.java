package org.example.view;

import org.example.controller.LoginMenuController;
import org.example.controller.UserTurnController;
import org.example.model.gameData.GameDataBase;
import org.example.view.enums.outputs.GameStartMenuOutput;

public class UserTurn {
    private final UserTurnController userTurnController;
    private final LoginMenuController userController;

    public UserTurn(LoginMenuController controller) {
        this.userController = controller;
        this.userTurnController = new UserTurnController(GameDataBase.getUserByUsername(controller.getUsername()));
    }

    public void selectMap() {
        System.out.println("first you need to pick up your map!");

    }

    public void run() {
    }


    public void enterGame() {
        if (userTurnController.checkUserTurn()) {
            run();
            //mire to bazi
        } else
            System.out.println(GameStartMenuOutput.NOT_YOUR_TURN.getOutput());
    }
}
