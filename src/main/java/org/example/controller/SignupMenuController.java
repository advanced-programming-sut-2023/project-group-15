package org.example.controller;


import org.example.InputScanner;
import org.example.model.User;
import org.example.view.enums.outputs.SignupMenuOutput;

import java.util.Random;

public class SignupMenuController extends MainMenuController{
    public SignupMenuOutput signupUserCheck() {
        SignupMenuOutput status;
//        if ((status = usernameCheck())!=SignupMenuOutput.CHECKED_SUCCESSFULLY)
//            return status;
        if ((status = emailCheck(this.getEmail()))!=SignupMenuOutput.CHECKED_SUCCESSFULLY)
            return status;
        if ((status = passwordCheck(this.getPassword()))!=SignupMenuOutput.CHECKED_SUCCESSFULLY)
            return status;
        if ((status = nicknameCheck(this.getNickname()))!=SignupMenuOutput.CHECKED_SUCCESSFULLY)
            return status;
        return SignupMenuOutput.SECURITY_QUESTION;
    }

    private SignupMenuOutput nicknameCheck(String nickname) {
        return nickname==null ? SignupMenuOutput.EMPTY_FIELD : SignupMenuOutput.CHECKED_SUCCESSFULLY;
    }

    public SignupMenuOutput usernameCheckErrors() {
        if (this.getUsername() == null) {
            return SignupMenuOutput.EMPTY_FIELD;
        }
        if (this.getUsername().matches("^\\w+$")) {
            for (User user:User.allUsers) {
                if (user.getUsername().equals(this.getUsername())) {
                    return SignupMenuOutput.USERNAME_EXISTS;
                }
            }
            return SignupMenuOutput.CHECKED_SUCCESSFULLY;
        }
        return SignupMenuOutput.INVALID_USERNAME_FORMAT;
    }


    public static SignupMenuOutput passwordCheck(String password) {
        if (password==null) {
            return SignupMenuOutput.EMPTY_FIELD;
        }
        if (password.length()>=6) {
            if (password.matches("[a-z]+")) {
                if (password.matches("[A-Z]+")) {
                    if (password.matches("\\d+")) {
                        if (password.matches("[',!;?$^:\\\\/`|~&\" @#%*{}()\\[\\]<>_+.\\s=-]")) {
                            return null;
                        }
                        return SignupMenuOutput.ERROR_PASSWORD_NO_SPECIAL_CHARACTER;
                    }
                    return SignupMenuOutput.ERROR_PASSWORD_NO_DIGITS;
                }
                return SignupMenuOutput.ERROR_PASSWORD_NO_CAPITAL_CHARACTER;
            }
            return SignupMenuOutput.ERROR_PASSWORD_NO_SMALL_CHARACTER;
        }
        return SignupMenuOutput.ERROR_PASSWORD_IS_TOO_SHORT;
    }

    public static SignupMenuOutput emailCheck(String email) {
        if (email==null) {
            return SignupMenuOutput.EMPTY_FIELD;
        }
        if (email.matches("[\\w.]+@[\\w.]+\\.[\\w.]+")) {
            //TODO:checking other emails...
            return null;
        }
        return SignupMenuOutput.INVALID_EMAIL_FORMAT;
    }

    public String generateRandomSlogan() {
        //TODO: uncompleted method!
        return null;
    }

    public String generateRandomPassword() {
        String password = null;
        //TODO: generating strong password
        return password;
    }

    public boolean pickSecurityQuestion(String numOfQuestion) {
        //for on all questions!
        //TODO: uncompleted method!
        return false;
    }
    public void usernameSuggestionGenerator() {
        while (true) {
            boolean flag = true;
            Random random = new Random();
            char randomChar = (char) (random.nextInt(26)+'a');
            this.setUsername(this.getUsername()+randomChar);
            for (User user : User.allUsers){
                if (user.getUsername().equals(this.getUsername())) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                return;
        }
    }
    public SignupMenuOutput suggestingUsername() {

        return null;
    }
    public boolean randomPasswordVerification(String verification) {
        return verification.equals(this.getClipBoard());
    }

    public void signingsComplete() {
        User newUser = new User(this.getUsername(), this.getPassword(), this.getNickname(), this.getEmail());
        if (this.getSlogan()!=null) {
            newUser.setSlogan(this.getSlogan());
        }
        newUser.addUser();
    }

}
