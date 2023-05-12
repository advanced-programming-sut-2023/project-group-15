//this class is completed!
package org.example.view.enums.outputs;

public enum SignupMenuOutput {
    EMPTY_FIELD("you just missed some fields,\ntry again!"),
    INVALID_USERNAME_FORMAT("username format is invalid!,\ntry again!"),
    CHECKED_SUCCESSFULLY("ok"),
    ERROR_PASSWORD_IS_TOO_SHORT("your password is too short!: your password must contain at least 6 characters!,\ntry again!"),
    ERROR_PASSWORD_NO_CAPITAL_CHARACTER("invalid password format!: your password must contain at least 1 capital alphabet!,\ntry again!"),
    ERROR_PASSWORD_NO_SMALL_CHARACTER("invalid password format!: your password must contain at least 1 small alphabet!,\ntry again!"),
    ERROR_PASSWORD_NO_DIGITS("invalid password format!: your password must contain at least 1 digits!,\ntry again!"),
    ERROR_PASSWORD_NO_SPECIAL_CHARACTER("invalid password format!: your password must contain at least 1 special character!,\ntry again!"),
    ERROR_PASSWORD_DONOT_MATCH_WITH_CONFIGURATION("you password is not equal to your configuration,\ntry again!"),
    SECURITY_QUESTION("security question"),
    USERNAME_EXISTS("you can't user this username because it already exists!,\n try something else..."),
    DUPLICATE_EMAIL_ERROR("a user with this email already exists,\n enter unique email please!"),
    INVALID_EMAIL_FORMAT("email format is invalid!,\ntry again!"),
    QUIT_FROM_PROCESS("canceling the process"),
    INVALID_COMMAND("Invalid command!,\ntry again!"),
    ANSWERS_ARE_NOT_EQUAL("your answers doesn't match!,\ntry again!,\ntype \"quit\" to cancel the process"),
    USER_CREATED_SUCCESSFULLY("user has been created successfully!"),
    SHOW_MAIN_MENU_OPTIONS("you are in main menu now!\n" +
            "commands you can use here:\n" +
            "for creating new account: user create -u <username> -p <password> <password confirmation> –email <email> -s <slogan> -n <nickname>" +
            "for logging in to your account: user login -u <username> -p <password>\n" +
            "if you forgot your password use: forgot my password\n" +
            "if you want to create a map user: create map"),

    SHOW_OPTIONS("you are in signup menu now!\n" +
            "commands you can use:\n" +
            "for creating account: user create -u <username> -p <password> <password confirmation> –email <email> -s <slogan> -n <nickname>\n" +
            "for picking up security question: question pick -q <question-number> -a <answer> -c <answer confirm>\n" +
            "for creating map: create map"),

    ;
    private final String output;

    public String getOutput() {
        return output;
    }

    SignupMenuOutput(String output) {
        this.output = output;
    }
}