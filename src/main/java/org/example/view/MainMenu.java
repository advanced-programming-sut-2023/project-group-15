package org.example.view;

import org.example.InputScanner;
import org.example.controller.MainMenuController;
import org.example.view.enums.commands.LoginMenuEnum;
import org.example.view.enums.commands.SignupMenuEnum;

import javax.swing.*;
import java.util.regex.Matcher;

public class MainMenu {
    public void run() {
        Matcher mainMenuMatcher;
        String userInput;
        while (true) {
            userInput = InputScanner.getScanner().nextLine();
            if (userInput.matches("\\s*exit\\s*"))
                return;
            else if ((mainMenuMatcher = SignupMenuEnum.getMatcher(userInput,SignupMenuEnum.USER_CREATION))!=null) {
                System.out.println("to signup menu..");
                new SignupMenu().run(mainMenuMatcher);
            } else if ((mainMenuMatcher = LoginMenuEnum.getMatcher(userInput, LoginMenuEnum.USER_LOGIN))!=null) {
                new LoginMenu().loginInCheck(mainMenuMatcher);
            } else if (LoginMenuEnum.getMatcher(userInput,LoginMenuEnum.FORGET_PASSWORD)!=null) {
                forgetPassword();
            } else if (SignupMenuEnum.getMatcher(userInput,SignupMenuEnum.CREATE_MAP)!=null) {
               // new MapMenu().enterMapEnvironmentSettings();
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
}
