package org.example.veiw;

import org.example.InputScanner;
import org.example.controller.LoginMenuController;
import org.example.controller.ProfileMenuController;
import org.example.veiw.enums.commands.LoginMenuEnum;
import org.example.veiw.enums.outputs.LoginMenuOutput;

import java.util.Scanner;
import java.util.regex.Matcher;

public class LoginMenu {
    private final LoginMenuController loginMenuController = new ProfileMenuController();

    public void run(InputScanner loginMenuScanner) {
        Matcher loginMenuMatcher;
        String userInput;
        while (true) {
            userInput = loginMenuScanner.getScanner().nextLine();
            if (userInput.matches(LoginMenuEnum.USER_LOGOUT.getRegex()))
                return;
            //TODO: completing login menu...
        }
    }

    public void loginInCheck(Matcher mainMenuMatcher) {
        loginMenuController.setUsername("username");
        loginMenuController.setPassword("password");
        loginMenuController.setStayLoggedInFlag(mainMenuMatcher.group("stayLogged") != null);
        String message = loginMenuController.loginUser().getOutput();
        if (message.equals(LoginMenuOutput.LOGGED_IN_SUCCESSFULY)) {
            //TODO: about saving user in the game...
            InputScanner loginMenuScanner = new InputScanner();
            run(loginMenuScanner);
        }
    }
}
