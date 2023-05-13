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
                    if (checkSelectMapInputs(matcher)) {
                        int mapSize = Integer.parseInt(matcher.group("area"));
                        int mapNumber = Integer.parseInt(matcher.group("type"));
                        startingGameMenuController.newGame(mapSize,mapNumber);
                    } else {
                        System.out.println("your inputs are not valid!,\ntey again!");
                    }
                } else if (input.matches("\\s*quit\\s*")) {
                    return;
                } else {
                    System.out.println("invalid command!,enter \"quit\" to cancel the process");
                }
            }
        } else
            System.out.println(GameStartMenuOutput.USER_HAS_STARTED_GAME);
    }

    private boolean checkSelectMapInputs(Matcher matcher) {
        if (matcher.group("area").equals("200")||matcher.group("area").equals("400")) {
            return matcher.group("type").equals("1") || matcher.group("type").equals("2");
        }
        return false;
    }
}
