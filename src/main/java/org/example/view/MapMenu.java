package org.example.view;

import org.example.InputScanner;
import org.example.controller.MapMenuController;
import org.example.view.enums.commands.MapEnum;

import java.util.regex.Matcher;

public class MapMenu {
    private int xStart;
    private int yStart;

    public void run(Matcher matcher) {
        Matcher mapMenuMatcher;
        String command;
        InputScanner scanner = new InputScanner();
        int x = 0, y = 0;
        MapMenuController controller = new MapMenuController();
        for (int i = 0; i < matcher.groupCount(); i++) {
            if (matcher.group(i) == null)
                continue;
            if (matcher.group(i).equals("x"))
                x = Integer.parseInt(matcher.group(i + 1));
            if (matcher.group(i).equals("y"))
                y = Integer.parseInt(matcher.group(i + 1));
        }
        controller.showMap(x, y);
        while (true) {
            command = scanner.getScanner().nextLine();
            if (command.matches("\\s*exit\\s*"))
                break;
            else if ((mapMenuMatcher = MapEnum.getMatcher(command, MapEnum.MAP_MOVING)) != null) {
                controller.moving(mapMenuMatcher);
            }
           // else if ((mapMenuMatcher = MapEnum.getMatcher(command, MapEnum.MAP_DETAILS)) != null)
             //   System.out.println(controller.showDetails(mapMenuMatcher));
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


