package org.example.view;

import org.example.InputScanner;
import org.example.view.enums.commands.GameMenuEnum;

import java.util.regex.Matcher;

import org.example.controller.GameMenuController;

public class GameMenu {
    private final GameMenuController GameMenuController = new GameMenuController();

    public void run() {
        Matcher gameMenuMatcher;
        String input;
        while (true) {
            input = InputScanner.getScanner().nextLine();
            if (input.matches("\\s*exit\\s*"))
                return;
            else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.SHOW_MAP)) != null) {
                MapMenu mapMenu = new MapMenu();
                mapMenu.run(Integer.parseInt(gameMenuMatcher.group("xCoordinate")),
                        Integer.parseInt(gameMenuMatcher.group("yCoordinate")));
            }
          /*  else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.SET_FOOD_RATE)) != null)
                //
            else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.SET_TAX_RATE)) != null)
                //
            else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.SHOW_FOOD_RATE)) != null)
                System.out.println(GameMenuController.foodRate());
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