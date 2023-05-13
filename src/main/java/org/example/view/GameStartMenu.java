package org.example.view;

import org.example.InputScanner;
import org.example.controller.LoginMenuController;
import org.example.controller.StartingGameMenuController;
import org.example.view.enums.commands.GameStartMenuEnum;
import org.example.view.enums.outputs.GameStartMenuOutput;

import java.util.regex.Matcher;

public class GameStartMenu{
    private final StartingGameMenuController startingGameMenuController;
    public GameStartMenu(LoginMenuController controller) {
        startingGameMenuController = new StartingGameMenuController(controller);
    }

    public void addPlayer(Matcher loginMenuMatcher) {
        System.out.println(startingGameMenuController.addUser(loginMenuMatcher).getOutput());
    }

    public void startNewGame() {
        if (startingGameMenuController.newGameCheck()) {
            Matcher matcher;
            while (true) {
                System.out.println("select your map with this command:\nmap select -a <area> -t <type>\n(area most be 200 or 400,type most be 1 or 2!)");
                String input = InputScanner.getScanner().nextLine();
                if ((matcher = GameStartMenuEnum.getMatcher(input,GameStartMenuEnum.SELECT_MAP))!=null) {
                    //check inputs
                }
            }
            startingGameMenuController.newGame();
        } else
            System.out.println(GameStartMenuOutput.USER_HAS_STARTED_GAME);
    }
}
