package org.example.view;

import org.example.InputScanner;
import org.example.controller.GameInformationController;
import org.example.model.User;
import org.example.model.gameData.GameDataBase;
import org.example.model.gameData.GameInformation;
import org.example.model.gameData.Government;
import org.example.view.enums.commands.GameStartMenuEnum;
import org.example.view.enums.commands.MapEnum;
import org.example.view.enums.outputs.GameMenuOutput;
import org.example.view.enums.outputs.GameStartMenuOutput;

import java.util.regex.Matcher;

public class GameStartMenu {
    public void run()
    {
        GameInformationController controller = new GameInformationController();
        String input;
        Matcher gameStartMatcher;
        while(true)
        {
            input = InputScanner.getScanner().nextLine();
            if((gameStartMatcher = GameStartMenuEnum.getMatcher(input,GameStartMenuEnum.NEW_GAME)) != null)
            {
                GameDataBase.getCurrentUser().setUserNO(1);
                MapInitialization.run();
            }
            if((gameStartMatcher = GameStartMenuEnum.getMatcher(input,GameStartMenuEnum.ADD_PLAYER)) != null)
            {
                if(GameDataBase.getCurrentUser().getUserNO() != 1)
                    System.out.println(GameStartMenuOutput.ADD_USER_FORBIDDEN);

                else if(GameDataBase.getUserByUsername(gameStartMatcher.group("name")) == null)
                    System.out.println(GameStartMenuOutput.USER_NOT_FOUND);
                else {
                    User newPlayer = GameDataBase.getUserByUsername(gameStartMatcher.group("name"));
                    controller.playerAdder(newPlayer);
                    System.out.println(GameStartMenuOutput.ADD_USER_SUCCESS);
                }
            }



        }
    }
}
