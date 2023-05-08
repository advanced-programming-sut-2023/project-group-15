package org.example.model.gameData;

import org.example.model.User;

public class request {
    private User sender;
    private User receiver;

    public request(User sender, User receiver) {
        this.sender = sender;
        this.receiver = receiver;
    }
}
