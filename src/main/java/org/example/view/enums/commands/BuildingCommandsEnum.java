package org.example.view.enums.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum BuildingCommandsEnum {
    DROP_BUILDING("^\\s*drop\\s*building\\s+((-x\\s+(?<x>\\S*)\\s*)|(-y\\s+(?<y>\\S*)\\s*)|(-type\\s+(?<type>\\S*)\\s*))*$"),
    SELECT_BUILDING("^\\s*select\\s*building\\s+((-x\\s+(?<x>\\S*)\\s*)|(-y\\s+(?<y>\\S*)\\s*))*$"),
    CREATE_UNIT("^\\s*create\\s*unit\\s+((-t\\s+(?<type>\\S*)\\s*)|(-c\\s+(?<count>\\S*)\\s*))*$"),
    REPEAR("\\s*repair\\s*"),
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
