package org.example.view;

import org.example.InputScanner;
import org.example.controller.dropBuildingController;
import org.example.model.gameData.map;
import org.example.view.enums.commands.GameMenuEnum;

import java.util.regex.Matcher;

import static org.example.model.building.buildingName.MILL;

import org.example.InputScanner;
import org.example.controller.GameMenuController;
import org.example.controller.SignupMenuController;
import org.example.view.enums.commands.GameMenuEnum;

import java.util.regex.Matcher;

public class GameMenu {

    private final GameMenuController GameMenuController = new GameMenuController();

    public void run() {
        InputScanner gameMenuScanner = new InputScanner();
        Matcher gameMenuMatcher;
        String input;
        while (true) {
            input = gameMenuScanner.getScanner().nextLine();
            if (input.matches("\\s*exit\\s*"))
                return;
          /*  else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.SET_FOOD_RATE)) != null)
                //
            else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.SET_TAX_RATE)) != null)
                //
            else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.SHOW_FOOD_RATE)) != null)
                System.out.println(GameMenuController.foodrate());
            else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.SHOW_FOOD_RATE)) != null)
                System.out.println(GameMenuController.taxRate());
            else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.SET_FEAR_RATE)) != null)
                //
            else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.SHOW_FOOD_LIST)) != null)
                //
            else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.SHOW_POPULARITY)) != null)
             //   System.out.println(GameMenuController.popularity());
            else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.SHOW_POPULARITY_FACTORS)) != null)
             //   System.out.println(GameMenuController.factors()); */
            //TODO: also most add commands for unit
        }
    }
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

}