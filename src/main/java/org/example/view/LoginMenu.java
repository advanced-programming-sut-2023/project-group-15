package org.example.view;

import org.example.InputScanner;
import org.example.controller.LoginMenuController;
import org.example.controller.ProfileMenuController;
import org.example.view.enums.commands.LoginMenuEnum;
import org.example.view.enums.commands.ProfileMenuEnum;
import org.example.view.enums.outputs.LoginMenuOutput;
import org.example.view.enums.outputs.ProfileMenuOutput;

import java.util.regex.Matcher;

public class LoginMenu extends MainMenu {
    private final LoginMenuController loginMenuController = new ProfileMenuController();
    private Matcher loginMenuMatcher;

    public LoginMenu(Matcher loginMenuMatcher) {
        this.loginMenuMatcher = loginMenuMatcher;
    }
    LoginMenu () {

    }

    public void run(InputScanner loginMenuScanner) {
        String userInput;
        while (true) {
            userInput = loginMenuScanner.getScanner().nextLine();
            ProfileMenu profileMenu = new ProfileMenu(loginMenuController);
            if (userInput.matches(LoginMenuEnum.USER_LOGOUT.getRegex()))
                return;
            else if ((loginMenuMatcher = ProfileMenuEnum.getMatcher(userInput, ProfileMenuEnum.CHANGE_PROFILE_USERNAME)) != null) {
                profileMenu.changeUserUsername(loginMenuMatcher);
            } else if ((loginMenuMatcher = ProfileMenuEnum.getMatcher(userInput, ProfileMenuEnum.CHANGE_PASSWORD)) != null) {
                profileMenu.changeUserPassword(loginMenuMatcher);
            } else if ((loginMenuMatcher = ProfileMenuEnum.getMatcher(userInput, ProfileMenuEnum.CHANGE_PROFILE_EMAIL)) != null) {
                profileMenu.changeUserEmail(loginMenuMatcher);
            } else if ((loginMenuMatcher = ProfileMenuEnum.getMatcher(userInput, ProfileMenuEnum.CHANGE_PROFILE_NICKNAME)) != null) {
                profileMenu.changeUserNickname(loginMenuMatcher);
            } else if ((loginMenuMatcher = ProfileMenuEnum.getMatcher(userInput, ProfileMenuEnum.CHANGE_SLOGAN)) != null) {
                profileMenu.changeUserSlogan(loginMenuMatcher);
            } else if (ProfileMenuEnum.getMatcher(userInput, ProfileMenuEnum.REMOVE_SLOGAN) != null) {
                profileMenu.removeUserSlogan();
            } else if (ProfileMenuEnum.getMatcher(userInput, ProfileMenuEnum.DISPLAY_USER_PROFILE) != null) {
                profileMenu.displayUserProfile();
            } else if (ProfileMenuEnum.getMatcher(userInput, ProfileMenuEnum.DISPLAY_USER_SLOGAN) != null) {
                profileMenu.displayUserSlogan();
            } else if (ProfileMenuEnum.getMatcher(userInput, ProfileMenuEnum.DISPLAY_USER_RANK) != null) {
                profileMenu.displayUserRank();
            } else if (ProfileMenuEnum.getMatcher(userInput, ProfileMenuEnum.DISPLAY_PROFILE) != null) {
                profileMenu.displayUserInfo();
            } else {
                System.out.println(ProfileMenuOutput.INVALID_COMMAND.getOutput());
            }
        }
    }

    public void loginInCheck(Matcher matcher) {
        classify();

        //username check
        //password check
        run();
    }

    private void classify() {
        loginMenuController.setUsername(loginMenuMatcher.group("username"));
        loginMenuController.setPassword(loginMenuMatcher.group("password"));
        if (loginMenuMatcher.group("stayLogged")!=null)
            loginMenuController.setStayLoggedInFlag(true);
    }
}
