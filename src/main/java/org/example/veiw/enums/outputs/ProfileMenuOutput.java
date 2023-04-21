package org.example.veiw.enums.outputs;

public enum ProfileMenuOutput {
    INVALID_CURRENT_PASSWORD("Current password is incorrect!"),
    INVALID_NEW_PASSWORD("Please enter a new password!"),
    INVALID_NEW_USERNAME("you entered invalid format of username!,\ntry again!"),
    INVALID_NEW_NICKNAME("you entered invalid format of nickname!,\ntry again!"),
    INVALID_NEW_EMAIL("you entered invalid format of email!,\ntry again!"),
    INVALID_COMMAND("you entered invalid command!,\nenter \"game --help\" for hint!"),

    ;
    private final String output;

    public String getOutput() {
        return output;
    }

    ProfileMenuOutput(String output) {
        this.output = output;
    }
}
