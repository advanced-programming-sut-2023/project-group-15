package org.example.controller;

import org.example.model.building.Market;
import org.example.model.gameData.Government;
import org.example.view.enums.outputs.GameMenuOutput;

import java.util.HashMap;

public class MarketController {
    public Market market;
    public Government government;

    public MarketController(String playerName) {
        government = Government.findGovernmentWithUsername(playerName);
    }

    public HashMap show1() {
        return market.getNumber();
    }

    public HashMap show2() {
        return market.getSellCoin();
    }

    public HashMap show3() {
        return market.getBuyCoin();
    }

    public GameMenuOutput sell(String item, int number) {
        if (market.getNumberOfItem(item) >= number) {
            market.sellItemNumber(item, number);
            government.InCoin(number * market.getSellCoin(item));
            government.removeFood(item, number);
            return GameMenuOutput.SUCCESSFUL_SELL;
        } else
            return GameMenuOutput.ERROR_SELL;
    }

    public GameMenuOutput buy(String item, int number) {
        if (government.getCoins() >= number * market.getBuyCoin(item)) {
            market.buyItemNumber(item, number);
            government.deCoin(number * market.getBuyCoin(item));
            government.addFood(item, number);
            return GameMenuOutput.SUCCESSFUL_BUY;
        } else
            return GameMenuOutput.ERROR_BUY_ITEM;

    }

}
