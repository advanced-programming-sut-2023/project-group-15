package org.example.view;

import org.example.InputScanner;
import org.example.controller.BuildingController;
import org.example.controller.MapMenuEnvironmentController;
import org.example.view.enums.commands.MapEnum;

import java.util.regex.Matcher;

public class MapChangesEnvironment {
    public void run() {
        MapMenuEnvironmentController controller = new MapMenuEnvironmentController();
        String command;
        Matcher matcher;
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
            else if ((matcher = MapEnum.getMatcher(command, MapEnum.DROP_BUILDING)) != null)
                new BuildingController().dropBuilding(matcher);
            else if ((matcher = MapEnum.getMatcher(command, MapEnum.DROP_UNIT)) != null) {
//                controller.dropUnit(matcher);
            } else if (command.matches("\\s*exit\\s*")) {
                return;
            } else
                System.out.println("invalid command!");
        }
    }
}
