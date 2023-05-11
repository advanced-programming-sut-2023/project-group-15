package org.example.model.gameData;

import org.example.model.User;
import org.example.model.enums.Products;

public class Trade {
    private User sender;
    private User receiver;
    private int amount;
    private Products product;

    public Trade(User sender, User receiver, int amount, Products product) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.product = product;
    }
}
