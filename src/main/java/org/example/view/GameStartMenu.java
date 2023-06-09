package org.example.view;

import org.example.InputScanner;
import org.example.controller.StartingGameMenuController;
import org.example.controller.userControllers.LoginMenuController;
import org.example.model.User;
import org.example.model.gameData.GameInformation;
import org.example.view.enums.commands.GameStartMenuEnum;
import org.example.view.enums.outputs.GameStartMenuOutput;

import java.util.regex.Matcher;

public class GameStartMenu{
    private final StartingGameMenuController startingGameMenuController;
    public GameStartMenu(LoginMenuController controller) {
        startingGameMenuController = new StartingGameMenuController(controller);
    }

    public GameStartMenuOutput addPlayer(String owner, User player) {
        String playerToBeAdded = player.getUsername();
        String output;
        if (GameInformation.checkPlayerExist(playerToBeAdded)){
            if (!GameInformation.checkPlayerExist(playerToBeAdded)) {
                return startingGameMenuController.addUser(owner,playerToBeAdded);
            }
            return GameStartMenuOutput.PLAYER_IN_THE_GAME;
        }
        return GameStartMenuOutput.User_DOESNT_EXIST;
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
                        System.out.println(startingGameMenuController.newGame(mapSize,mapNumber).getOutput());
                        new MapChangesEnvironment().run();
                        return;
                    } else {
                        System.out.println("your inputs are not valid!,\ntry again or enter \"quit\" to cancel the process!");
                    }
                } else if (input.matches("\\s*quit\\s*")) {
                    return;
                } else {
                    System.out.println("invalid command!,enter \"quit\" to cancel the process");
                }
            }
        } else
            System.out.println(GameStartMenuOutput.USER_HAS_STARTED_GAME.getOutput());
    }

    private boolean checkSelectMapInputs(Matcher matcher) {
        if (matcher.group("area").equals("200")||matcher.group("area").equals("400")) {
            return matcher.group("type").equals("1") || matcher.group("type").equals("2");
        }
        return false;
    }
}
