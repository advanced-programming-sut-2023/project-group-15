//this class is completed!
package org.example.controller;


import org.example.model.User;
import org.example.model.enums.Products;
import org.example.Server.gameData.GameDataBase;
import org.example.Server.gameData.GameInformation;
import org.example.Server.gameData.Government;
import org.example.Server.gameData.Trade;

import java.util.HashMap;


public class TradingMenuController {
    private Government government = null;

    public TradingMenuController(String playerName) {
        this.government = Government.findGovernmentWithUsername(playerName);

    }


    public void sendTradeRequest(String recourseType, int recourseAmount, String messageI, double priceI, User receiverI) {
        Products product = Products.getProductByName(recourseType);
        User receiver = receiverI;
        User sender = GameDataBase.getUserByUsername(this.government.getOwner());
        Trade newTrade = new Trade(sender, receiver, recourseAmount, product, messageI, priceI);
        sender.getGovernment().getTradeSendList().add(newTrade);
        receiver.getGovernment().getTradeUnacceptedReqList().add(newTrade);
        Government.getTradeHistoryList().add(newTrade);
        System.out.println(receiver.getUsername());
        //System.out.println(receiver.getGovernment().getTradeUnacceptedReqList());
        System.out.println(receiver.getGovernment().getTradeUnacceptedReqList().get(0).getReceiver().getUsername());
    }
    public void sendTradeDonate(String recourseType, int recourseAmount, String messageI, double priceI, User chosen) {
        Products product = Products.getProductByName(recourseType);
        User receiver =GameDataBase.getUserByUsername(this.government.getOwner());
        User sender = chosen;
        Trade newTrade = new Trade(sender, receiver, recourseAmount, product, messageI, priceI);
        sender.getGovernment().getTradeSendList().add(newTrade);
        receiver.getGovernment().getTradeUnacceptedReqList().add(newTrade);
        Government.getTradeHistoryList().add(newTrade);
    }

    public String showTradeList() {
        String output = "";
        System.out.println(GameInformation.getCurrentPlayer().getUsername());
        System.out.println(GameInformation.getCurrentPlayer().getGovernment().getTradeUnacceptedReqList().get(0).getSender().getUsername());
        System.out.println(Trade.showTrades() + "xxx");

            output += Trade.showTrades();
        return output;
    }


    public String showTradeHistory() {
        String output = "";
        if (Trade.getAllTrades().isEmpty()) {
            output = "no trade request sent!";
        } else
            output += Trade.showTradesHistory(GameDataBase.getUserByUsername(this.government.getOwner()));
        return output;
    }

    public String acceptRequest(HashMap<Products , Integer> receiverStore , Trade trade , HashMap<Products , Integer> senderStore)
    {
        String output = "";
        if(receiverStore.get(trade.getProduct()) < trade.getAmount())
            output = "resource";
        else if(trade.getSender().getGovernment().getCoins() < trade.getAmount() * trade.getPrice())
            output = "enough coin";
        else {
            trade.getSender().getGovernment().deCoin(trade.getAmount() * trade.getPrice());
            double current = trade.getReceiver().getGovernment().getCoins();
            trade.getReceiver().getGovernment().setCoins(current + trade.getPrice() * trade.getAmount());
            trade.getReceiver().getGovernment().getTradeUnacceptedReqList().remove(trade);
            trade.getReceiver().getGovernment().getTradeAcceptedReqList().add(trade);
            trade.setAccepted(true);
            output = "accepted";
        }
        return output;
    }
    public String  findStore(int index)
    {
        String output = "";
        Trade trade = GameInformation.getCurrentPlayer().getGovernment().getTradeUnacceptedReqList().get(index-1);;
        Government government = trade.getReceiver().getGovernment();
        if(government.getFOODSTORE().containsKey(trade.getProduct()))
             output = acceptRequest(government.getFOODSTORE() , trade , trade.getSender().getGovernment().getFOODSTORE());
        else if(government.getSOURCESTORE().containsKey(trade.getProduct()))
            output = acceptRequest(government.getSOURCESTORE() , trade , trade.getSender().getGovernment().getSOURCESTORE());
        else if(government.getARMOURY().containsKey(trade.getProduct()))
            output = acceptRequest(government.getARMOURY() , trade , trade.getSender().getGovernment().getARMOURY());
        return output;

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
        for (User player : GameInformation.getAllPlayers()) {
            if (player.getUsername().equals(username))
                return true;
        }
        return false;
    }

    public boolean tradeIdCheck(int id) {
        for (Trade trade : Trade.getAllTrades()) {
            if (trade.getTradeID() == id)
                return true;
        }
        return false;
    }
}
