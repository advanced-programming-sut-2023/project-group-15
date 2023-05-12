//this is class is completed!
package org.example.view.enums.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum MapEnum {
    MAP_MOVING("map ((left|right) (\\d+)*(\\s+)*(up|down)(\\s+)*(\\d+)*)" +
            "|map ((up|down) (\\d+)*(\\s+)*(left|right)(\\s+)*(\\d+)*)"),

    MAP_DETAILS("^\\s*show\\s+details\\s+((-x\\s*(?<x>\\d+)\\s*)|(-y\\s*(?<y>\\d+)\\s*))+\\s*$"),
    SET_TEXTURE("^\\s*set\\s*texture\\s+((-x\\s+(?<x>\\d+)\\s*)|(-y\\s+(?<y>\\d+)\\s*)|(-t\\s+(?<type>[a-z ]+)))*\\s*$"),
    SET_TEXTURE2("^\\s*set\\s*texture\\s+((-x1\\s+(?<x1>\\d+)\\s*)|(-y1\\s+(?<y1>\\d+)\\s*)|(-y2\\s+(?<y2>\\d+)\\s*)|(-x2\\s+(?<x2>\\d+)\\s*)|(-t\\s+(?<type>[a-z ]+)))*\\s*$"),
    CLEAR("^\\s*clear\\s+((-x\\s+(?<x>\\d+)\\s*)|(-y\\s+(?<y>\\d+)\\s*))*\\s*$"),
    DROP_TREE("^\\s*drop\\s*tree\\s*((-x\\s*(?<x>\\d+)\\s*)|(-y\\s*(?<y>\\d+)\\s*)|(-t\\s*(?<type>[a-z ]+)\\s*))*\\s*$"),
    DROP_BUILDING("^\\s*drop\\s*building\\s+((-x\\s+(?<x>\\S*)\\s*)|(-y\\s+(?<y>\\S*)\\s*)|(-type\\s+(?<type>\\S*)\\s*))*$"),
    DROP_ROCK("^\\s*drop\\s*rock\\s+((-x\\s+(?<x>\\S*)\\s*)|(-y\\s+(?<y>\\S*)\\s*)|(-d\\s+(?<direction>\\S*)\\s*))*$"),
    DROP_UNIT("^\\s*drop\\s*unit\\s+((-x\\s+(?<x>\\d+)\\s*)|(-y\\s+(?<y>\\d+)\\s*)|(-t\\s+(?<type>[a-z ]+)\\s*)|(-c\\s+(?<count>\\d+)\\s*))*\\s*$"),

    ;
    private final String regex;

    MapEnum(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }

    public static Matcher getMatcher(String input, MapEnum regex) {
        Matcher matcher = Pattern.compile(regex.getRegex(), Pattern.CASE_INSENSITIVE).matcher(input);
        return matcher.matches() ? matcher : null;
    }

}
