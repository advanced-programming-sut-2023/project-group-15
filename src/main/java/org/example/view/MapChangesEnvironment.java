package org.example.view;

import org.example.InputScanner;
import org.example.controller.MapMenuEnvironmentController;
import org.example.view.enums.commands.MapEnum;

import java.util.regex.Matcher;

public class MapChangesEnvironment {
    public void run() {
        MapMenuEnvironmentController controller = new MapMenuEnvironmentController();

        String command;
        Matcher matcher;
        System.out.println("this menu is just for testing map and debugging!");
        while (true) {
            command = InputScanner.getScanner().nextLine();
            if (command.matches("^\\s*exit\\s*$"))
                return;
            else if ((matcher = MapEnum.getMatcher(command, MapEnum.SET_TEXTURE)) != null)
                controller.setTileTexture(matcher);
            else if ((matcher = MapEnum.getMatcher(command, MapEnum.SET_TEXTURE2)) != null)
                controller.setTexture(matcher);
            else if ((matcher = MapEnum.getMatcher(command, MapEnum.CLEAR)) != null)
                controller.clear(matcher);
            else if ((matcher = MapEnum.getMatcher(command, MapEnum.DROP_ROCK)) != null)
                controller.dropRock(matcher);
            else if ((matcher = MapEnum.getMatcher(command, MapEnum.DROP_TREE)) != null)
                controller.dropTree(matcher);
            //TODO: inja bayd map set bshe bad ....
//            else if ((matcher = MapEnum.getMatcher(command, MapEnum.MAP_MOVING)) != null)
//                controller.moving(matcher);
//            else if ((matcher = MapEnum.getMatcher(command, MapEnum.MAP_DETAILS)) != null && controller.checkMatcher(mapMenuMatcher))
//                System.out.println(controller.showDetails(matcher));
            else
                System.out.println("invalid command!");
        }
    }
}
