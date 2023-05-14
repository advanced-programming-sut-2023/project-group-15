package org.example.controller;

import org.example.model.User;
import org.example.model.gameData.GameDataBase;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GameDataBaseController {

    public void setJasonFile(User user, boolean flag) {
        setUserInformationToJson(user,flag);
    }

    public static void setJasonFileForAllUsers() {
        for (User user : GameDataBase.getAllUsers()) {
            setUserInformationToJson(user,user.isStayLoggedIn());
        }
    }

    private static void setUserInformationToJson(User user,boolean flag) {
        JSONObject obj = new JSONObject();
        String path = "d:/json/dataBase.json";
        try (PrintWriter out = new PrintWriter(new FileWriter(path, true))) {
            obj.put("Name", user.getUsername());
            obj.put("Nickname", user.getNickname());
            obj.put("Password", user.getPassword());
            obj.put("Slogan", user.getSlogan());
            obj.put("HighScore", user.getHighScore());
            obj.put("rank", user.getRank());
            obj.put("Email", user.getEmail());
            obj.put("Password recovery question:", user.getPassRecoveryQuestion());
            obj.put("Password recover answer:", user.getPassRecoveryAnswer());
            obj.put("flag", flag);
            out.println();
            out.write(obj.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readFromFile() {
        String path = "d:/json/database.json";
        try {
            String contents = new String((Files.readAllBytes(Paths.get(path))));
            JSONTokener jsonParser = new JSONTokener(contents);
            while (!jsonParser.end()) {
                JSONObject jsonobject = new JSONObject(jsonParser);
                User user = new User(String.valueOf(jsonobject.get("Name")),
                        String.valueOf(jsonobject.get("Password")),
                        String.valueOf(jsonobject.get("Nickname")),
                        String.valueOf(jsonobject.get("Email")),
                        String.valueOf(jsonobject.get("Slogan")),
                        String.valueOf(jsonobject.get("Password recovery question:")),
                        String.valueOf(jsonobject.get("Password recover answer:")),
                        String.valueOf(jsonobject.get("rank")),
                        String.valueOf(jsonobject.get("HighScore")));
                GameDataBase.getAllUsers().add(user);
                jsonParser.next();
            }
        } catch (JSONException e) {
            System.out.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addUser(User user) {
        GameDataBase.getAllUsers().add(user);
    }

}
