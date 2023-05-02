package org.example.view;

import org.example.InputScanner;
import org.example.controller.DropBuildingController;
import org.example.controller.UnitMenuController;
import org.example.model.gameData.Map;
import org.example.view.enums.commands.GameMenuEnum;

import java.util.regex.Matcher;
import org.example.InputScanner;
import org.example.controller.GameMenuController;
import org.example.controller.SignupMenuController;
import org.example.view.enums.commands.GameMenuEnum;

import java.util.regex.Matcher;

public class GameMenu {

    private final GameMenuController GameMenuController = new GameMenuController();
    private UnitMenuController UnitMenuController = new UnitMenuController();

    public void run() {
        InputScanner gameMenuScanner = new InputScanner();
        Matcher gameMenuMatcher;
        String input;
        while (true) {
            input = gameMenuScanner.getScanner().nextLine();
            if (input.matches("\\s*exit\\s*"))
                return;
            else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.SHOW_MAP)) != null) {
                MapMenu mapMenu = new MapMenu();
                mapMenu.run(Integer.parseInt(gameMenuMatcher.group("xCoordiante")),
                        Integer.parseInt(gameMenuMatcher.group("yCoordiante")));
            }
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
            else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.SELECT_UNIT)) != null) {
                int x = Integer.parseInt(gameMenuMatcher.group("x"));
                int y = Integer.parseInt(gameMenuMatcher.group("y"));
                System.out.println(UnitMenuController.selectUnit(x, y).getOutput());
            } else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.MOVE_UNIT)) != null) {
                int x = Integer.parseInt(gameMenuMatcher.group("x"));
                int y = Integer.parseInt(gameMenuMatcher.group("y"));
                System.out.println(UnitMenuController.moveUnit(x, y).getOutput());
            } else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.DIG_TUNNEL)) != null) {
                int x = Integer.parseInt(gameMenuMatcher.group("x"));
                int y = Integer.parseInt(gameMenuMatcher.group("y"));
                System.out.println(UnitMenuController.digTunnel(x, y).getOutput());
            } else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.SET_STATE)) != null) {
                int x = Integer.parseInt(gameMenuMatcher.group("x"));
                int y = Integer.parseInt(gameMenuMatcher.group("y"));
                String state = gameMenuMatcher.group("state").toString();
                System.out.println(UnitMenuController.digTunnel(x, y).getOutput());
            } else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.AIR_ATTACK)) != null) {
                int x = Integer.parseInt(gameMenuMatcher.group("x"));
                int y = Integer.parseInt(gameMenuMatcher.group("y"));
                System.out.println(UnitMenuController.airAttack(x, y).getOutput());
            } else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.POUR_OIL)) != null) {
                System.out.println(UnitMenuController.pourOil(gameMenuMatcher.group("direction")).getOutput());
            } else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.DISBAND_UNIT)) != null) {
                System.out.println(UnitMenuController.disbandUnit().getOutput());
            } else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.DIG_DITCH)) != null) {
                int x = Integer.parseInt(gameMenuMatcher.group("x"));
                int y = Integer.parseInt(gameMenuMatcher.group("y"));
                System.out.println(UnitMenuController.digDitch(x, y).getOutput());
            } else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.PATROL_UNIT)) != null) {
                int x1 = Integer.parseInt(gameMenuMatcher.group("x1"));
                int y1 = Integer.parseInt(gameMenuMatcher.group("y1"));
                int x2 = Integer.parseInt(gameMenuMatcher.group("x2"));
                int y2 = Integer.parseInt(gameMenuMatcher.group("y2"));
                System.out.println(UnitMenuController.patrolUnit(x1, y1, x2, y2).getOutput());
            }
            else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.STOP_PATROLLING)) != null) {
               // UnitMenuController.stopPatrolling = false;
                String s = UnitMenuController.patrolStop(false, UnitMenuController.patX1, UnitMenuController.patY1,
                        UnitMenuController.patX2, UnitMenuController.patY2).getOutput();
            }


        }

    }
}