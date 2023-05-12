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

public class TradingMenuController {
    public void showUserslist() {
        for (Map.Entry<User, Integer> entry : GameInformation.getPlayers().entrySet())
            System.out.println("User " + entry.getKey().getUsername() + ", UserNo: " + entry.getValue());
    }

    public void sendTradeRequest(Matcher matcher, String name) {
        if (Utility.groupFinder(matcher, "-t") == null || Utility.groupFinder(matcher, "-p") == null
                || Utility.groupFinder(matcher, "-m") == null || Utility.groupFinder(matcher, "-a") == null) {
            System.out.println("invalid command");
            return;
        }
        String productName = Utility.groupFinder(matcher, "-t");
        Products product = Products.getProductByName(productName);
        double price = Double.parseDouble(Utility.groupFinder(matcher, "-p"));
        int amount = Integer.parseInt(Utility.groupFinder(matcher, "-a"));
        String message = Utility.groupFinder(matcher, "-m");
        User receiver = GameDataBase.getUserByUsername(name);
        User sender = GameDataBase.getCurrentUser();
        Trade newTrade = new Trade(sender, receiver, amount, product, message, price);
        sender.getTradeSendList().add(newTrade);
        receiver.getTradeReqList().add(newTrade);
    }

    public void showTradeList() {
        User user = GameInformation.getCurrentPlayer();
        for (int i = 0; i < GameInformation.getCurrentPlayer().getTradeSendList().size(); i++) {
            if (i == 0)
                System.out.println("--------------------------------------------------------------------------");
            System.out.println("No." + (i + 1) + ":" + user.getTradeSendList().get(i));
        }
    }

    public void showTradeHistory() {
        User user = GameInformation.getCurrentPlayer();
        if (user.getTradeHistoryList().size() == 0)
            System.out.println("\nTrade History List Is Empty!!!");
        for (int i = 0; i < user.getTradeHistoryList().size(); i++) {
            if (i == 0)
                System.out.println("----------------------------------History of accepted trade:------------------------------------------");
            System.out.println("No." + (i + 1) + ":" + user.getTradeHistoryList().get(i));
        }
    }

    public void acceptRequest(Trade trade) {
        Storage storage = null;
        String message1 = GameInformation.checkForSources(trade.getProduct(), trade.getAmount());
        if (message1.equals(GameInformationOutput.NOT_ENOUGH.getOutput())) {
            System.out.println(message1);
            return;
        }
        if (trade.getSender().getGovernment().getCoins() < trade.getAmount() * trade.getPrice()) {
            System.out.println("not enough coins for the trade sender");
            return;
        }
        if (message1.equals(GameInformationOutput.SUCCESS.getOutput())) {
            for (StoreProducts storeProducts : StoreProducts.values()) {
                if (trade.getProduct().name().equals(String.valueOf(storeProducts)))
                    storage = (Storage) GameInformation.findBuilding(storeProducts.getStoreType(), trade.getSender());
            }
            storage.addonStorageWithAmount(trade.getProduct(), trade.getAmount());
            trade.getSender().getTradeHistoryList().add(trade);
            trade.getReceiver().getTradeHistoryList().add(trade);
            trade.getSender().getTradeSendList().remove(trade);
            trade.getReceiver().getTradeReqList().remove(trade);
            trade.getSender().getGovernment().deCoin(trade.getAmount() * trade.getPrice());
        }

    }

    public static void listOfNewOrders() {
        User currentUser = GameInformation.getCurrentPlayer();
        System.out.println("\n-----------------------------------List Of Your New Request(s)----------------------------------------");
        int j = 0;
        for (int i = currentUser.getLastOrderIndex(); i < currentUser.getTradeReqList().size(); i++) {
            System.out.println(++j + "." + currentUser.getTradeReqList().get(i));
        }
        System.out.println("------------------------------------------------------------------------------------------------------");
        currentUser.setLastOrderIndex(currentUser.getTradeReqList().size()); //set last seen order request index
        System.out.println("Current Index:" + currentUser.getLastOrderIndex());
    }

}
