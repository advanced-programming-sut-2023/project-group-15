package org.example.view;

import org.example.InputScanner;
import org.example.controller.MainMenuController;
import org.example.view.enums.commands.LoginMenuEnum;
import org.example.view.enums.commands.SignupMenuEnum;

import javax.swing.*;
import java.util.regex.Matcher;

public class MainMenu {
    private MainMenuController mainMenuController = new MainMenuController();
    private static InputScanner mainMenuScanner = new InputScanner();
    public void run() {
        Matcher mainMenuMatcher;
        String userInput;
        while (true) {
            userInput = mainMenuScanner.getScanner().nextLine();
            if (userInput.matches("\\s*exit\\s*"))
                return;
            else if ((mainMenuMatcher = SignupMenuEnum.getMatcher(userInput, SignupMenuEnum.USER_CREATION))!=null) {
                new SignupMenu().checkSigningUp(mainMenuMatcher,mainMenuScanner);
            } else if ((mainMenuMatcher = LoginMenuEnum.getMatcher(userInput, LoginMenuEnum.USER_LOGIN))!=null) {
                new LoginMenu().loginInCheck(mainMenuMatcher,mainMenuScanner);
            } else if (SignupMenuEnum.getMatcher(userInput,SignupMenuEnum.CAREATE_MAP)!=null) {
                new MapMenu().enterMapEnvironmentSettings();
            }
        }
    }
}
