//this class is completed!
package org.example.controller;

import org.example.model.building.Marketplace;
import org.example.model.enums.Products;
import org.example.model.gameData.Government;
import org.example.view.enums.outputs.GameMenuOutput;
import org.example.view.userView.Market;

import java.util.HashMap;

public class MarketController {
    int number = 0 ;
    public Government government = new Government("owner");
    public Marketplace market = new Marketplace("market",10,1,1, Products.ROCK,Products.WOOD,1,1,1);
   /* public MarketController(String playerName) {
        government = Government.findGovernmentWithUsername(playerName);
    }*/
    // return government.playerMarket().getNumber();
    public HashMap<String, Integer> show1() {
        government.setCoins(150.0);
        ++number;
        if(number == 1)
            market.setMarket();

        return market.getNumber();
    }

    public HashMap<String, Integer> show2() {
        return market.getSellCoin();
    }

    public HashMap<String, Integer> show3() {
        return market.getBuyCoin();
    }

    public GameMenuOutput sell(String item, int number) {
        if (market.getNumberOfItem(item) >= number) {
            market.sellItemNumber(item, number);
          //  government.InCoin(number * market.getSellCoin(item));
          //  government.removeFood(item, number);
            return GameMenuOutput.SUCCESSFUL_SELL;
        } else
            return GameMenuOutput.ERROR_SELL;
    }

    public GameMenuOutput buy(String item, int number) {
        if (government.getCoins() >= number * government.playerMarket().getBuyCoin(item)) {
            government.playerMarket().buyItemNumber(item, number);
            government.deCoin(number * government.playerMarket().getBuyCoin(item));
            government.addFood(item, number);
            return GameMenuOutput.SUCCESSFUL_BUY;
        } else
            return GameMenuOutput.ERROR_BUY_ITEM;

    }

    public static void setName(String name){
        System.out.println("ll");
        Marketplace.setName(name);
    }
    public String getName(){
        return Marketplace.getName1();
    }
}
