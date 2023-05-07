package org.example.view;

import org.example.InputScanner;
import org.example.controller.LoginMenuController;
import org.example.controller.ProfileMenuController;
import org.example.controller.SignupMenuController;
import org.example.model.User;
import org.example.model.enums.SecurityQuestion;
import org.example.view.enums.commands.LoginMenuEnum;
import org.example.view.enums.commands.ProfileMenuEnum;
import org.example.view.enums.outputs.LoginMenuOutput;
import org.example.view.enums.outputs.ProfileMenuOutput;
import org.example.view.enums.outputs.SignupMenuOutput;

import java.util.regex.Matcher;

public class LoginMenu extends MainMenu {
    private final LoginMenuController loginMenuController = new ProfileMenuController();
    private Matcher loginMenuMatcher;
    public LoginMenu(Matcher loginMenuMatcher) {
        this.loginMenuMatcher = loginMenuMatcher;
    }
    LoginMenu() {
    }
    public void run() {
        String userInput;
        while (true) {
            userInput = InputScanner.getScanner().nextLine();
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
        classify(matcher);
        LoginMenuOutput status = loginMenuController.loginUser();
        if (status.equals(LoginMenuOutput.LOGGED_IN_SUCCESSFULLY))
            run();
        System.out.println(status.getOutput());
    }

    private void classify(Matcher matcher) {
        loginMenuController.setUsername(matcher.group("username"));
        loginMenuController.setPassword(matcher.group("password"));
        if (matcher.group("logged") != null)
            loginMenuController.setStayLoggedInFlag(true);
    }
    //TODO after user logg ins current user should be updated in gamedata base class
    // commented by Raya

    protected void forgetPassword(String username) {
        loginMenuController.setUsername(username);
        if (loginMenuController.checkMatchUsername()) {
            SecurityQuestion question = loginMenuController.findUserSecurityQuestion();
            System.out.println(question.getQuestion());
            while (true) {
                String answer = InputScanner.getScanner().nextLine();
                if (loginMenuController.checkSecurityQuestion(answer)) {
                    resettingUserPassword(username);
                } else if (LoginMenuEnum.getMatcher(answer, LoginMenuEnum.QUIT_THE_PROCESS) != null) {
                    break;
                } else
                    System.out.println(LoginMenuOutput.WRONG_ANSWER_FOR_SECURITY_QUESTION);
            }
        }
        System.out.println(LoginMenuOutput.USER_DOES_NOT_EXIST.getOutput());
    }

    private void resettingUserPassword(String username) {
        System.out.println(LoginMenuOutput.ENTER_YOUR_NEW_PASSWORD.getOutput());
        String newPassword = InputScanner.getScanner().nextLine();
        SignupMenuController signupMenuController = new SignupMenuController();
        signupMenuController.setUsername(username);
        signupMenuController.setPassword(newPassword);
        SignupMenuOutput status = SignupMenuController.passwordCheckErrors(newPassword);
        if (status.equals(SignupMenuOutput.CHECKED_SUCCESSFULLY)) {
            System.out.println(LoginMenuOutput.ENTER_YOUR_PASSWORD_AGAIN.getOutput());
            while (true) {
                newPassword = InputScanner.getScanner().nextLine();
                signupMenuController.setClipBoard(newPassword);
                if (signupMenuController.checkPasswordWithConfiguration()) {
                    System.out.println(LoginMenuOutput.PASSWORD_SET_SUCCESSFULLY.getOutput());
                    signupMenuController.setPassword(newPassword);
                    signupMenuController.changeForgetPassword();
                } else if (newPassword.matches(LoginMenuEnum.QUIT_THE_PROCESS.getRegex())) {
                    break;
                } else
                    System.out.println(SignupMenuOutput.ERROR_PASSWORD_DONOT_MATCH_WITH_CONFIGURATION.getOutput());
            }
        }
    }
}
