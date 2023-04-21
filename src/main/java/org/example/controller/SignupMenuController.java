package org.example.controller;

import org.example.veiw.enums.outputs.SignupMenuOutput;

import javax.swing.*;

public class SignupMenuController {
    public SignupMenuOutput signupUser(String username, String password, String email, String slogan) {
        if (usernameCheck(username)==null) {
            if (passwordCheck(password) == null) {
                if (emailCheck(email)==null) {
                    //TODO: doing user signing in ...
                    return null;
                }
                return SignupMenuOutput.INVALID_EMAIL_FORMAT;
            }
            return SignupMenuOutput.INVALID_PASSWORD_FORMAT;
        }
        return SignupMenuOutput.INVALID_USERNAME_FORMAT;
    }

    public SignupMenuOutput usernameCheck(String username) {
        if (username.matches("^\\w+$")) {
            //TODO: checking other users....
            return null;
        }
        return SignupMenuOutput.INVALID_USERNAME_FORMAT;
    }


    public SignupMenuOutput passwordCheck(String password) {
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

    public SignupMenuOutput emailCheck(String email) {
        if (email.matches("[\\w.]+@[\\w.]+\\.[\\w.]+")) {
            //TODO:checking other emails...
            return null;
        }
        return SignupMenuOutput.INVALID_EMAIL_FORMAT;
    }

    public String generateRandomSlogan() {
        //TODO:
        return null;
    }

    public String generateRandomPassword() {
        //TODO:
        return null;
    }

    public void securityQuestion() {
        //TODO:
        return;
    }
}
