package org.example.view.enums.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum BuildingCommandsEnum {
    DROP_BUILDING("^\\s*drop\\s+building\\s+((-x\\s+(?<x>\\d+)\\s*)|(-y\\s+(?<y>\\d+)\\s*)|(-t\\s+(?<type>[^\\\"]\\S*|\\\"[^\\\"]+\\\")\\s*)){3}\\s*$$"),
    SELECT_BUILDING("^\\s*select\\s*building\\s+((-x\\s+(?<x>\\S*)\\s*)|(-y\\s+(?<y>\\S*)\\s*)){2}\\s*$"),
    REPAIR("^\\s*repair\\s*$"),
    CREATE_UNIT("\\s*create\\s+unit\\s+((-t\\s+(?<type>[^\\\"]\\S*|\\\"[^\\\"]+\\\")\\s*|(-c\\s+(?<count>\\d+)\\s*))*$"),

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
