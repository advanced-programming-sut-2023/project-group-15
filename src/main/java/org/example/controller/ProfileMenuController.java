package org.example.controller;

import org.example.model.User;
import org.example.veiw.enums.outputs.ProfileMenuOutput;

import javax.swing.*;

public class ProfileMenuController extends LoginMenuController{
    public ProfileMenuOutput changeUsername(String username) {
        if (SignupMenuController.usernameCheck(username)==null) {
            for (User user:User.allUsers) {
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
        User.findUserWithPass(this.getPassword()).setNickname(nickname);
        this.setNickname(nickname);
        return ProfileMenuOutput.NICKNAME_CHANGED_SUCCESSFULLY;
    }

    public ProfileMenuOutput changePassword(String oldPass,String newPass) {
        if (this.getPassword().equals(oldPass)) {
            if (!oldPass.equals(newPass)) {
                if (SignupMenuController.passwordCheck(newPass)==null) {
                    User.findUserWithPass(oldPass).setPassword(newPass);
                    this.setPassword(newPass);
                    return ProfileMenuOutput.PASSWORD_CHANGED_SUCCESSFULLY;
                }
                return ProfileMenuOutput.INVALID_NEW_PASSWORD;
            }
            return ProfileMenuOutput.NEWPASS_AND_OLDPASS_ARE_EQUALS;
        }
        return ProfileMenuOutput.INVALID_CURRENT_PASSWORD;
    }

    public ProfileMenuOutput changeEmail(String email) {
        if (SignupMenuController.emailCheck(email)==null) {
            User.findUserWithPass(this.getPassword()).setEmail(email);
            this.setEmail(email);
        }
        return ProfileMenuOutput.INVALID_NEW_EMAIL;
    }

    public ProfileMenuOutput changeSlogan(String slogan) {
        //TODO:
        return null;
    }

    public ProfileMenuOutput removeSlogan() {
        //TODO:
        return null;
    }

    public void showUserHighestScore() {
        //TODO:
        return;
    }

    public void showUserRank() {
        //TODO:
        return;
    }

    public void showUserSlogan() {
        //TODO:
        return;
    }

    public void showUserProfileDisplay() {
        //TODO:
        return;
    }
}
