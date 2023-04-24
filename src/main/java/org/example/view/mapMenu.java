package org.example.view;

import org.example.InputScanner;
import org.example.Main;
import org.example.controller.mapMenuController;
import org.example.model.gameData.map;
import org.example.view.enums.commands.mapMenuEnum;
import java.util.regex.Matcher;

public class mapMenu {
    public void run()
    {
        map.setCurrentMap();
        String command;
        InputScanner scanner = new InputScanner();
        Matcher mapMenuMatcher ;
        while (true)
        {
            command = scanner.getScanner().nextLine();
            if(command.matches("\\s*exit\\s*"))
                break;
            else if((mapMenuMatcher = mapMenuEnum.getMatcher(command,mapMenuEnum.SHOW_MAP)) != null)
                showMap(Integer.parseInt(mapMenuMatcher.group("xCoordinate"))
                        , Integer.parseInt(mapMenuMatcher.group("yCoordinate")));
                    //TODO moving on map should be added


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
