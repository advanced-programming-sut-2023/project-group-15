package org.example.view.enums.outputs;

public enum GameMenuOutput {
    SUCCESSFUL_BUY("successful buy"),
    EROR_BUY_ITEM("you do not have enough money"),
    SUCCESSFUL_SELL("successful sell"),
    ERROR_SELL("you do not have enough items"),
    ;

    private final String output;

    public String getOutput() {
        return output;
    }

    GameMenuOutput(String output) {
        this.output = output;
    }

}
