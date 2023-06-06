//this class is completed!
package org.example.controller.userControllers;

import org.example.model.User;
import org.example.model.enums.SecurityQuestion;
import org.example.model.gameData.GameDataBase;
import org.example.view.enums.outputs.LoginMenuOutput;


public class LoginMenuController extends MainMenuController {
    private boolean stayLoggedInFlag = false;

    public LoginMenuOutput loginUser() {
        if (checkMatchUsername()) {
            if (checkUsernameWithPassword()) {
                if (this.isStayLoggedInFlag()) {
                    GameDataBase.getUserByUsername(this.getUsername()).setStayLoggedIn(true);
                    ProfileMenuController.moveDataToFile();
                }
                return LoginMenuOutput.LOGGED_IN_SUCCESSFULLY;
            }
            return LoginMenuOutput.USER_AND_PASS_MATCH_ERROR;
        }
        return LoginMenuOutput.USER_DOES_NOT_EXIST;
    }

    public boolean checkMatchUsername() {
        for (User user : GameDataBase.getAllUsers()) {
            if (user.getUsername().equals(this.getUsername()))
                return true;
        }
        return false;
    }

    private boolean checkUsernameWithPassword() {
        for (User user : GameDataBase.getAllUsers()) {
            if (user.getUsername().equals(this.getUsername())) {
                if (user.getPassword().equals(this.getPassword())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkSecurityQuestion(String answer) {
        for (User user : GameDataBase.getAllUsers()) {
            if (user.getUsername().equals(this.getUsername())) {
                if (user.getPassRecoveryAnswer().matches("\\s*" + answer + "\\s*")) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isStayLoggedInFlag() {
        return stayLoggedInFlag;
    }

    public void setStayLoggedInFlag(boolean stayLoggedInFlag) {
        this.stayLoggedInFlag = stayLoggedInFlag;
    }

    public SecurityQuestion findUserSecurityQuestion() {
        for (User user : GameDataBase.getAllUsers()) {
            if (user.getUsername().equals(this.getUsername())) {
                System.out.println(user.findUserQuestionWithUsername());
                return user.findUserQuestionWithUsername();
            }
        }
        return null;
    }

    public SecurityQuestion findUserSecurityQuestion(String question) {
        for (SecurityQuestion securityQuestion : SecurityQuestion.allQuestions()) {
            if (securityQuestion.getQuestion().equals(question))
                return securityQuestion;
        }
        return null;
    }

    public void logOut() {
        GameDataBase.getUserByUsername(this.getUsername()).setStayLoggedIn(false);
        this.setStayLoggedInFlag(false);
        ProfileMenuController.moveDataToFile();
    }

}

