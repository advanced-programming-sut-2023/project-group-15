package org.example.controller;


import org.example.model.User;
import org.example.model.building.Storage;
import org.example.model.enums.Products;
import org.example.model.enums.StoreProducts;
import org.example.model.gameData.GameDataBase;
import org.example.model.gameData.GameInformation;
import org.example.model.gameData.Trade;
import org.example.view.enums.outputs.GameInformationOutput;

import java.util.Map;
import java.util.regex.Matcher;

public class TradingMenuController{
    public void showUserslist() {
        User receiver;
        for (Map.Entry<User, Integer> entry : GameInformation.getPlayers().entrySet())
            System.out.println("User " + entry.getKey().getUsername() + ", UserNo: " + entry.getValue());
        //System.out.println("please choose the user you want to send request to");
        //receiver = GameDataBase.getUserByUsername(InputScanner.getScanner().nextLine());

    }

    public void sendTradeRequest(Matcher matcher , String name)
    {
        if(Utility.groupFinder(matcher , "-t") == null || Utility.groupFinder(matcher , "-p") == null
        || Utility.groupFinder(matcher , "-m") == null || Utility.groupFinder(matcher , "-a") == null)
        {
            System.out.println("invalid command");
            return;
        }
        String productName = Utility.groupFinder(matcher , "-t");
        Products product = Products.getproductByName(productName);
        double price = Double.parseDouble(Utility.groupFinder(matcher , "-p"));
        int amount = Integer.parseInt(Utility.groupFinder(matcher , "-a"));
        String message = Utility.groupFinder(matcher , "-m");
        User receiver = GameDataBase.getUserByUsername(name);
        User sender = GameDataBase.getCurrentUser();
        Trade newTrade = new Trade( sender, receiver ,amount , product , message , price );
        sender.getTradeList().add(newTrade);
        receiver.getTradeList().add(newTrade);


    }
    public String showTradeList()
    {
        return null;
    }
    public String showTradeHistory()
    {

        return null;
    }
    public void acceptRequest(Trade trade) {
        Storage storage = null;
        String message1 = GameInformation.checkForSources(trade.getProduct(), trade.getAmount());
        if (message1.equals(GameInformationOutput.NOT_ENOUGH)) {
            System.out.println(message1);
            return;
        }
        if (trade.getSender().getGovernment().getCoins() < trade.getAmount() * trade.getPrice())
        {
            System.out.println("not enough coins for the trade sender");
            return;
        }

        if(message1.equals(GameInformationOutput.SUCCESS))
        {
            for(StoreProducts storeProducts : StoreProducts.values())
            if(trade.getProduct().name().equals(String.valueOf(storeProducts)))
                storage =(Storage) GameInformation.findBuilding(storeProducts.getStoreType() , trade.getSender());
            storage.addtoStorageWithAmount(trade.getProduct() , trade.getAmount());
            trade.getSender().getTradeHistory().add(trade);
            trade.getReceiver().getTradeHistory().add(trade);
            trade.getSender().getTradeList().remove(trade);
            trade.getReceiver().getTradeList().remove(trade);
            trade.getSender().getGovernment().deCoin(trade.getAmount() * trade.getPrice());

        }



    }

}
