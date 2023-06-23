package org.example.view;

import org.example.InputScanner;
import org.example.controller.*;
import org.example.controller.userControllers.LoginMenuController;
import org.example.view.enums.commands.BuildingCommandsEnum;
import org.example.view.enums.commands.GameMenuEnum;

import java.util.HashMap;
import java.util.regex.Matcher;

import org.example.controller.GameMenuController;
import org.example.view.enums.commands.MapEnum;
import org.example.view.enums.commands.TradingMenuEnum;
import org.example.view.enums.outputs.BuildingStatusOutput;
import org.example.view.enums.outputs.UnitMenuOutput;

public class GameMenu {

 /*   private final String player;
    private final GameMenuController gameMenuController;
    private final BuildingController buildingController;
    private final UnitMenuController unitMenuController;
    private final MarketController marketController;
    private final TradingMenuController tradingMenuController;

    public GameMenu(LoginMenuController controller) {
        this.player = controller.getUsername();
        this.gameMenuController = new GameMenuController(player);
        this.buildingController = new BuildingController(player);
        this.marketController = new MarketController(player);
        this.tradingMenuController = new TradingMenuController(player);
        this.unitMenuController = new UnitMenuController(player);
    }

    public void run() {
        Matcher gameMenuMatcher;
        String input;
        System.out.println("to quit the game enter: \"exit game\" and for ending your turn enter: \"end turn\"");
        while (true) {
            input = InputScanner.getScanner().nextLine();
            if (input.matches("^\\s*exit\\s+game\\s*$"))
                return;
            else if (input.matches("^\\s*end\\s*turn\\s*$")) {
                System.out.println("changing the turn!!");
                //TODO:
            } else if (input.matches("^\\s*status\\s*$"))
                gameMenuController.governmentStatus();
            else if (input.matches("^\\s*changing\\s+map\\s*$")) {
                new MapChangesEnvironment().run();
            } else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.SHOW_MAP)) != null)
                new MapMenu().showMap(gameMenuMatcher);
            else if ((gameMenuMatcher = MapEnum.getMatcher(input, MapEnum.MAP_MOVING)) != null)
                new MapMenu().mapMoving(gameMenuMatcher);
            else if ((gameMenuMatcher = MapEnum.getMatcher(input, MapEnum.MAP_DETAILS)) != null)
                new MapMenu().mapDetails(gameMenuMatcher);

            else if ((gameMenuMatcher = TradingMenuEnum.getMatcher(input, TradingMenuEnum.TRADE)) != null)
                tradeInputCheck(gameMenuMatcher);
            else if ((gameMenuMatcher = TradingMenuEnum.getMatcher(input, TradingMenuEnum.TRADE_ACCEPT)) != null)
                tradeAccept(gameMenuMatcher);
            else if (TradingMenuEnum.getMatcher(input, TradingMenuEnum.TRADE_HISTORY) != null)
                tradingMenuController.showTradeHistory();
            else if (TradingMenuEnum.getMatcher(input, TradingMenuEnum.TRADE_LIST) != null)
                tradingMenuController.showTradeList();
            else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.SET_TAX_RATE)) != null)
                setTaxRate(gameMenuMatcher);
            else if (GameMenuEnum.getMatcher(input, GameMenuEnum.SHOW_TAX_RATE) != null)
                System.out.println(gameMenuController.showTaxRate());
            else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.SET_FEAR_RATE)) != null)
                setFearRate(gameMenuMatcher);
            else if (GameMenuEnum.getMatcher(input, GameMenuEnum.SHOW_POPULARITY) != null)
                System.out.println(gameMenuController.showPopularity());
            else if (GameMenuEnum.getMatcher(input, GameMenuEnum.SHOW_POPULARITY_FACTORS) != null)
                System.out.println("popularity factors:\n1.food\n2.tax\n3.religion\n4.fear");
            else if (GameMenuEnum.getMatcher(input, GameMenuEnum.SHOW_FOOD_LIST) != null)
                showFoodList();
            else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.SET_FOOD_RATE)) != null)
                setFoodRate(gameMenuMatcher);
            else if (GameMenuEnum.getMatcher(input, GameMenuEnum.SHOW_FOOD_RATE) != null)
                System.out.println(gameMenuController.showFoodRate());

            else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.DROP_UNIT)) != null)
                dropUnit(gameMenuMatcher);
            else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.SELECT_UNIT)) != null)
                selectUnit(gameMenuMatcher);
            else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.MOVE_UNIT)) != null)
                moveUnit(gameMenuMatcher);
            else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.DIG_TUNNEL)) != null)
                digTunnel(gameMenuMatcher);
            else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.SET_STATE)) != null)
                setState(gameMenuMatcher);
            else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.AIR_ATTACK)) != null)
                airAttack(gameMenuMatcher);
            else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.POUR_OIL)) != null)
                pourOil(gameMenuMatcher);
            else if (GameMenuEnum.getMatcher(input, GameMenuEnum.DISBAND_UNIT) != null)
                System.out.println(unitMenuController.disbandUnit().getOutput());
            else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.DIG_DITCH)) != null)
                digDitch(gameMenuMatcher);
            else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.PATROL_UNIT)) != null)
                patrolUnit(gameMenuMatcher);
            else if (GameMenuEnum.getMatcher(input, GameMenuEnum.STOP_PATROLLING) != null)
                //exeption mikhore ehtmaln
                System.out.println(unitMenuController.patrolStop(false, unitMenuController.patX1, unitMenuController.patY1, unitMenuController.patX2, unitMenuController.patY2).getOutput());
            else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.BUILD_EQUIPMENT)) != null)
                System.out.println(unitMenuController.buildEquipment(gameMenuMatcher.group("equipment")).getOutput());

            else if (GameMenuEnum.getMatcher(input, GameMenuEnum.SHOW_PRICE_LIST) != null)
                showPriceList();
            else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.SELL_ITEM)) != null)
                sellItem(gameMenuMatcher);
            else if ((gameMenuMatcher = GameMenuEnum.getMatcher(input, GameMenuEnum.BUY_ITEM)) != null)
                buyItem(gameMenuMatcher);


            else if ((gameMenuMatcher = BuildingCommandsEnum.getMatcher(input, BuildingCommandsEnum.DROP_BUILDING)) != null)
                dropBuilding(gameMenuMatcher);
            else if ((gameMenuMatcher = BuildingCommandsEnum.getMatcher(input, BuildingCommandsEnum.SELECT_BUILDING)) != null)
                selectBuilding(gameMenuMatcher);
            else if (BuildingCommandsEnum.getMatcher(input, BuildingCommandsEnum.REPAIR) != null)
                repair();
            else
                System.out.println("invalid command!");
        }
    }

    private void repair() {
        if (buildingController.isBuildingSelected())
            System.out.println(buildingController.repair());
        else
            System.out.println("you do not select any building!,select your building first");
    }

    private void selectBuilding(Matcher gameMenuMatcher) {
        int x = Integer.parseInt(gameMenuMatcher.group("x"));
        int y = Integer.parseInt(gameMenuMatcher.group("y"));
        if (buildingController.selectBuilding(x, y))
            System.out.println("building selected successfully!");
        else
            System.out.println("there is not any building on selected position!");
    }

    private void tradeAccept(Matcher gameMenuMatcher) {
        int id = Integer.parseInt(gameMenuMatcher.group("number"));
        String message = gameMenuMatcher.group("message");
        if (tradingMenuController.tradeIdCheck(id)) {
            System.out.println(tradingMenuController.acceptRequest(id, message));
        }
        System.out.println("your input id is invalid!");
    }

    private void tradeInputCheck(Matcher gameMenuMatcher) {
        String product = gameMenuMatcher.group("product");
        if (tradingMenuController.productInputCheck(product)) {
            int resourceAmount = Integer.parseInt(gameMenuMatcher.group("resourceAmount"));
            String playerMessage = gameMenuMatcher.group("message");
            int price = Integer.parseInt(gameMenuMatcher.group("price"));
            System.out.println("select one of these players to send the trade request:\nuse \"choose player -u <username>\" command");
            tradingMenuController.showPlayers();
            while (true) {
                String input = InputScanner.getScanner().nextLine();
                if (input.matches("^\\s*quit\\s*$"))
                    return;
                else if ((gameMenuMatcher = TradingMenuEnum.getMatcher(input, TradingMenuEnum.CHOOSE_PLAYER)) != null) {
                    String receiver = gameMenuMatcher.group("username");
                    if (tradingMenuController.selectReceiver(receiver)) {
                        tradingMenuController.sendTradeRequest(product, resourceAmount, playerMessage, price, receiver);
                        System.out.println("trade request sent successfully!");
                    } else System.out.println("the username you entered is not a player in the game!");
                }
            }
        } else {
            System.out.println("your product input is invalid!");
        }
    }

    private void dropBuilding(Matcher gameMenuMatcher) {
        int x = Integer.parseInt(gameMenuMatcher.group("x"));
        int y = Integer.parseInt(gameMenuMatcher.group("y"));
        String type = gameMenuMatcher.group("type");
        if (buildingController.checkTheLand(x, y)) {
            if (!buildingController.checkForBuildingMaterial(type)) {
                System.out.println(BuildingStatusOutput.NOT_ENOUGH_RESOURCES.getOutput());
            } else {
                buildingController.buildingTypeFinder(x, y, type);
            }
            return;
        }
        System.out.println(BuildingStatusOutput.CAN_NOT_DROP_BUILDING.getOutput());
    }

    private void dropUnit(Matcher gameMenuMatcher) {
        int x = Integer.parseInt(gameMenuMatcher.group("x"));
        int y = Integer.parseInt(gameMenuMatcher.group("y"));
        int count = Integer.parseInt(gameMenuMatcher.group("count"));
        String unitName = gameMenuMatcher.group("name");
        for (int i = 0; i < count; i++) {
            //exception mikhore ehtmaln
            System.out.println(unitMenuController.dropUnit(unitName, x, y, count).getOutput());
        }
    }

    private void buyItem(Matcher gameMenuMatcher) {
        if (buildingController.isPlayerHaveStore()) {
            int number = Integer.parseInt(gameMenuMatcher.group("number"));
            System.out.println(marketController.buy(gameMenuMatcher.group("item"), number).getOutput());
        } else
            System.out.println("you don't build the store so you can't use store!");
    }

    private void sellItem(Matcher gameMenuMatcher) {
        if (buildingController.isPlayerHaveStore()) {
            int number = Integer.parseInt(gameMenuMatcher.group("number"));
            System.out.println(marketController.sell(gameMenuMatcher.group("item"), number).getOutput());
        } else
            System.out.println("you don't build the store so you can't use store!");
    }

    private void showPriceList() {
        if (buildingController.isPlayerHaveStore()) {
            System.out.println("Source  " + "number  " + "sell  " + "buy");
            System.out.println("______  " + "_____  " + "_____  " + "___  ");
            HashMap<String, Integer> test = marketController.show1();
            HashMap<String, Integer> test1 = marketController.show2();
            HashMap<String, Integer> test2 = marketController.show3();
            for (String key : test.keySet()) {
                System.out.println(key + "   " + test.get(key) + "     " + test1.get(key) + "     " + test2.get(key));
            }
        } else
            System.out.println("you don't build the store so you can't use store!");
    }

    private void patrolUnit(Matcher gameMenuMatcher) {
        int x1 = Integer.parseInt(gameMenuMatcher.group("x1"));
        int y1 = Integer.parseInt(gameMenuMatcher.group("y1"));
        int x2 = Integer.parseInt(gameMenuMatcher.group("x2"));
        int y2 = Integer.parseInt(gameMenuMatcher.group("y2"));
        if (unitMenuController.isUnitSelected())
            System.out.println(unitMenuController.patrolUnit(x1, y1, x2, y2).getOutput());
        else
            System.out.println(UnitMenuOutput.UNIT_NOT_SELECTED.getOutput());
    }

    private void digDitch(Matcher gameMenuMatcher) {
        int x = Integer.parseInt(gameMenuMatcher.group("x"));
        int y = Integer.parseInt(gameMenuMatcher.group("y"));
        if (unitMenuController.isUnitSelected())
            System.out.println(unitMenuController.digDitch(x, y).getOutput());
        else
            System.out.println(UnitMenuOutput.UNIT_NOT_SELECTED.getOutput());
    }

    private void pourOil(Matcher gameMenuMatcher) {
        String direction = gameMenuMatcher.group("direction");
        if (unitMenuController.isUnitSelected())
            System.out.println(unitMenuController.pourOil(direction).getOutput());
        else
            System.out.println(UnitMenuOutput.UNIT_NOT_SELECTED.getOutput());
    }

    private void airAttack(Matcher gameMenuMatcher) {
        int x = Integer.parseInt(gameMenuMatcher.group("x"));
        int y = Integer.parseInt(gameMenuMatcher.group("y"));
        if (unitMenuController.isUnitSelected())
            System.out.println(unitMenuController.airAttack(x, y).getOutput());
        else
            System.out.println(UnitMenuOutput.UNIT_NOT_SELECTED.getOutput());
    }

    private void setState(Matcher gameMenuMatcher) {
        int x = Integer.parseInt(gameMenuMatcher.group("x"));
        int y = Integer.parseInt(gameMenuMatcher.group("y"));
        String state = gameMenuMatcher.group("state");
        System.out.println(unitMenuController.setState(x, y, state).getOutput());
    }

    private void digTunnel(Matcher gameMenuMatcher) {
        int x = Integer.parseInt(gameMenuMatcher.group("x"));
        int y = Integer.parseInt(gameMenuMatcher.group("y"));
        if (unitMenuController.isUnitSelected())
            System.out.println(unitMenuController.digTunnel(x, y).getOutput());
        else
            System.out.println(UnitMenuOutput.UNIT_NOT_SELECTED.getOutput());
    }

    private void moveUnit(Matcher gameMenuMatcher) {
        int x = Integer.parseInt(gameMenuMatcher.group("x"));
        int y = Integer.parseInt(gameMenuMatcher.group("y"));
        if (unitMenuController.isUnitSelected())
            System.out.println(unitMenuController.moveUnit(x, y).getOutput());
        else
            System.out.println(UnitMenuOutput.UNIT_NOT_SELECTED.getOutput());
    }

    private void selectUnit(Matcher gameMenuMatcher) {
        int x = Integer.parseInt(gameMenuMatcher.group("x"));
        int y = Integer.parseInt(gameMenuMatcher.group("y"));
        System.out.println(unitMenuController.selectUnit(x, y).getOutput());
    }

    private void setFoodRate(Matcher gameMenuMatcher) {
        int rateFood = Integer.parseInt(gameMenuMatcher.group("foodRate"));
        if (gameMenuController.setFoodRateCheckInput(rateFood)) {
            gameMenuController.setFoodRate(rateFood);
            System.out.println("food rate set successfully");
        } else
            System.out.println("invalid input!");
    }

    private void showFoodList() {
        for (Object key : gameMenuController.foodList().keySet()) {
            System.out.println(key + " : " + gameMenuController.foodList().get(key));
        }
    }

    private void setFearRate(Matcher gameMenuMatcher) {
        int rateNumber = Integer.parseInt(gameMenuMatcher.group("fearRate"));
        if (gameMenuController.setFearRateCheckInput(rateNumber)) {
            gameMenuController.setFearRate(rateNumber);
            System.out.println("fear rate set successfully!");
        } else
            System.out.println("invalid input!");
    }

    private void setTaxRate(Matcher gameMenuMatcher) {
        int tax = Integer.parseInt(gameMenuMatcher.group("taxRate"));
        if (gameMenuController.setTaxRateCheckInput(tax)) {
            gameMenuController.setTaxRate(tax);
            System.out.println("tax rate set successfully");
        } else {
            System.out.println("your input is invalid!");
        }
    }
    */
}
