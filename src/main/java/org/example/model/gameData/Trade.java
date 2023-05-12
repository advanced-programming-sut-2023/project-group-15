package org.example.model.gameData;

import org.example.model.User;
import org.example.model.enums.Products;

public class Trade {
    private final User sender;
    private final User receiver;
    private final int amount;
    private final Products product;
    private final String message;
    private final double price;

    public Trade(User sender, User receiver, int amount, Products product, String message, double price) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.product = product;
        this.message = message;
        this.price = price;
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

    public String getMessage() {
        return message;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "sender=" + sender +
                ", amount=" + amount +
                ", product=" + product +
                ", message='" + message + '\'' +
                ", price=" + price +
                '}';
    }
}
