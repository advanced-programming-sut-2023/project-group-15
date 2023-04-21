package org.example.view;

import org.example.InputScanner;
import org.example.controller.MainMenuController;
import org.example.view.enums.commands.LoginMenuEnum;
import org.example.view.enums.commands.SignupMenuEnum;

import java.util.regex.Matcher;

public class MainMenu {
    private MainMenuController mainMenuController = new MainMenuController();
    public void run() {
        InputScanner mainMenuScanner = new InputScanner();
        Matcher mainMenuMatcher;
        String userInput;
        while (true) {
            userInput = mainMenuScanner.getScanner().nextLine();
            if (userInput.matches("\\s*exit\\s*"))
                return;
            else if ((mainMenuMatcher = SignupMenuEnum.getMatcher(userInput, SignupMenuEnum.USER_CREATION))!=null) {
                new SignupMenu().checkSigningUp(mainMenuMatcher);
            } else if ((mainMenuMatcher = LoginMenuEnum.getMatcher(userInput, LoginMenuEnum.USER_LOGIN))!=null) {
                new LoginMenu().loginInCheck(mainMenuMatcher);
            }
        }
    }
}
