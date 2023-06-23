//this class is completed!
package org.example.controller;

import org.example.model.User;
import org.example.model.gameData.GameDataBase;
import org.example.view.userView.ChooseAvatar;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class JsonController {

    public void setJasonFile(User user, boolean flag) {
        setUserInformationToJson(user,flag);
    }

    public static void setJasonFileForAllUsers() {
        for (User user : GameDataBase.getAllUsers()) {
            System.out.println(user.getUsername());
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
                        String.valueOf(jsonobject.get("HighScore")) , new ChooseAvatar().getImage6());
                GameDataBase.getAllUsers().add(user);
                jsonParser.next();
            }
        } catch (JSONException e) {
            System.out.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getPassHashSha256(String password, byte[] salt) {
        String passwordString = null;
        try {
            MessageDigest messagedigest = MessageDigest.getInstance("SHA-256");
            messagedigest.update(salt);
            byte[] bytes = messagedigest.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            passwordString = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return passwordString;
    }

    public static byte[] makeSalt() {
        return new byte[16];
    }

    public static void deleteFile() {
        String path = ("d:/json/dataBase.json");
        try {
            File toDelete = new File(path);
            toDelete.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
