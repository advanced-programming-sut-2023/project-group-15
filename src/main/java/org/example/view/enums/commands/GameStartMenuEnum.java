//this class is completed!
package org.example.view.enums.commands;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum GameStartMenuEnum {
    ADD_PLAYER("^\\s*add\\s+user\\s+(-u\\s+(?<name>[^\\\"]\\S*|\\\"[^\\\"]+\\\")\\s*)$"),
    START_NEW_GAME("^\\s*start\\s+new\\s+game\\s*$"),
    ENTER_GAME("^\\s*enter\\s+game\\s*$"),
    SELECT_MAP("^\\s*map\\s+select\\s+((-a\\s+(?<area>\\d+)\\s*)(-t\\s+(?<type>\\d+)\\s*))*$");
    private final String regex;

    GameStartMenuEnum(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }

    public static Matcher getMatcher(String input, GameStartMenuEnum regex) {
        Matcher matcher = Pattern.compile(regex.getRegex(), Pattern.CASE_INSENSITIVE).matcher(input);
        return matcher.matches() ? matcher : null;
    }

}
