package org.example.view;

import org.example.InputScanner;
import org.example.controller.DropBuildingController;
import org.example.model.gameData.Map;
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
            else if((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.SHOW_MAP)) != null)
                        new MapMenu().run(gameMenuMatcher);
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

}