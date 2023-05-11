package org.example.model.gameData;

import org.example.InputScanner;
import org.example.model.User;
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

    public static User getUserByUsername(String name) {
        for(User user :allUsers)
            if(user.getUsername().equals(name))
                return user;
        return null;
    }

    public static void addUser(User user)
    {
        allUsers.add(user);

    }

    public static User getCurrentUser() {
        return currentUser;
    }


    public static void setAllUsers(ArrayList<User> allUsers) {
        GameDataBase.allUsers = allUsers;
    }

    public static void setJasonFile(User user) {


        JSONObject obj = new JSONObject();
        String path ="d:/json/dataBase.json";
        //File dir = new File("d:/json/");
        //dir.mkdirs();
       /* String path =FilePaths.DATEBASE.getFilePaths();
        File dir = new File(FilePaths.WORKING_DIR.getFilePaths());
        dir.mkdirs();*/

        try (PrintWriter out = new PrintWriter(new FileWriter(path,true))) {
                obj.put("Name", user.getUsername());
                obj.put("Nickname", user.getNickname());
                obj.put("Password", user.getPassword());
                obj.put("Slogan", user.getSlogan());
                obj.put("HighScore", user.getHighscore());
                obj.put("rank", user.getRank());
                obj.put("Email", user.getEmail());
                obj.put("Password recovery question:",user.getPassRecoveryQuestion());
                obj.put("Password recover answer:" , user.getPassRecoveryAnswer());
                out.println();
                out.write(obj.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void readFromFile()
    {
        String path = "d:/json/database.json";
        try {
            String contents = new String((Files.readAllBytes(Paths.get(path))));
            //JSONObject o = new JSONObject(contents);
            JSONTokener jsonParser = new JSONTokener(contents);
            JSONObject  jsonobject=new JSONObject(jsonParser);
            //try{
            while(!jsonParser.end()) {
                jsonobject=new JSONObject(jsonParser);
                User user = new User(String.valueOf(jsonobject.get("Name")),
                        String.valueOf(jsonobject.get("Password")),
                        String.valueOf(jsonobject.get("Nickname")),
                        String.valueOf(jsonobject.get("Email")),
                        String.valueOf(jsonobject.get("Slogan")),
                String.valueOf(jsonobject.get("Password recovery question:")),
                        String.valueOf(jsonobject.get("Password recover answer:")),
                        String.valueOf(jsonobject.get("rank")),
                        String.valueOf(jsonobject.get("HighScore")));

                allUsers.add(user);
                jsonParser.next();
            }


            // }catch(JSONException e){
            //System.out.println(e);
            //}
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    public static ArrayList<User> getAllUsers() {
        return allUsers;
    }
            }



