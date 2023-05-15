package org.example.model.gameData;

import org.example.model.User;

import java.util.ArrayList;

public class GameDataBase {
    private static final ArrayList<User> allUsers = new ArrayList<>();

    public static User getUserByUsername(String name) {
        for (User user : allUsers)
            if (user.getUsername().equals(name))
                return user;
        return null;
    }

    public static ArrayList<User> getAllUsers() {
        return allUsers;
    }

}



