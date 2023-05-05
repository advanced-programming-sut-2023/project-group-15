package org.example.model.gameData;

import org.example.model.User;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GameDataBase {
    private static ArrayList<User> allUsers = new ArrayList<>();
    private static User currentUser;
    public static void addUser(User user)
    {
        allUsers.add(user);
    }
    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setAllUsers(ArrayList<User> allUsers) {
        GameDataBase.allUsers = allUsers;
    }

    public static void setJasonFile() {


        JSONObject obj = new JSONObject();

        String path = "d:/json/player.json";
        File dir = new File("d:/json/");
        dir.mkdirs();

        try (PrintWriter out = new PrintWriter(new FileWriter(path,true))) {

            for (int i = 0; i < allUsers.size(); i++) {
                obj.put("player", allUsers.get(i).toString());
                out.write(obj.toString());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<User> getAllUsers() {
        return allUsers;
    }
            }


