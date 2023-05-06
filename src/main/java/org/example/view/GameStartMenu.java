package org.example.view;

import org.example.InputScanner;
import org.example.model.gameData.GameDataBase;
import org.example.view.enums.commands.GameStartMenuEnum;
import org.example.view.enums.commands.MapEnum;

import java.util.regex.Matcher;

public class GameStartMenu {
    public void run()
    {
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


        }
    }
}
