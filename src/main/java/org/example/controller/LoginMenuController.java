package org.example.controller;

import org.example.view.enums.outputs.LoginMenuOutput;

public class LoginMenuController extends MainMenuController{
    private boolean stayLoggedInFlag = false;

    public LoginMenuOutput loginUser() {
        if (checkMatchUsername(this.getUsername())) {
            if (checkUsernameWithPassword(this.getUsername(),this.getPassword())) {
                //TODO: later...
                return LoginMenuOutput.LOGGED_IN_SUCCESSFULY;
            }
            return LoginMenuOutput.USER_AND_PASS_MATCH_ERROR;
        }
        return LoginMenuOutput.USER_DOES_NOT_EXIST;
    }

    public boolean checkMatchUsername(String username) {
        //TODO:
        return true;
    }

    public boolean checkUsernameWithPassword(String username,String password) {
        //TODO:
        return true;
    }

    public boolean checkSecurityQuestion(String answer) {
        //TODO:
        return true;
    }

    public LoginMenuOutput forgetPassword(String username) {
        //TODO:
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
}

