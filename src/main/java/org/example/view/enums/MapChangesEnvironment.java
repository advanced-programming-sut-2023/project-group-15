package org.example.view.enums;

import org.example.InputScanner;
import org.example.controller.MapMenuEnvironmentController;
import org.example.model.gameData.GameDataBase;
import org.example.model.gameData.Map;
import org.example.view.enums.commands.MapEnum;

import java.util.regex.Matcher;

public class MapChangesEnvironment {
    public void run()
    {
        MapMenuEnvironmentController controller = new MapMenuEnvironmentController();
        String command;
        int mapNumber;
        int mapsize;
        int playerNo = GameDataBase.getCurrentUser().getUserNO();
        Matcher matcher;
        if(playerNo== 1) {
            System.out.println("please enter the size of map that you prefer between 200 & 400");
            mapsize = InputScanner.getScanner().nextInt();
            System.out.println("now please enter the map number you want");
            mapNumber = InputScanner.getScanner().nextInt();
            switch (mapNumber)
            {
                //TODO read and set from the file
            }
            controller.generateEachPlayerMap(playerNo, mapNumber);
            //TODO the first players map would be generated hear
            System.out.println("now please enter the changes you wish to make in the map");

        }

        while(true)
        {
            command = InputScanner.getScanner().nextLine();
            if((matcher = MapEnum.getMatcher(command,MapEnum.SET_TEXTURE)) != null)
            controller.setTileTexture(matcher);
            else if((matcher = MapEnum.getMatcher(command,MapEnum.SET_TEXTURE2)) != null)
                controller.setTexture(matcher);
            else if((matcher = MapEnum.getMatcher(command,MapEnum.CLEAR)) != null)
                controller.clear(matcher);
            else if((matcher = MapEnum.getMatcher(command,MapEnum.DROP_ROCK)) != null)
                controller.dropRock(matcher);
            else if((matcher = MapEnum.getMatcher(command,MapEnum.DROP_TREE)) != null)
                controller.dropTree(matcher);
            else if((matcher = MapEnum.getMatcher(command,MapEnum.DROP_BUILDING)) !=null)
            controller.dropBuilding(matcher);
            else if((matcher = MapEnum.getMatcher(command,MapEnum.DROP_UNIT)) != null)
                controller.dropUnit(matcher);

        }



    }
}
