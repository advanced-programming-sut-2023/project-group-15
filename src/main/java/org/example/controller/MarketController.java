package org.example.controller;

import org.example.model.building.Market;
import org.example.model.gameData.Government;
import org.example.view.enums.outputs.GameMenuOutput;

import java.util.HashMap;

public class MarketController {
    public Government government;

    public MarketController(String playerName) {
        government = Government.findGovernmentWithUsername(playerName);
    }

    public HashMap<String,Integer> show1() {
        return government.playerMarket().getNumber();
    }

    public HashMap<String,Integer> show2() {
        return government.playerMarket().getSellCoin();
    }

    public HashMap<String,Integer> show3() {
        return government.playerMarket().getBuyCoin();
    }

    public GameMenuOutput sell(String item, int number) {
        if (government.playerMarket().getNumberOfItem(item) >= number) {
            government.playerMarket().sellItemNumber(item, number);
            government.InCoin(number * government.playerMarket().getSellCoin(item));
            government.removeFood(item, number);
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

}
