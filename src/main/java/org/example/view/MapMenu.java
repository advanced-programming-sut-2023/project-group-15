package org.example.view;

import org.example.InputScanner;
import org.example.controller.MapMenuController;
import org.example.view.enums.commands.MapEnum;

import java.util.regex.Matcher;

public class MapMenu {
    private final MapMenuController mapMenuController = new MapMenuController();

    public void run(Matcher matcher) {
        Matcher mapMenuMatcher;
        String command;
        while (true) {
            command = InputScanner.getScanner().nextLine();
            if (command.matches("\\s*exit\\s*"))
                return;
            else if ((mapMenuMatcher = MapEnum.getMatcher(command, MapEnum.MAP_MOVING)) != null)
                mapMoving(mapMenuMatcher);
            else if ((mapMenuMatcher = MapEnum.getMatcher(command, MapEnum.MAP_DETAILS)) != null)
                mapDetails(mapMenuMatcher);
            else
                System.out.println("Invalid command!");
        }
    }

    public void showMap(Matcher matcher) {
        if (checkMapCoordinate(matcher)) {
            int x = Integer.parseInt(matcher.group("x"));
            int y = Integer.parseInt(matcher.group("y"));
            mapMenuController.setxStart(x);
            mapMenuController.setyStart(y);
            mapMenuController.showMap(x, y);
        } else
            System.out.println("invalid coordinates input!");

    }

    public boolean checkMapCoordinate(Matcher matcher) {
        return matcher.group("x") != null && matcher.group("y") == null;
    }

    public void mapMoving(Matcher gameMenuMatcher) {
        mapMenuController.moving(gameMenuMatcher);
    }

    public void mapDetails(Matcher gameMenuMatcher) {
        if (mapMenuController.checkMatcher(gameMenuMatcher)) {
            int x = Integer.parseInt(gameMenuMatcher.group("x"));
            int y = Integer.parseInt(gameMenuMatcher.group("y"));
            System.out.println(mapMenuController.showDetails(x, y));
        } else
            System.out.println("invalid coordinate input!");
    }
}


