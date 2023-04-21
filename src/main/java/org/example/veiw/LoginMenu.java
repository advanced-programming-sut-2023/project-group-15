package org.example.veiw;

import org.example.InputScanner;
import org.example.veiw.commands.LoginMenuEnum;
import org.example.veiw.enums.ProfileMenuEnum;

import java.util.Scanner;
import java.util.regex.Matcher;

public class LoginMenu {
    public void run(InputScanner loginMenuScanner) {
        Matcher loginMenuMatcher;
        String userInput;
        while (true) {
            userInput = loginMenuScanner.getScanner().nextLine();
            if (userInput.matches(LoginMenuEnum.USER_LOGOUT.getRegex()))
                return;
        }
    }
}
