//this class is completed!
package org.example.view.enums.outputs;

public enum GameMenuOutput {
    SUCCESSFUL_SELL("successful sell"),
    SUCCESSFUL_BUY("successful buy"),
    ERROR_SELL("you don not have enough item"),
    ERROR_BUY_ITEM("you do not have enough money"),
    ;
    private final String output;

    public String getOutput() {
        return output;
    }

    GameMenuOutput(String output) {
        this.output = output;
    }
}
