package org.example.view;

import org.example.InputScanner;
import org.example.controller.MapMenuController;
import org.example.model.gameData.Map;
import org.example.view.enums.commands.MapMenuEnum;
import java.util.regex.Matcher;

public class MapMenu {
    public void run()
    {
        Map.setCurrentMap();
        String command;
        InputScanner scanner = new InputScanner();
        Matcher mapMenuMatcher ;
        while (true)
        {
            command = scanner.getScanner().nextLine();
            if(command.matches("\\s*exit\\s*"))
                break;
            else if((mapMenuMatcher = MapMenuEnum.getMatcher(command, MapMenuEnum.SHOW_MAP)) != null)
                showMap(Integer.parseInt(mapMenuMatcher.group("xCoordinate"))
                        , Integer.parseInt(mapMenuMatcher.group("yCoordinate")));
                    //TODO moving on map should be added


        }

    }
    private static void showMap(int x,int y)
    {
        MapMenuController controller = new MapMenuController();
        controller.showMap(x , y);

    }

    private Map showDetails(int x , int y)
    {
        // TODO : only a tile should be shown
        return null;

    }

    public void enterMapEnvironmentSettings() {
    }
    /*
    // TODO : have a guide for map tiles

    private void changeEnvironment(int x, int y)
    {
        //should check
    }*/
}
