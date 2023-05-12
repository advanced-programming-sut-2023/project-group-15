//this is class is completed! please don't touch my class!
package org.example.view;

import org.example.InputScanner;
import org.example.model.User;
import org.example.model.gameData.GameDataBase;
import org.example.view.enums.commands.LoginMenuEnum;
import org.example.view.enums.commands.SignupMenuEnum;
import org.example.view.enums.outputs.SignupMenuOutput;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;

public class MainMenu {
    public void run() {
        JSONObject obj = new JSONObject();
        File dir = new File("d:/json/dataBase.json");
        if (dir.exists())
            GameDataBase.readFromFile();
        Matcher mainMenuMatcher;
        String userInput;
        System.out.println(SignupMenuOutput.SHOW_MAIN_MENU_OPTIONS.getOutput());
        while (true) {
            userInput = InputScanner.getScanner().nextLine();
            if (userInput.matches("\\s*exit\\s*"))
                return;
            else if ((mainMenuMatcher = SignupMenuEnum.getMatcher(userInput, SignupMenuEnum.USER_CREATION)) != null) {
                System.out.println(SignupMenuOutput.SHOW_OPTIONS.getOutput());
                new SignupMenu().run(mainMenuMatcher);
            } else if ((mainMenuMatcher = LoginMenuEnum.getMatcher(userInput, LoginMenuEnum.USER_LOGIN)) != null) {
                new LoginMenu().loginInCheck(mainMenuMatcher);
            } else if (LoginMenuEnum.getMatcher(userInput, LoginMenuEnum.FORGET_PASSWORD) != null) {
                forgetPassword();
            } else if ((mainMenuMatcher = SignupMenuEnum.getMatcher(userInput, SignupMenuEnum.CREATE_MAP)) != null) {
                new MapMenu().run(mainMenuMatcher);
            } else {
                System.out.println("Invalid command!");
            }
        }
    }

    private void forgetPassword() {
        System.out.println("enter your username:");
        String input = InputScanner.getScanner().nextLine();
        new LoginMenu().forgetPassword(input);
    }

    public void checkUsersFlag() {
        String path = "d:/json/database.json";
        try {
            String contents = new String((Files.readAllBytes(Paths.get(path))));
            JSONTokener jsonParser = new JSONTokener(contents);
            while (!jsonParser.end()) {
                JSONObject jsonobject = new JSONObject(jsonParser);
                if (jsonobject.get("flag").equals(true)) {
                    String name = (String) jsonobject.get("name");
                    String password = (String) jsonobject.get("Password");
                    String nickname = (String) jsonobject.get("Nickname");
                    String email = (String) jsonobject.get("Email");
                    String slogan = (String) jsonobject.get("Slogan");
                    String passwordRecoveryQuestion = (String) jsonobject.get("Password recovery question:");
                    String passwordRecoveryAnswer = (String) jsonobject.get("Password recover answer:");
                    String rank = (String) jsonobject.get("rank");
                    String highScore = (String) jsonobject.get("HighScore");
                    new LoginMenu().loggedInUserInformation(name,password,nickname,email,slogan,passwordRecoveryQuestion,passwordRecoveryAnswer,rank,highScore);
                }
                jsonParser.next();
            }
        } catch (JSONException e) {
            System.out.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
