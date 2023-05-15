//this class is completed!
package org.example.model.gameData;

import org.example.model.User;
import org.example.model.enums.Products;

import java.util.ArrayList;

public class Trade {
    private int id = 1;
    private final int tradeID;
    private final User sender;
    private final User receiver;
    private final int amount;
    private final Products product;
    private final String senderMessage;
    private String receiverMessage;
    private final double price;
    private boolean accepted;
    private final static ArrayList<Trade> allTrades = new ArrayList<>();

    public Trade(User sender, User receiver, int amount, Products product, String message, double price) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.product = product;
        this.senderMessage = message;
        this.receiverMessage = null;
        this.price = price;
        this.accepted = false;
        this.tradeID = id;
        id++;
        allTrades.add(this);
    }

    public static ArrayList<Trade> getAllTrades() {
        return allTrades;
    }

    public void acceptReq() {
        this.accepted = true;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public int getTradeID() {
        return tradeID;
    }

    public static void showTrades() {
        int index = 1;
        for (Trade trade : Trade.getAllTrades()) {
            if (!trade.isAccepted()) {
                System.out.println(index + ". sender: " + trade.getSender().getUsername() + " receiver: " + trade.getReceiver().getUsername() + " product(amount): "
                        + trade.getProduct() + "(" + trade.getAmount() + ") trade message: " + trade.getSenderMessage() + " trade ID: " + trade.getTradeID());
                index++;
            }
        }
    }

    public static void showTradesHistory(User user) {
        int index = 1;
        for (Trade trade : Trade.getAllTrades()) {
            if (trade.getSender().getUsername().equals(user.getUsername()) || trade.getReceiver().getUsername().equals(user.getUsername())) {
                System.out.println(index + ". sender: " + trade.getSender().getUsername() + " receiver: " + trade.getReceiver().getUsername() + " product(amount): "
                        + trade.getProduct() + "(" + trade.getAmount() + ") trade message: " + trade.getSenderMessage() + " trade ID: " + trade.getTradeID());
                index++;
                System.out.print("status: ");
                if (trade.isAccepted())
                    System.out.println("accepted!");
                else
                    System.out.println("not accepted yet!");
            }
        }
    }

    public static Trade findTradeWithID(int id) {
        for (Trade trade : Trade.getAllTrades()) {
            if (trade.getTradeID() == id)
                return trade;
        }
        return null;
    }

    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public int getAmount() {
        return amount;
    }

    public Products getProduct() {
        return product;
    }

    public String getSenderMessage() {
        return senderMessage;
    }

    public String getReceiverMessage() {
        return receiverMessage;
    }

    public double getPrice() {
        return price;
    }

    public void setReceiverMessage(String receiverMessage) {
        this.receiverMessage = receiverMessage;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "sender=" + sender +
                ", amount=" + amount +
                ", product=" + product +
                ", message='" + senderMessage + '\'' +
                ", price=" + price +
                '}';
    }
}
