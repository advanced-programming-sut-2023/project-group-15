package org.example.controller;


import org.example.model.User;
import org.example.view.enums.outputs.SignupMenuOutput;

public class SignupMenuController extends MainMenuController{
    public SignupMenuOutput signupUser() {
        if (usernameCheck(this.getUsername())!=null)
            return SignupMenuOutput.INVALID_USERNAME_FORMAT;
        if (emailCheck(this.getEmail())!=null)
            return SignupMenuOutput.INVALID_EMAIL_FORMAT;
        if (passwordCheck(this.getPassword())!=null)
            return SignupMenuOutput.INVALID_PASSWORD_FORMAT;
        if (this.getPassword().matches("\\s*random\\s*")) {
            this.setClipBoard(generateRandomPassword());
            return SignupMenuOutput.STAND_BY;
        }
        //TODO: completing later
        return null;
    }

    public static SignupMenuOutput usernameCheck(String username) {
        if (username.matches("^\\w+$")) {
            //TODO: checking other users....
            return null;
        }
        return SignupMenuOutput.INVALID_USERNAME_FORMAT;
    }


    public static SignupMenuOutput passwordCheck(String password) {
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

    public void securityQuestion() {
        //TODO: uncompleted method!
        return;
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
