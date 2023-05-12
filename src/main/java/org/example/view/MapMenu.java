package org.example.view;

import org.example.InputScanner;
import org.example.controller.MapMenuController;
import org.example.view.enums.commands.MapEnum;

import java.util.Map;
import java.util.regex.Matcher;

public class MapMenu {
    public void run(Matcher matcher) {
        int x , y;
        MapMenuController controller = new MapMenuController();
        controller.setStartingPoint(matcher);
        x = controller.getxStart();
        y = controller.getyStart();
        Matcher mapMenuMatcher;
        String command;
        controller.showMap(x, y);
        while (true) {
            command = InputScanner.getScanner().nextLine();
            if (command.matches("\\s*exit\\s*"))
                break;
            else if ((mapMenuMatcher = MapEnum.getMatcher(command, MapEnum.MAP_MOVING)) != null)
                controller.moving(mapMenuMatcher);
            else if ((mapMenuMatcher = MapEnum.getMatcher(command, MapEnum.MAP_DETAILS)) != null)
                System.out.println(controller.showDetails(mapMenuMatcher));
        }
    }
}
            // TODO : only a tile should be shown  with all information on the show details part


