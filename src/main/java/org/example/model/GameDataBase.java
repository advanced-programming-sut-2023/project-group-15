package org.example.model;

import java.util.ArrayList;

public class GameDataBase {
    private static ArrayList<User> allUsers = new ArrayList<>();
    User currentUser;
    public void addUser(User user)
    {
        allUsers.add(user);

    }

    public ArrayList<User> getAllUsers() {
        return allUsers;
    }
}
