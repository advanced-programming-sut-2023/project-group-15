package org.example.controller;


import org.example.model.User;
import org.example.model.building.Storage;
import org.example.model.enums.Products;
import org.example.model.enums.StoreProducts;
import org.example.model.gameData.GameDataBase;
import org.example.model.gameData.GameInformation;
import org.example.model.gameData.Government;
import org.example.model.gameData.Trade;
import org.example.view.enums.outputs.GameInformationOutput;

import java.util.Map;
import java.util.regex.Matcher;

import static org.example.controller.Utility.groupFinder;

public class TradingMenuController {
    private final Government government;

    public TradingMenuController(String playerName) {
        this.government = Government.findGovernmentWithUsername(playerName);
    }

    public void showUserslist() {
        for (Map.Entry<User, Integer> entry : GameInformation.getPlayers().entrySet())
            System.out.println("User " + entry.getKey().getUsername() + ", UserNo: " + entry.getValue());
    }

    public void sendTradeRequest(String recourseType,int recourseAmount,String messageI,double priceI,String receiverI) {
        Products product = Products.getProductByName(recourseType);
        User receiver = GameDataBase.getUserByUsername(receiverI);
        User sender = GameDataBase.getUserByUsername(this.government.getOwner());
        Trade newTrade = new Trade(sender, receiver, recourseAmount, product, messageI, priceI);
        sender.getGovernment().getTradeSendList().add(newTrade);
        receiver.getGovernment().getTradeReqList().add(newTrade);
    }

    public void showTradeList() {
        Trade.showTrades();
    }

    public void showTradeHistory() {
        Trade.showTradesHistory(GameDataBase.getUserByUsername(this.government.getOwner()));
    }

    public GameInformationOutput acceptRequest(int id,String message) {
        Trade trade = Trade.findTradeWithID(id);
        Storage storage = null;
        String message1 = BuildingController.checkForSources(trade.getProduct(), trade.getAmount());
        if (message1.equals(GameInformationOutput.NOT_ENOUGH.getOutput())) {
            return GameInformationOutput.NOT_ENOUGH;
        }
        else if (trade.getSender().getGovernment().getCoins() < trade.getAmount() * trade.getPrice()) {
            return GameInformationOutput.NOT_ENOUGH_COIN;
        }
        else if (message1.equals(GameInformationOutput.SUCCESS.getOutput())) {
            //hess mikonm eshtbas
            for (StoreProducts storeProducts : StoreProducts.values())
                if (trade.getProduct().name().equals(String.valueOf(storeProducts)))
                    storage = (Storage) GameInformation.findBuilding(storeProducts.getStoreType(), trade.getSender());
            storage.addonStorageWithAmount(trade.getProduct(), trade.getAmount());
            trade.getSender().getGovernment().deCoin(trade.getAmount() * trade.getPrice());
        }
        return GameInformationOutput.ACCEPTED_SUCCESSFULLY;
    }

    public static void listOfNewOrders() {
        User currentUser = GameInformation.getCurrentPlayer();
        System.out.println("\n-----------------------------------List Of Your New Request(s)----------------------------------------");
        int j = 0;
//        for (int i = currentUser.getLastOrderIndex(); i < currentUser.getTradeReqList().size(); i++) {
//            System.out.println(++j + "." + currentUser.getTradeReqList().get(i));
//        }
//        System.out.println("------------------------------------------------------------------------------------------------------");
//        currentUser.setLastOrderIndex(currentUser.getTradeReqList().size()); //set last seen order request index
        System.out.println("Current Index:" + currentUser.getLastOrderIndex());
    }

    public boolean productInputCheck(String product) {
        return Products.findProduct(product) != null;
    }

    public void showPlayers() {
        for (User player : GameInformation.getAllPlayers()) {
            System.out.println(player.getUsername());
        }
    }

    public boolean selectReceiver(String username) {
        for (User player:GameInformation.getAllPlayers()) {
            if (player.getUsername().equals(username))
                return true;
        }
        return false;
    }

    public boolean tradeIdCheck(int id) {
        for (Trade trade:Trade.getAllTrades()) {
            if (trade.getTradeID()==id)
                return true;
        }
        return false;
    }
}
