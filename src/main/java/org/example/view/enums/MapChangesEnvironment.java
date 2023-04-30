package org.example.view.enums;

import org.example.InputScanner;
import org.example.controller.MapMenuEnvironmentController;
import org.example.model.gameData.GameDataBase;
import org.example.model.gameData.Map;
import org.example.view.enums.commands.MapEnvironmentEnum;

import java.util.regex.Matcher;

public class MapChangesEnvironment {
    public void run()
    {
        MapMenuEnvironmentController controller = new MapMenuEnvironmentController();
        String command;
        int mapNumber;
        int mapsize;
        Matcher matcher;
        if(GameDataBase.getCurrentUser().getUserNO() == 1) {
            System.out.println("please enter the size of map that you prefer between 200 & 400");
            mapsize = InputScanner.getScanner().nextInt();
            //TODO show a brief of the maps
            System.out.println("now please enter the map number you want");
            mapNumber = InputScanner.getScanner().nextInt();
            //TODO the first players map would be generated hear
            System.out.println("now please enter the changes you wish to make in the map");
            //TODO choose between map template and set the map game

        }
        while(true)
        {
            command = InputScanner.getScanner().nextLine();
            if((matcher = MapEnvironmentEnum.getMatcher(command,MapEnvironmentEnum.MAP_MOVING)) != null)
            {

            }


        }



    }
    private void chooseMap()
    {
        //System.out.println("please choose map template do you prefer");
    }
}
