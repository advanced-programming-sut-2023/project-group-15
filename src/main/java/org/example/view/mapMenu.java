package org.example.view;

import org.example.InputScanner;
import org.example.Main;
import org.example.controller.mapMenuController;
import org.example.model.gameData.map;
import org.example.view.enums.commands.mapMenuEnum;
import java.util.regex.Matcher;

public class mapMenu {
    public void run(int x , int y )
    {
        showMap(x , y);
        String command;
        InputScanner scanner = new InputScanner();
        Matcher mapMenuMatcher ;
        while (true)
        {
            command = scanner.getScanner().nextLine();
            if(command.matches("\\s*exit\\s*"))
                break;
            else if((mapMenuMatcher = mapMenuEnum.getMatcher(command,mapMenuEnum.SHOW_MAP_DETAILS)) != null)
            showDetails(Integer.parseInt(mapMenuMatcher.group("xCoordinate")),
                    Integer.parseInt(mapMenuMatcher.group("yCoordinate")));




        }

    }
    private static void showMap(int x,int y)
    {
        mapMenuController controller = new mapMenuController();
        controller.showMap(x , y);
        //TODO moving on map should be added
    }

    private map showDetails(int x , int y)
    {
        // TODO : only a tile should be shown  with all information on it
        return null;

    }
}
