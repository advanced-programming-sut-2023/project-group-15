//this class is completed!
package org.example.controller.userControllers;

import org.example.controller.JsonController;
import org.example.model.enums.SecurityQuestion;
import org.example.view.userView.LoginMenu;
import org.example.view.userView.MainMenu;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MainMenuController {
    private final JsonController gameDataBaseController ;
    private String username;
    private String password;
    private String nickname;
    private String slogan;
    private String email;
    private String clipBoard;
    private SecurityQuestion passRecoveryQuestion;
    private String passRecoveryAnswer;
    private int score;
    private int rank;


    public MainMenuController() {
        this.username = null;
        this.password = null;
        this.nickname = null;
        this.slogan = null;
        this.email = null;
        this.clipBoard = null;
        this.passRecoveryAnswer = null;
        this.passRecoveryQuestion = null;
        this.score = 0;
        this.gameDataBaseController = new JsonController();
    }

    public void setPassRecoveryQuestion(SecurityQuestion passRecoveryQuestion) {
        this.passRecoveryQuestion = passRecoveryQuestion;
    }

    public void setPassRecoveryAnswer(String passRecoveryAnswer) {
        this.passRecoveryAnswer = passRecoveryAnswer;
    }

    public void setHighScore(int score) {
        this.score = score;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public SecurityQuestion getPassRecoveryQuestion() {
        return passRecoveryQuestion;
    }

    public String getPassRecoveryAnswer() {
        return passRecoveryAnswer;
    }

    public int getScore() {
        return score;
    }

    public int getRank() {
        return rank;
    }

    public String getClipBoard() {
        return clipBoard;
    }

    public void setClipBoard(String clipBoard) {
        this.clipBoard = clipBoard;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNickname() {
        return nickname;
    }

    public String getSlogan() {
        return slogan;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void checkJsonDirectory()  {
        File dir = new File("d:/json/dataBase.json");
        if (dir.exists()) {
            JsonController.readFromFile();
            checkUsersFlag();
        } else {
            new File("d:/json").mkdirs();
          //  new MainMenu().run();
        }
    }

    public void checkUsersFlag() {
        String path = "d:/json/database.json";
        try {
            String contents = new String((Files.readAllBytes(Paths.get(path))));
            JSONTokener jsonParser = new JSONTokener(contents);
            while (!jsonParser.end()) {
                JSONObject jsonobject = new JSONObject(jsonParser);
                if (jsonobject.get("flag").equals(true)) {
                    String name = String.valueOf(jsonobject.get("Name"));
                    String password = String.valueOf(jsonobject.get("Password"));
                    String nickname = String.valueOf(jsonobject.get("Nickname"));
                    String email = String.valueOf(jsonobject.get("Email"));
                    String slogan = String.valueOf(jsonobject.get("Slogan"));
                    String passwordRecoveryQuestion = String.valueOf(jsonobject.get("Password recovery question:"));
                    String passwordRecoveryAnswer = String.valueOf(jsonobject.get("Password recover answer:"));
                    String rank = String.valueOf(jsonobject.get("rank"));
                    String highScore = String.valueOf(jsonobject.get("HighScore"));
                    new LoginMenu().loggedInUserInformation(name,password,nickname,email,slogan,passwordRecoveryQuestion,passwordRecoveryAnswer,rank,highScore);
                    //new MainMenu().run();
                    return;
                }
                jsonParser.next();
            }
           // new MainMenu().run();
        } catch (JSONException e) {
            System.out.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}