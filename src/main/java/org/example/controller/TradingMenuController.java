package org.example.controller;


import org.example.model.User;
import org.example.model.gameData.GameDataBase;
import org.example.model.gameData.GameInformation;
import org.example.model.gameData.Trade;

import java.util.Map;

public class TradingMenuController{
    public void showUserslist() {
        User receiver;
        for (Map.Entry<User, Integer> entry : GameInformation.getPlayers().entrySet())
            System.out.println("User " + entry.getKey().getUsername() + ", UserNo: " + entry.getValue());
        //System.out.println("please choose the user you want to send request to");
        //receiver = GameDataBase.getUserByUsername(InputScanner.getScanner().nextLine());

    }

    public void sendTradeRequest(String name , Trade trade)
    {
        User receiver = GameDataBase.getUserByUsername(name);

    }
    public String showTradeList()
    {
        return null;
    }
    public String showTradeHistory()
    {
     return null;
    }
    public void acceptRequest()
    {

    }

}
