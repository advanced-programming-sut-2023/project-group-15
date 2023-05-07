package org.example.controller;

import org.example.model.User;
import org.example.model.enums.SecurityQuestion;
import org.example.view.enums.outputs.LoginMenuOutput;

public class LoginMenuController extends MainMenuController{
    private boolean stayLoggedInFlag = false;

    public LoginMenuOutput loginUser() {
        if (checkMatchUsername()) {
            if (checkUsernameWithPassword()) {
                return LoginMenuOutput.LOGGED_IN_SUCCESSFULLY;
            }
            return LoginMenuOutput.USER_AND_PASS_MATCH_ERROR;
        }
        return LoginMenuOutput.USER_DOES_NOT_EXIST;
    }

    public boolean checkMatchUsername() {
        for (User user:User.allUsers) {
            if (user.getUsername().equals(this.getUsername()))
                return true;
        }
        return false;
    }

    private boolean checkUsernameWithPassword() {
        for (User user:User.allUsers) {
            if (user.getUsername().equals(this.getUsername())) {
                if (user.getPassword().equals(this.getPassword())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkSecurityQuestion(String answer) {
        if (this.getPassRecoveryAnswer().equals(answer))
            return true;
        return false;
    }

    public LoginMenuOutput forgetPassword(String username) {

        return null;
    }

    public void logoutUser() {
        //TODO:
        return;
    }

    public void captcha() {
        //TODO:
        return;
    }

    public boolean isStayLoggedInFlag() {
        return stayLoggedInFlag;
    }

    public void setStayLoggedInFlag(boolean stayLoggedInFlag) {
        this.stayLoggedInFlag = stayLoggedInFlag;
    }

    public SecurityQuestion findUserSecurityQuestion() {
        for (User user:User.allUsers) {
            if (user.getUsername().equals(this.getUsername()))
                for (SecurityQuestion question : SecurityQuestion.allQuestions()) {
                    if (question.getQuestion().equals(user.getPassRecoveryQuestion())) {
                        this.setPassRecoveryQuestion(question);
                        return question;
                    }
                }
        }
        return null;
    }
}

