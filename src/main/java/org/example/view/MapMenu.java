package org.example.view;

import org.example.InputScanner;
import org.example.controller.MapMenuController;
import org.example.view.enums.commands.MapEnum;

import java.util.Map;
import java.util.regex.Matcher;

public class MapMenu {
    private int xStart;
    private int yStart;

    public void run(Matcher matcher) {
        int x = 0, y = 0;
        MapMenuController controller = new MapMenuController();
        controller.setStartingPoint(matcher);
        x = controller.getxStart();
        y = controller.getyStart();
        Matcher mapMenuMatcher;
        String command;
        InputScanner scanner = new InputScanner();
        controller.showMap(x, y);
        while (true) {
            command = scanner.getScanner().nextLine();
            if (command.matches("\\s*exit\\s*"))
                break;
            else if ((mapMenuMatcher = MapEnum.getMatcher(command, MapEnum.MAP_MOVING)) != null)
                controller.moving(mapMenuMatcher);
            else if ((mapMenuMatcher = MapEnum.getMatcher(command, MapEnum.MAP_DETAILS)) != null)
                System.out.println(controller.showDetails(mapMenuMatcher));
               /* System.out.println(controller.showDetails(Integer.parseInt(mapMenuMatcher.group("xCoordinate")),
                        Integer.parseInt(mapMenuMatcher.group("yCoordinate"))));
            /*else if((mapMenuMatcher = MapMenuEnum.getMatcher(command, MapMenuEnum.SHOW_MAP)) != null)
                showMap(Integer.parseInt(mapMenuMatcher.group("xCoordinate"))
                        , Integer.parseInt(mapMenuMatcher.group("yCoordinate")));*/
            //TODO moving on map should be added

        }
    }
}
            // TODO : only a tile should be shown  with all information on the show details part


