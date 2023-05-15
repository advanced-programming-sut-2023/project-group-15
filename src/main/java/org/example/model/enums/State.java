//this class is completed!
package org.example.model.enums;

public enum State {
    STANDING("standing"),
    DEFENSIVE("defensive"),
    OFFENSIVE("offensive"),
    ;

    private final String state;

    State(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
