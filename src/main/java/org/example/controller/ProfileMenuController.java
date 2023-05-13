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
        Objects.requireNonNull(User.findUserWithPass(this.getPassword())).setSlogan(null);
        this.setSlogan(null);
        moveDataToFile();
        return ProfileMenuOutput.SLOGAN_REMOVED_SUCCESSFULLY;
    }

    public void showUserHighestScore() {
        //TODO: after completing other parts!
    }

    public void showUserRank() {
        //TODO: after completing other parts!
    }

    public void showUserSlogan() {
        System.out.println(this.getSlogan());
    }

    public void showUserProfileDisplay() {
        User user = User.findUserWithPass(this.getPassword());
        System.out.println("username:" + Objects.requireNonNull(user).getUsername());
        StringBuilder password = new StringBuilder("*");
        for (int i = 1; i < this.getPassword().length(); i++) {
            password.append("*");
        }
        System.out.println("password:" + password);
        System.out.println("email:" + user.getEmail());
        System.out.println("nickname:" + user.getNickname());
        System.out.println("slogan:" + user.getSlogan());
        //TODO:user rank and high score are left..
    }
    public void moveDataToFile()
    {
        Utility.deleteFile();
        GameDataBase.setJasonFile();
    }
}
