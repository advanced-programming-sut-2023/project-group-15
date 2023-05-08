package org.example.controller;

import org.example.model.User;
import org.example.view.enums.outputs.ProfileMenuOutput;
import org.example.view.enums.outputs.SignupMenuOutput;


public class ProfileMenuController extends LoginMenuController{

    public ProfileMenuOutput changeUsername(String username) {
//        if (SignupMenuController.usernameCheck(username)==null) {
            for (User user:User.allUsers) {
                if (user.getUsername().equals(this.getUsername())) {
                    user.setUsername(username);
                    this.setUsername(username);
                    return ProfileMenuOutput.USERNAME_CHANGED_SUCCESSFULLY;
                }
            }
//        }
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
                if (SignupMenuController.passwordCheckErrors(newPass).equals(SignupMenuOutput.CHECKED_SUCCESSFULLY)) {
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
            return ProfileMenuOutput.EMAIL_CHANGED_SUCCESSFULLY;
        }
        return ProfileMenuOutput.INVALID_NEW_EMAIL;
    }

    public ProfileMenuOutput changeSlogan(String slogan) {
        User.findUserWithPass(this.getPassword()).setSlogan(slogan);
        this.setSlogan(slogan);
        return ProfileMenuOutput.SLOGAN_CHANGED_SUCCESSFULLY;
    }

    public ProfileMenuOutput removeSlogan() {
        User.findUserWithPass(this.getPassword()).setSlogan(null);
        this.setSlogan(null);
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
        System.out.println("username:"+this.getUsername());
        StringBuilder password = new StringBuilder("*");
        for (int i=1;i<this.getPassword().length();i++) {
            password.append("*");
        }
        System.out.println("password:"+password);
        System.out.println("email:"+this.getEmail());
        System.out.println("nickname:"+this.getNickname());
        System.out.println("slogan:"+this.getSlogan());
        //TODO:user rank and high score are left..
    }
}
