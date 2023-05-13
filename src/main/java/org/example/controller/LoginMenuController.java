package org.example.controller;

import org.example.model.User;
import org.example.model.enums.SecurityQuestion;
import org.example.model.gameData.GameDataBase;
import org.example.view.enums.outputs.LoginMenuOutput;

public class LoginMenuController extends MainMenuController{
    private boolean stayLoggedInFlag = false;
    private GameDataBaseController gameDataBaseController = new GameDataBaseController();

    public LoginMenuOutput loginUser() {
        if (checkMatchUsername()) {
            if (checkUsernameWithPassword()) {
                if (this.isStayLoggedInFlag()) {
                    new GameDataBaseController().changeUserFlag(this.getUsername(),this.isStayLoggedInFlag());
                }
                return LoginMenuOutput.LOGGED_IN_SUCCESSFULLY;
            }
            return LoginMenuOutput.USER_AND_PASS_MATCH_ERROR;
        }
        return LoginMenuOutput.USER_DOES_NOT_EXIST;
    }

    public boolean checkMatchUsername() {
        for (User user: GameDataBase.getAllUsers()) {
            if (user.getUsername().equals(this.getUsername()))
                return true;
        }
        return false;
    }

    private boolean checkUsernameWithPassword() {
        for (User user:GameDataBase.getAllUsers()) {
            if (user.getUsername().equals(this.getUsername())) {
                if (user.getPassword().equals(this.getPassword())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkSecurityQuestion(String answer) {
        for (User user:GameDataBase.getAllUsers()) {
            if (user.getUsername().equals(this.getUsername())) {
                if (user.getPassRecoveryAnswer().matches("\\s*"+answer+"\\s*")) {
                    return true;
                }
            }
        }
        return false;
    }
    public void captcha() {
        //TODO: later...
    }
    public boolean isStayLoggedInFlag() {
        return stayLoggedInFlag;
    }

    public void setStayLoggedInFlag(boolean stayLoggedInFlag) {
        this.stayLoggedInFlag = stayLoggedInFlag;
    }

    public SecurityQuestion findUserSecurityQuestion() {
        for (User user:GameDataBase.getAllUsers()) {
            if (user.getUsername().equals(this.getUsername())) {
                return user.findUserQuestionWithUsername();
            }
        }
        return null;
    }
    public SecurityQuestion findUserSecurityQuestion(String question) {
        for (SecurityQuestion securityQuestion:SecurityQuestion.allQuestions()) {
            if (securityQuestion.getQuestion().equals(question))
                return securityQuestion;
        }
        return null;
    }
}

