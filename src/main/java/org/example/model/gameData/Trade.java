package org.example.model.gameData;

import org.example.model.User;
import org.example.model.enums.Products;

public class Trade {
    private User sender;
    private User receiver;
    private int amount;
    private Products product;
    private String message;
    private double price;


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

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
    //@Override
    /*public String toString() {
        return "sender=" + sender +
                ", receiver=" + receiver +
                ", amount=" + amount +
                ", product=" + product +
                ", message='" + message + '\'' +
                ", price=" + price +
                '}';
    }*/
}
