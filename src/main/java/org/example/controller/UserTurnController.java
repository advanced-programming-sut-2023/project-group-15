package org.example.controller;

import org.example.model.User;

public class UserTurnController {
    private User currentUser;

    public UserTurnController(User currentUser) {
        this.currentUser = currentUser;
    }

    public boolean checkUserTurn() {
        System.out.println("hanooz kamel nshode (checking user tern)!");
        return true;
    }
}
