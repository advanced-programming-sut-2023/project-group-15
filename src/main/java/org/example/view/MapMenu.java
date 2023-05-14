package org.example.view;

import org.example.InputScanner;
import org.example.controller.MapMenuController;
import org.example.view.enums.commands.MapEnum;

import java.util.regex.Matcher;

public class MapMenu {
    public void run(Matcher matcher) {
        int x, y;
        MapMenuController controller = new MapMenuController();
        controller.setStartingPoint(matcher);
        if (controller.getxStart() == -1 || controller.getyStart() == -1) {
            System.out.println("Invalid inputs!");
            return;
        }
        x = controller.getxStart();
        y = controller.getyStart();
        Matcher mapMenuMatcher;
        String command;
        controller.showMap(x, y);
        while (true) {
            command = InputScanner.getScanner().nextLine();
            if (command.matches("\\s*exit\\s*"))
                return;
            else if ((mapMenuMatcher = MapEnum.getMatcher(command, MapEnum.MAP_MOVING)) != null)
                controller.moving(mapMenuMatcher);
            else if ((mapMenuMatcher = MapEnum.getMatcher(command, MapEnum.MAP_DETAILS)) != null && controller.checkMatcher(mapMenuMatcher))
                System.out.println(controller.showDetails(mapMenuMatcher));
            else
                System.out.println("Invalid command!");
        }
    }
}


