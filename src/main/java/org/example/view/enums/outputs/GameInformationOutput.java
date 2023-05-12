package org.example.view.enums.outputs;


public enum GameInformationOutput {
    SUCCESS("success"),
    NOT_ENOUGH("not enough product"),
    ;
    private final String output;

    GameInformationOutput(String output) {
        this.output = output;
    }

    public String getOutput() {
        return output;
    }
    }

