package org.example.view;

import org.example.InputScanner;
import org.example.controller.mapMenuController;
import org.example.model.gameData.map;
import org.example.view.enums.commands.mapMenuEnum;

import java.util.regex.Matcher;

public class mapMenu {
    private void run(Matcher matcher)
    {
        String command;
        InputScanner scanner = new InputScanner();
        while (true)
        {
            command = scanner.getScanner().nextLine();
            if(command.matches("\\s*exit\\s*"))
                break;
            else if(mapMenuEnum.getMatcher(command,mapMenuEnum.SHOW_MAP) != null)
                showMap(Integer.parseInt(matcher.group("xCoordinate"))
                        , Integer.parseInt(matcher.group("yCoordinate")));
                    //TODO moving on map is not available now


        }

    }
    private static void showMap(int x,int y)
    {
        mapMenuController controller = new mapMenuController();
        controller.showMap(x , y);

    }

    private map showDetails(int x , int y)
    {
        // TODO : only a tile should be shown
        return null;

    }
}
