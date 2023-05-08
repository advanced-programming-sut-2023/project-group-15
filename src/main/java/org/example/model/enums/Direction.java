package org.example.model.enums;

public enum Direction {
    UP("up"),
    DOWN("down"),
    LEFT("left"),
    RIGHT("right"),
    NULL("null"),
    ;

    private final String direction;

    Direction(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }

}
