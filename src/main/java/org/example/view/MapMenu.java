package org.example.view;

import org.example.InputScanner;
import org.example.controller.MapMenuController;
import org.example.model.gameData.Map;
import org.example.view.enums.commands.MapMenuEnum;
import java.util.regex.Matcher;

public class MapMenu {
    public void run(int x , int y )
    {
        Map.setCurrentMap();
        showMap(x , y);
        String command;
        InputScanner scanner = new InputScanner();
        Matcher mapMenuMatcher ;
        while (true)
        {
            command = scanner.getScanner().nextLine();
            if(command.matches("\\s*exit\\s*"))
                break;
            else if((mapMenuMatcher = MapMenuEnum.getMatcher(command,MapMenuEnum.SHOW_MAP_DETAILS)) != null)
            showDetails(Integer.parseInt(mapMenuMatcher.group("xCoordinate")),
                    Integer.parseInt(mapMenuMatcher.group("yCoordinate")));


            /*else if((mapMenuMatcher = MapMenuEnum.getMatcher(command, MapMenuEnum.SHOW_MAP)) != null)
                showMap(Integer.parseInt(mapMenuMatcher.group("xCoordinate"))
                        , Integer.parseInt(mapMenuMatcher.group("yCoordinate")));*/
                    //TODO moving on map should be added


        }

    }
    private static void showMap(int x,int y)
    {
        MapMenuController controller = new MapMenuController();
        controller.showMap(x , y);
        //TODO moving on map should be added
    }

    private String showDetails(int x , int y)
    {
        // TODO : only a tile should be shown  with all information on it
        return null;

    }
}
