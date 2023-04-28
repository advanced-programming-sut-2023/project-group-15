package org.example.view;

import org.example.InputScanner;
import org.example.controller.MapMenuController;
import org.example.model.gameData.Map;
import org.example.view.enums.commands.MapMenuEnum;
import java.util.regex.Matcher;

public class MapMenu {
    private int xStart;
     private int yStart;
    public void run(int x , int y )
    {
        MapMenuController controller = new MapMenuController();
        controller.showMap(x,y);
        String command;
        InputScanner scanner = new InputScanner();
        Matcher mapMenuMatcher ;
        while (true)
        {
            command = scanner.getScanner().nextLine();
            if(command.matches("\\s*exit\\s*"))
                break;
            /*else if(mapMenuMatcher = MapMenuEnum.getMatcher(command,MapMenuEnum.moving))
            {
               // controller.moving();

            }*/
            else if((mapMenuMatcher = MapMenuEnum.getMatcher(command,MapMenuEnum.SHOW_MAP_DETAILS)) != null)
                System.out.println(controller.showDetails(Integer.parseInt(mapMenuMatcher.group("xCoordinate")),
                    Integer.parseInt(mapMenuMatcher.group("yCoordinate"))));
            /*else if((mapMenuMatcher = MapMenuEnum.getMatcher(command, MapMenuEnum.SHOW_MAP)) != null)
                showMap(Integer.parseInt(mapMenuMatcher.group("xCoordinate"))
                        , Integer.parseInt(mapMenuMatcher.group("yCoordinate")));*/
                    //TODO moving on map should be added


        }

    }
        // TODO : only a tile should be shown  with all information on the show details part


}
