package org.example.view;

import org.example.controller.LoginMenuController;
import org.example.controller.ProfileMenuController;

import java.util.regex.Matcher;

public class ProfileMenu extends LoginMenu{
    private final ProfileMenuController profileMenuController;
    public ProfileMenu(LoginMenuController currentUserController) {
        this.profileMenuController = (ProfileMenuController) currentUserController;
    }
    protected void changeUserUsername(Matcher matcher) {
        String username = matcher.group("username");
        System.out.println(profileMenuController.changeUsername(username).getOutput());
    }

    protected void changeUserPassword(Matcher matcher) {
        String oldPass = matcher.group("oldPass");
        String newPass = matcher.group("newPass");
        System.out.println(profileMenuController.changePassword(oldPass,newPass));
    }
    protected void changeUserNickname(Matcher matcher) {
        String nickName = matcher.group("nickname");
        System.out.println(profileMenuController.changeNickname(nickName));
    }
    protected void changeUserEmail(Matcher matcher) {
        String email = matcher.group("email");
        System.out.println(profileMenuController.changeEmail(email));
    }
    protected void changeUserSlogan(Matcher matcher) {
        String slogan = matcher.group("slogan");
        System.out.println(profileMenuController.changeSlogan(slogan));
    }

    protected void removeUserSlogan() {
        System.out.println(profileMenuController.removeSlogan());
    }

    protected void displayUserProfile() {
        profileMenuController.showUserHighestScore();
    }

    protected void displayUserRank() {
        profileMenuController.showUserRank();
    }

    protected void displayUserSlogan() {
        profileMenuController.showUserSlogan();

    }
    protected void displayUserInfo() {
        profileMenuController.showUserProfileDisplay();
    }
}
