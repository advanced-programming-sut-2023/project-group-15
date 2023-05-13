package org.example.view;

import org.example.InputScanner;
import org.example.controller.*;
import org.example.view.enums.commands.GameMenuEnum;

import java.util.HashMap;
import java.util.regex.Matcher;

import org.example.controller.GameMenuController;

//change output of food list
public class GameMenu {
    private final GameMenuController gameMenuController = new GameMenuController();
    private final UnitMenuController unitMenuController = new UnitMenuController();
    private final MarketController marketController = new MarketController();
    private final DropUnitController dropUnitController = new DropUnitController();

    public void run() {
        Matcher gameMenuMatcher;
        String input;
        while (true) {
            input = InputScanner.getScanner().nextLine();
            if (input.matches("\\s*exit\\s*"))
                return;
            else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.SHOW_MAP)) != null)
                new MapMenu().run(gameMenuMatcher);
            else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.SET_TAX_RATE)) != null) {
                int tax = Integer.parseInt(gameMenuMatcher.group("taxRate"));
                gameMenuController.setTaxRate(tax);
            } else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.SHOW_TAX_RATE)) != null) {
                System.out.println();
            } else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.SHOW_MAP)) != null)
                new MapMenu().run(gameMenuMatcher);
            else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.SET_FEAR_RATE)) != null) {
                int rateNumber = Integer.parseInt(gameMenuMatcher.group("fearRate"));
                gameMenuController.setFearRate(rateNumber);
            } else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.SHOW_POPULARITY)) != null)
                System.out.println(gameMenuController.popularity());
            else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.SHOW_POPULARITY_FACTORS)) != null)
                System.out.println("popularity factors:\n1.food\n2.tax\n3.religion\n4.fear");
            else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.SHOW_FOOD_LIST)) != null) {
                for (Object key : gameMenuController.foodList().keySet()) {
                    System.out.println(key + " : " + gameMenuController.foodList().get(key));
                }
            } else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.SET_FOOD_RATE)) != null) {
                int rateFood = Integer.parseInt(gameMenuMatcher.group("foodRate"));
                gameMenuController.setFoodRate(rateFood);
            } else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.SHOW_FOOD_RATE)) != null) {
                System.out.println(gameMenuController.showFoodRate());
            } else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.SELECT_UNIT)) != null) {
                int x = Integer.parseInt(gameMenuMatcher.group("x"));
                int y = Integer.parseInt(gameMenuMatcher.group("y"));
                System.out.println(unitMenuController.selectUnit(x, y).getOutput());
            } else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.MOVE_UNIT)) != null) {
                int x = Integer.parseInt(gameMenuMatcher.group("x"));
                int y = Integer.parseInt(gameMenuMatcher.group("y"));
                System.out.println(unitMenuController.moveUnit(x, y).getOutput());
            } else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.DIG_TUNNEL)) != null) {
                int x = Integer.parseInt(gameMenuMatcher.group("x"));
                int y = Integer.parseInt(gameMenuMatcher.group("y"));
                System.out.println(unitMenuController.digTunnel(x, y).getOutput());
            } else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.SET_STATE)) != null) {
                int x = Integer.parseInt(gameMenuMatcher.group("x"));
                int y = Integer.parseInt(gameMenuMatcher.group("y"));
                System.out.println(unitMenuController.setState(x, y,gameMenuMatcher.group("state")).getOutput());

            } else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.AIR_ATTACK)) != null) {
                int x = Integer.parseInt(gameMenuMatcher.group("x"));
                int y = Integer.parseInt(gameMenuMatcher.group("y"));
                System.out.println(unitMenuController.airAttack(x, y).getOutput());
            } else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.POUR_OIL)) != null) {
                System.out.println(unitMenuController.pourOil(gameMenuMatcher.group("direction")).getOutput());
            } else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.DISBAND_UNIT)) != null) {
                System.out.println(unitMenuController.disbandUnit().getOutput());
            } else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.DIG_DITCH)) != null) {
                int x = Integer.parseInt(gameMenuMatcher.group("x"));
                int y = Integer.parseInt(gameMenuMatcher.group("y"));
                System.out.println(unitMenuController.digDitch(x, y).getOutput());

            } else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.PATROL_UNIT)) != null) {

                int x1 = Integer.parseInt(gameMenuMatcher.group("x1"));
                int y1 = Integer.parseInt(gameMenuMatcher.group("y1"));
                int x2 = Integer.parseInt(gameMenuMatcher.group("x2"));
                int y2 = Integer.parseInt(gameMenuMatcher.group("y2"));
                System.out.println(unitMenuController.patrolUnit(x1, y1, x2, y2).getOutput());

            } else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.STOP_PATROLLING)) != null) {
                String s = unitMenuController.patrolStop(false, unitMenuController.patX1, unitMenuController.patY1,
                        unitMenuController.patX2, unitMenuController.patY2).getOutput();
            } else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.BUILD_EQUIPMENT)) != null) {
                System.out.println(unitMenuController.buildEquipment(gameMenuMatcher.group("equipment")).getOutput());
            } else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.SHOW_PRICE_LIST)) != null) {
                System.out.println("Source  " + "number  " + "sell  " + "buy");
                System.out.println("______  " + "_____  " + "_____  " + "___  ");
                HashMap<String, Integer> test = marketController.show1();
                HashMap<String, Integer> test1 = marketController.show2();
                HashMap<String, Integer> test2 = marketController.show3();

                for (String key : test.keySet()) {
                    System.out.println(key + "   " + test.get(key) + "     " + test1.get(key) + "     " + test2.get(key));
                }
            } else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.SELL_ITEM)) != null) {
                int number = Integer.parseInt(gameMenuMatcher.group("number"));
                System.out.println(marketController.sell(gameMenuMatcher.group("item"), number).getOutput());
            } else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.BUY_ITEM)) != null) {
                int number = Integer.parseInt(gameMenuMatcher.group("number"));
                System.out.println(marketController.buy(gameMenuMatcher.group("item"), number).getOutput());
            } else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.DROP_UNIT)) != null) {
                int x = Integer.parseInt(gameMenuMatcher.group("x"));
                int y = Integer.parseInt(gameMenuMatcher.group("y"));
                int count = Integer.parseInt(gameMenuMatcher.group("count"));
                for(int i = 0 ; i != count ; i++){
                    System.out.println(dropUnitController.dropUnit(gameMenuMatcher.group("name"),x,y));
                }
            }
        }
    }
}
