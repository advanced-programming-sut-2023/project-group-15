package org.example.view.enums.outputs;


public enum GameInformationOutput {
    SUCCESS("success"),
    NOT_ENOUGH("not enough product"),
    NOT_ENOUGH_COIN("not enough coins for the trade sender"),
    ACCEPTED_SUCCESSFULLY("trade accepted successfully!");
    private final String output;

    GameInformationOutput(String output) {
        this.output = output;
    }

    public String getOutput() {
        return output;
    }
    }

