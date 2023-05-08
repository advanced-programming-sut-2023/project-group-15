package org.example.controller;

import org.example.model.building.Market;
import org.example.model.enums.Products;
import org.example.model.enums.Source;
import org.example.model.gameData.Government;
import org.example.view.enums.outputs.GameMenuOutput;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class MarketController {




  public static Market market;
    public static int n = 0;




    public static HashMap show1() {
        ++n;
        if(n==1)
            market.setTests();
        return market.getNumber();
    }

    public static HashMap show2() {
        return market.getSellCoin();
    }

    public static HashMap show3() {
        return market.getBuyCoin();
    }

    public static GameMenuOutput sell(String item, int number) {
        if(market.getNumberOfItem(item) >= number){
        market.sellItemNumber(item, number);
        Government.deCoin(number*market.getSellCoin(item));
        return GameMenuOutput.SUCCESSFUL_SELL;}

        else
            return GameMenuOutput.ERROR_SELL;
    }

    public static GameMenuOutput buy(String item, int number) {
        if(Government.getCoins() >= number*market.getBuyCoin(item)){
            market.buyItemNumber(item , number);
            Government.InCoin(number*market.getBuyCoin(item));
            return GameMenuOutput.SUCCESSFUL_BUY;}

            else
                return GameMenuOutput.ERROR_BUY_ITEM;

    }


}
