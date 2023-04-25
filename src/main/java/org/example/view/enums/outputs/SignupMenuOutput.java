package org.example.view.enums.outputs;

public enum SignupMenuOutput {
    EMPTY_FIELD("you just missed some fields,\ntry again!"),
    INVALID_USERNAME_FORMAT("username format is invalid!,\ntry again!"),
    CHECKED_SUCCESSFULLY("ok"),
    INVALID_PASSWORD_FORMAT("password format is invalid!,\ntry something else..."),
    ERROR_PASSWORD_IS_TOO_SHORT("your password is too short!: your password must contain at least 6 characters!,\ntry again!"),
    ERROR_PASSWORD_NO_CAPITAL_CHARACTER("invalid password format!: your password must contain at least 1 capital alphabet!,\ntry again!"),
    ERROR_PASSWORD_NO_SMALL_CHARACTER("invalid password format!: your password must contain at least 1 small alphabet!,\ntry again!"),
    ERROR_PASSWORD_NO_DIGITS("invalid password format!: your password must contain at least 1 digits!,\ntry again!"),
    ERROR_PASSWORD_NO_SPECIAL_CHARACTER("invalid password format!: your password must contain at least 1 special character!,\ntry again!"),
    STAND_BY("standing by"),
    SECURITY_QUESTION("security question"),
    USERNAME_EXISTS("you can't user this username because it already exists!,\n try something else..."),
    WEAK_PASSWORD("your password is weak!,\ntry something harder or user \"random password\""),
    USER_AND_PASS_MATCH_ERROR("your password is incorrect,\nenter the correct password or try \"forget password\""),
    DUPLICATE_EMAIL_ERROR("a user with this email already exists,\n enter unique email please!"),
    INVALID_EMAIL_FORMAT("email format is invalid!,\ntry again!"),
    QUIT_FROM_PROCESS("canceling the process"),
    INVALID_COMMAND("Invalid command!,\ntry again!")
    ;
    private final String output;

    public String getOutput() {
        return output;
    }

    SignupMenuOutput(String output) {
        this.output = output;
    }
}
