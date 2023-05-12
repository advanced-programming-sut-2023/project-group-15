package org.example.view.enums.outputs;

public enum LoginMenuOutput {
    USER_DOES_NOT_EXIST("no user with this username exist!,\nenter valid username or signup to the game!"),
    USER_AND_PASS_MATCH_ERROR("Username and password didn’t match!,\nenter correct password"),
    INVALID_NEW_PASSWORD_FORMAT("your new password is invalid!,\ntry something else!"),
    LOGGED_IN_SUCCESSFULLY("user logged in successfully!"),
    WRONG_ANSWER_FOR_SECURITY_QUESTION("wrong answer!,\ntry again or type \"quit\" to cancel the process"),
    ENTER_YOUR_NEW_PASSWORD("enter your new password: "),
    ENTER_YOUR_PASSWORD_AGAIN("enter you new password one more time!: "),
    PASSWORD_SET_SUCCESSFULLY("your password changed successfully,\nyou can login in with your new password now!"),
    SHOW_OPTIONS("you are in login menu now!\n" +
                 "commands you can use:\n" +
                 "for changing your username use: profile change -u <username>\n" +
                 "for changing your nickname use: profile change -n <nickname>\n" +
                 "for changing your password use: profile change password -o <old-password> -n <new-password>\n" +
                 "for changing your email use: profile change -e <email>\n" +
                 "for changing your slogan use: profile change slogan -s <slogan>\n" +
                 "to removing your slogan use: Profile remove slogan\n" +
                 "for showing your score: profile display high score\n" +
                 "for showing your rank: profile display rank\n" +
                 "for showing your slogan: profile display slogan\n" +
                 "for showing your information: profile display"),
    ;
    private final String output;
    LoginMenuOutput(String output) {
        this.output = output;
    }

    public String getOutput() {
        return output;
    }

}
