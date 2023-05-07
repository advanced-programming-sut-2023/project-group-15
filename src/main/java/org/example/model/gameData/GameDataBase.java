package org.example.model.gameData;

import org.example.model.User;
import org.example.model.enums.FilePaths;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class GameDataBase {
    private static ArrayList<User> allUsers = new ArrayList<>();
    private static User currentUser;
    public static void addUser(User user)
    {
        allUsers.add(user);
<<<<<<< HEAD

=======

    }

    public static User getCurrentUser() {
        return currentUser;
>>>>>>> 5b2d190069a17219a3b79b0ff745eb8211fc2fd1
    }

    public static void setAllUsers(ArrayList<User> allUsers) {
        GameDataBase.allUsers = allUsers;
    }

<<<<<<< HEAD
    public void setJasonFile() {
=======
    public static void setJasonFile(User user) {
>>>>>>> 5b2d190069a17219a3b79b0ff745eb8211fc2fd1


        JSONObject obj = new JSONObject();

<<<<<<< HEAD
        String path = "d:/json/player.json";
        File dir = new File("d:/json/");
        dir.mkdirs();

        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
            for (int i = 0; i < allUsers.size(); i++)
=======
        String path =FilePaths.DATEBASE.getFilePaths();
        File dir = new File(FilePaths.WORKING_DIR.getFilePaths());
        dir.mkdirs();

        try (PrintWriter out = new PrintWriter(new FileWriter(path,true))) {
                obj.put("Name", user.getUsername());
                obj.put("Nickname", user.getNickname());
                obj.put("Password", user.getPassword());
                obj.put("Slogan", user.getSlogan());
                obj.put("HighScore", user.getScore());
                obj.put("rank", user.getRank());
                obj.put("Email", user.getEmail());
                out.println();
>>>>>>> 5b2d190069a17219a3b79b0ff745eb8211fc2fd1
                out.write(obj.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
<<<<<<< HEAD


    public ArrayList<User> getAllUsers() {
=======
    public static void readFromFile()
    {
        String path = "d:/json/player.json"; // this is the same as:  /Users/temp/IdeaProjects/ReadFromJson/BobFile.json
        String rank ="";
        try {
            String contents = new String((Files.readAllBytes(Paths.get(path))));
            //JSONObject o = new JSONObject(contents);



            JSONTokener jsonParser = new JSONTokener(contents);
            JSONObject  jsonobject=new JSONObject(jsonParser);
            //try{
            while(!jsonParser.end()) {
                jsonobject=new JSONObject(jsonParser);
                User user = new User(String.valueOf(jsonobject.get("name")),
                        String.valueOf(jsonobject.get("Password")),
                        String.valueOf(jsonobject.get("Nickname")),
                        String.valueOf(jsonobject.get("Email")),
                        String.valueOf(jsonobject.get("slogan")));
                jsonParser.next();
            }


            // }catch(JSONException e){
            //System.out.println(e);
            //}
        }catch(IOException e){
            e.printStackTrace();
        }

    }
    public static User getUserByUsername(String name)
    {
        for(User user : getAllUsers())
            if(user.getUsername().equals(name))
                return user;
        return null;
    }
    public static ArrayList<User> getAllUsers() {
>>>>>>> 5b2d190069a17219a3b79b0ff745eb8211fc2fd1
        return allUsers;
    }
            }


