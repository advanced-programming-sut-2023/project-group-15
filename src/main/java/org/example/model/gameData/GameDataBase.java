package org.example.model.gameData;

import org.example.model.User;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class GameDataBase {
    private static final ArrayList<User> allUsers = new ArrayList<>();
    private static User currentUser;
    public static User getUserByUsername(String name) {
        for (User user : allUsers)
            if (user.getUsername().equals(name))
                return user;
        return null;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static ArrayList<User> getAllUsers() {
        return allUsers;
    }

}



