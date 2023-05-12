//this class is completed!
package org.example.view.enums.outputs;

public enum ProfileMenuOutput {
    USERNAME_CHANGED_SUCCESSFULLY("username changed successfully!"),
    PASSWORD_CHANGED_SUCCESSFULLY("password changed successfully!"),
    NICKNAME_CHANGED_SUCCESSFULLY("nickname changed successfully!"),
    EMAIL_CHANGED_SUCCESSFULLY("email changed successfully!"),
    SLOGAN_CHANGED_SUCCESSFULLY("slogan changed successfully!"),
    SLOGAN_REMOVED_SUCCESSFULLY("slogan removed successfully!"),
    NEWPASS_AND_OLDPASS_ARE_EQUALS("your new password is equal to your current password!,\ntry something else!"),
    INVALID_CURRENT_PASSWORD("Current password is incorrect!"),
    INVALID_NEW_PASSWORD("Please enter a new password!"),
    INVALID_NEW_USERNAME("you entered invalid format of username!,\ntry again!"),
    INVALID_NEW_EMAIL("you entered invalid format of email!,\ntry again!"),
    INVALID_COMMAND("you entered invalid command!,\nenter \"game --help\" for hint!"),
    LOGGED_OUT_SUCCESSFULLY("logged out successfully!"),

    ;
    private final String output;

    public String getOutput() {
        return output;
    }

    ProfileMenuOutput(String output) {
        this.output = output;
    }
}
