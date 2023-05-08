//this is class is completed! please don't touch my class!
package org.example.view;

import org.example.InputScanner;
import org.example.view.enums.commands.LoginMenuEnum;
import org.example.view.enums.commands.SignupMenuEnum;
import org.example.view.enums.outputs.SignupMenuOutput;

import java.util.regex.Matcher;

public class MainMenu {
    public void run() {
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
}
