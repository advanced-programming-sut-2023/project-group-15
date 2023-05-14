package org.example.controller;

import org.example.model.User;
import org.example.model.gameData.GameDataBase;
import org.example.view.enums.outputs.ProfileMenuOutput;
import org.example.view.enums.outputs.SignupMenuOutput;

import java.util.Objects;


public class ProfileMenuController extends LoginMenuController {

    public ProfileMenuOutput changeUsername(String username) {
        if (SignupMenuController.usernameCheckErrors(username).equals(SignupMenuOutput.CHECKED_SUCCESSFULLY)) {
            for (User user : GameDataBase.getAllUsers()) {
                if (user.getUsername().equals(this.getUsername())) {
                    user.setUsername(username);
                    this.setUsername(username);
                    moveDataToFile();
                    return ProfileMenuOutput.USERNAME_CHANGED_SUCCESSFULLY;
                }
            }
        }
        return ProfileMenuOutput.INVALID_NEW_USERNAME;
    }

    public ProfileMenuOutput changeNickname(String nickname) {
        Objects.requireNonNull(User.findUserWithPass(this.getPassword())).setNickname(nickname);
        this.setNickname(nickname);
        moveDataToFile();
        return ProfileMenuOutput.NICKNAME_CHANGED_SUCCESSFULLY;
    }

    public ProfileMenuOutput changePassword(String oldPass, String newPass) {
        if (this.getPassword().equals(oldPass)) {
            if (!oldPass.equals(newPass)) {
                if (SignupMenuController.passwordCheckErrors(newPass).equals(SignupMenuOutput.CHECKED_SUCCESSFULLY)) {
                    Objects.requireNonNull(User.findUserWithPass(oldPass)).setPassword(newPass);
                    this.setPassword(newPass);
                    moveDataToFile();
                    return ProfileMenuOutput.PASSWORD_CHANGED_SUCCESSFULLY;
                }
                return ProfileMenuOutput.INVALID_NEW_PASSWORD;
            }
            return ProfileMenuOutput.NEWPASS_AND_OLDPASS_ARE_EQUALS;
        }
        return ProfileMenuOutput.INVALID_CURRENT_PASSWORD;
    }

    public ProfileMenuOutput changeEmail(String email) {
        if (SignupMenuController.emailCheck(email).equals(SignupMenuOutput.CHECKED_SUCCESSFULLY)) {
            Objects.requireNonNull(User.findUserWithPass(this.getPassword())).setEmail(email);
            this.setEmail(email);
            moveDataToFile();
            return ProfileMenuOutput.EMAIL_CHANGED_SUCCESSFULLY;
        }
        return ProfileMenuOutput.INVALID_NEW_EMAIL;
    }

    public ProfileMenuOutput changeSlogan(String slogan) {
        Objects.requireNonNull(User.findUserWithPass(this.getPassword())).setSlogan(slogan);
        this.setSlogan(slogan);
        moveDataToFile();
        return ProfileMenuOutput.SLOGAN_CHANGED_SUCCESSFULLY;
    }

    public ProfileMenuOutput removeSlogan() {
        Objects.requireNonNull(User.findUserWithPass(this.getPassword())).setSlogan("empty");
        this.setSlogan("empty");
        moveDataToFile();
        return ProfileMenuOutput.SLOGAN_REMOVED_SUCCESSFULLY;
    }

    public void showUserHighestScore() {
        System.out.println(this.getScore());
    }

    public void showUserRank() {
        System.out.println(this.getRank());
    }

    public void showUserSlogan() {
        if (this.getSlogan() == null)
            System.out.println("slogan is empty!");
        else
            System.out.println(this.getSlogan());
    }

    public void showUserProfileDisplay() {
        User user = User.findUserWithPass(this.getPassword());
        System.out.println("username: " + Objects.requireNonNull(user).getUsername());
        this.setClipBoard(GameDataBase.getUserByUsername(user.getUsername()).getClipBoard());
        System.out.println("password: " + this.getClipBoard());
        System.out.println("email: " + user.getEmail());
        System.out.println("nickname: " + user.getNickname());
        System.out.println("slogan: " + user.getSlogan());
        System.out.println("rank: " + user.getRank());
        System.out.println("high score: "+user.getHighScore());
    }
    public static void moveDataToFile() {
        Utility.deleteFile();
        GameDataBaseController.setJasonFileForAllUsers();
    }
}
