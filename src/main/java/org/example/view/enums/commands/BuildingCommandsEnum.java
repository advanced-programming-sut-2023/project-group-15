package org.example.view.enums.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum BuildingCommandsEnum {
    DROP_BUILDING("drop building -((x|y) (\\d+) -(x|y) (\\d+) (-type) ([a-z]+))" +
            "|((-type) ([a-z]+) -(x|y) (\\d+) -(x|y) (\\d+))" +
            "|(-(x|y) (\\d+) (-type) ([a-z]+) -(x|y) (\\d+))"),
    SELECT_BUILDING("^\\s*select\\s*building\\s+((-x\\s+(?<x>\\S*)\\s*)|(-y\\s+(?<y>\\S*)\\s*))*$"),
    REPAIR("\\s*repair\\s*"),
    ;
    private final String command;
    BuildingCommandsEnum(String command) {
        this.command = command;
    }
    public String getCommand() {
        return command;
    }
    public static Matcher getMatcher (String input, BuildingCommandsEnum command) {
        Matcher matcher = Pattern.compile(command.getCommand()).matcher(input);
        return matcher.matches() ? matcher : null;
    }

}
