package org.example.view.enums.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum MapEnvironmentEnum {
   MAP_MOVING("map ((left|right) (\\d+)*(\\s+)*(up|down)(\\s+)*(\\d+)*)" +
                      "|map ((up|down) (\\d+)*(\\s+)*(left|right)(\\s+)*(\\d+)*)"),
   MAP_DETAILS("show details -(x|y) (\\d+) -(x|y) (\\d+)"),
    SET_TEXTURE("settexture -(x|y) (\\d+) -(x|y) (\\d+) -t (a-z)"),
    SET_TEXTURE2("settexture -(x1|y1) (\\d+) -(x2|y2) (\\d+) -t (a-z))"),
    CLEAR("clear -(x|y) (\\d+) -(x|y) (\\d+)")

    ;
    private final String regex;

    MapEnvironmentEnum(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }

    public static Matcher getMatcher(String input, MapEnvironmentEnum regex) {
        Matcher matcher = Pattern.compile(regex.getRegex(), Pattern.CASE_INSENSITIVE).matcher(input);
        return matcher.matches() ? matcher : null;
    }

}
