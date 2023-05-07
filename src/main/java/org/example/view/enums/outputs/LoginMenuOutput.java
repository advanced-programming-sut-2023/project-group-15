package org.example.view.enums.outputs;

public enum LoginMenuOutput {
    USER_DOES_NOT_EXIST("no user with this username exist!,\nenter valid username or signup to the game!"),
    USER_AND_PASS_MATCH_ERROR("Username and password didn’t match!,\nenter correct password"),
    INVALID_NEW_PASSWORD_FORMAT("your new password is invalid!,\ntry something else!"),
    LOGGED_IN_SUCCESSFULLY("user logged in successfully!"),
    WRONG_ANSWER_FOR_SECURITY_QUESTION("wrong answer!,\ntry again or type \"quit\" to cancel the process"),
    ENTER_YOUR_NEW_PASSWORD("enter your new password: ")


    ;
    private final String output;
    LoginMenuOutput(String output) {
        this.output = output;
    }

    public String getOutput() {
        return output;
    }

}
