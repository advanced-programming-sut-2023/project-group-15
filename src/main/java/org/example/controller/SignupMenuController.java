package org.example.controller;


import org.example.view.enums.outputs.SignupMenuOutput;

public class SignupMenuController extends MainMenuController{
    public SignupMenuOutput signupUser() {
        if (usernameCheck(this.getUsername())==null) {
            if (passwordCheck(this.getPassword()) == null) {
                if (emailCheck(this.getEmail())==null) {
                    //TODO: doing user signing in ...
                    return null;
                }
                return SignupMenuOutput.INVALID_EMAIL_FORMAT;
            }
            return SignupMenuOutput.INVALID_PASSWORD_FORMAT;
        }
        return SignupMenuOutput.INVALID_USERNAME_FORMAT;
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
