package org.example.view;

import org.example.InputScanner;
import org.example.controller.dropBuildingController;
import org.example.model.gameData.map;
import org.example.view.enums.commands.GameMenuEnum;

import java.util.regex.Matcher;

import static org.example.model.building.buildingName.MILL;

public class GameMenu {
    public void run()
    {
        map.setCurrentMap();
        dropBuildingController controller = new dropBuildingController();
        controller.dropProductiveBuilding(0 , 0 , MILL);
        InputScanner gameMenuScanner = new InputScanner();
        String command;
        Matcher matcher;
        while(true)
        {
            command = gameMenuScanner.getScanner().nextLine();
            if((matcher = GameMenuEnum.getMatcher(command , GameMenuEnum.SHOW_MAP)) != null)
            {
                new mapMenu().run(Integer.parseInt(matcher.group("xCoordinate"))
                        , Integer.parseInt(matcher.group("yCoordinate")));
            }

        }
    }
}
