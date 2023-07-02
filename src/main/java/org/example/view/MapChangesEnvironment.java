package org.example.view;

import org.example.InputScanner;
import org.example.controller.MapMenuEnvironmentController;
import org.example.view.enums.commands.GameMenuEnum;
import org.example.view.enums.commands.MapEnum;

import java.util.regex.Matcher;

public class MapChangesEnvironment {
    private final MapMenuEnvironmentController mapMenuEnvironmentController = new MapMenuEnvironmentController();

    public void run() {
        String command;
        Matcher matcher;
        System.out.println("this menu is just for testing map and debugging!");
        while (true) {
            command = InputScanner.getScanner().nextLine();
            if (command.matches("^\\s*exit\\s*$"))
                return;
            else if ((matcher = MapEnum.getMatcher(command, MapEnum.SET_TEXTURE)) != null)
                setTileTextureCheck(matcher);
            else if ((matcher = MapEnum.getMatcher(command, MapEnum.SET_TEXTURE2)) != null)
                setTileTextureCheckTwoCoordinate(matcher);
            else if ((matcher = MapEnum.getMatcher(command, MapEnum.CLEAR)) != null)
                clearArea(matcher);
            else if ((matcher = MapEnum.getMatcher(command, MapEnum.DROP_ROCK)) != null)
                dropRock(matcher);
            else if ((matcher = MapEnum.getMatcher(command, MapEnum.DROP_TREE)) != null)
                dropTree(matcher);
            else if ((matcher = MapEnum.getMatcher(command, MapEnum.MAP_MOVING)) != null)
                new MapMenu().mapMoving(matcher);
            else if ((matcher = MapEnum.getMatcher(command, MapEnum.MAP_DETAILS)) != null)
                new MapMenu().mapDetails(matcher);
            else if ((matcher = GameMenuEnum.getMatcher(command, GameMenuEnum.SHOW_MAP)) != null)
                new MapMenu().showMap(matcher);
            else
                System.out.println("invalid command!");
        }
    }

    private void dropTree(Matcher matcher) {
        int x = Integer.parseInt(matcher.group("x"));
        int y = Integer.parseInt(matcher.group("y"));
        String type = matcher.group("type");
        if (mapMenuEnvironmentController.treeTypeCheck(type)) {
            mapMenuEnvironmentController.dropTree(x, y, type);
            System.out.println("tree set in the map successfully");
        } else
            System.out.println("your input is invalid!");
    }

    private void dropRock(Matcher matcher) {
        int x = Integer.parseInt(matcher.group("x"));
        int y = Integer.parseInt(matcher.group("y"));
        String direction = matcher.group("direction");
        if (MapMenuEnvironmentController.findDirection(direction).getDirection() != null) {
            mapMenuEnvironmentController.dropRock(x, y, MapMenuEnvironmentController.findDirection(direction).getDirection());
            System.out.println("rock dropped successfully");
        } else
            System.out.println("your input is invalid!");
    }

    private void clearArea(Matcher matcher) {
        int x = Integer.parseInt(matcher.group("x"));
        int y = Integer.parseInt(matcher.group("y"));
        mapMenuEnvironmentController.clear(x, y);
        System.out.println("field cleared successfully!");
    }

    private void setTileTextureCheckTwoCoordinate(Matcher matcher) {
        int x1 = Integer.parseInt(matcher.group("x1"));
        int y1 = Integer.parseInt(matcher.group("y1"));
        int x2 = Integer.parseInt(matcher.group("x2"));
        int y2 = Integer.parseInt(matcher.group("y2"));
        String type = matcher.group("type");
        if (mapMenuEnvironmentController.checkLandType(type)) {
            mapMenuEnvironmentController.setTextureTwoCoordinate(x1, y1, x2, y2, type);
            System.out.println("texture set successfully");
        } else
            System.out.println("your input is not valid!");
    }

    public void setTileTextureCheck(Matcher matcher) {
        int x = Integer.parseInt(matcher.group("x"));
        int y = Integer.parseInt(matcher.group("y"));
        String type = matcher.group("type");
        if (mapMenuEnvironmentController.checkLandType(type)) {
            if (mapMenuEnvironmentController.setTextureOneCoordinate(x, y, type))
                System.out.println("texture set successfully");
            else
                System.out.println("texture doesn't set");
        } else
            System.out.println("your input is not valid!");
    }
}
