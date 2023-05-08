package org.example.model.gameData;

import org.example.model.User;

public class Request {
    private User sender;
    private User receiver;

    public Request(User sender, User receiver) {
        this.sender = sender;
        this.receiver = receiver;
    }
}
