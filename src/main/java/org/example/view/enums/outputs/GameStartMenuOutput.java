package org.example.view.enums.outputs;

public enum GameStartMenuOutput {
    ADD_USER_SUCCESS("user added successfully"),
    ADD_USER_FORBIDDEN("you are not owner of a game"),
    USER_NOT_FOUND("could not find the user please try again"),

    ;
    private final String output;

    GameStartMenuOutput(String output) {
        this.output = output;
    }

    public String getOutput() {
        return output;
    }
}
