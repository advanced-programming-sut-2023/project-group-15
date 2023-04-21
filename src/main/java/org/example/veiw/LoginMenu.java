package org.example.veiw;

import org.example.InputScanner;
import org.example.controller.LoginMenuController;
import org.example.controller.ProfileMenuController;
import org.example.veiw.enums.commands.LoginMenuEnum;
import org.example.veiw.enums.commands.ProfileMenuEnum;
import org.example.veiw.enums.outputs.LoginMenuOutput;
import org.example.veiw.enums.outputs.ProfileMenuOutput;
import java.util.regex.Matcher;

public class LoginMenu extends MainMenu {
    private final LoginMenuController loginMenuController = new ProfileMenuController();

    public void run(InputScanner loginMenuScanner) {
        Matcher loginMenuMatcher;
        String userInput;
        while (true) {
            userInput = loginMenuScanner.getScanner().nextLine();
            if (userInput.matches(LoginMenuEnum.USER_LOGOUT.getRegex()))
                return;
            else if ((loginMenuMatcher = ProfileMenuEnum.getMatcher(userInput,ProfileMenuEnum.CHANGE_PROFILE_USERNAME))!=null) {
                new ProfileMenu().changeUserUsername(loginMenuMatcher);
            } else if ((loginMenuMatcher = ProfileMenuEnum.getMatcher(userInput,ProfileMenuEnum.CHANGE_PASSWORD))!=null) {
                new ProfileMenu().changeUserPassword(loginMenuMatcher);
            } else if ((loginMenuMatcher = ProfileMenuEnum.getMatcher(userInput,ProfileMenuEnum.CHANGE_PROFILE_EMAIL))!=null) {
                new ProfileMenu().changeUserEmail(loginMenuMatcher);
            } else if ((loginMenuMatcher = ProfileMenuEnum.getMatcher(userInput,ProfileMenuEnum.CHANGE_PROFILE_NICKNAME))!=null) {
                new ProfileMenu().changeUserNickname(loginMenuMatcher);
            } else if ((loginMenuMatcher = ProfileMenuEnum.getMatcher(userInput,ProfileMenuEnum.CHANGE_SLOGAN))!=null) {
                new ProfileMenu().changeUserSlogan(loginMenuMatcher);
            } else if (ProfileMenuEnum.getMatcher(userInput,ProfileMenuEnum.REMOVE_SLOGAN)!=null) {
                new ProfileMenu().removeUserSlogan();
            } else if (ProfileMenuEnum.getMatcher(userInput,ProfileMenuEnum.DISPLAY_USER_PROFILE)!=null) {
                //TODO:
            } else if (ProfileMenuEnum.getMatcher(userInput,ProfileMenuEnum.DISPLAY_USER_SLOGAN)!=null) {
                //TODO:
            } else if (ProfileMenuEnum.getMatcher(userInput,ProfileMenuEnum.DISPLAY_USER_RANK)!=null) {
                //TODO:
            } else if (ProfileMenuEnum.getMatcher(userInput,ProfileMenuEnum.DISPLAY_PROFILE)!=null) {
                //TODO:
            } else {
                System.out.println(ProfileMenuOutput.INVALID_COMMAND.getOutput());
            }
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
