package org.example.view.enums.outputs;

public enum GameMenuOutput {
    SUCCESSFUL_BUY("successful buy"),
    EROR_BUY_ITEM("you have not enogh money")
    ;

    private final String output;

    public String getOutput() {
        return output;
    }

    GameMenuOutput(String output) {
        this.output = output;
    }

}
