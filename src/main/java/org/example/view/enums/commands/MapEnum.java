//this is class is completed!
package org.example.view.enums.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum MapEnum {
    MAP_MOVING("^\\s*map\\s+(((?<l>left)\\s*(?<ln>\\d+)?\\s*)|((?<r>right)\\s*(?<rn>\\d+)?\\s*)|((?<u>up)\\s*(?<un>\\d+)?\\s*)|((?<d>down)\\s*(?<dn>\\d+)?\\s*)){2}\\s*$$"),
    MAP_DETAILS("^\\s*show\\s+details\\s+((-x\\s*(?<x>\\d+)\\s*)|(-y\\s*(?<y>\\d+)\\s*)){2}\\s*$"),
    SET_TEXTURE("^\\s*set\\s*texture\\s+((-x\\s+(?<x>\\d+)\\s*)|(-y\\s+(?<y>\\d+)\\s*)|(-t\\s+(?<type>[a-z ]+))){3}\\s*$"),
    SET_TEXTURE2("^\\s*set\\s*texture\\s+((-x1\\s+(?<x1>\\d+)\\s*)|(-y1\\s+(?<y1>\\d+)\\s*)|(-y2\\s+(?<y2>\\d+)\\s*)|(-x2\\s+(?<x2>\\d+)\\s*)|(-t\\s+(?<type>[a-z ]+))){5}\\s*$"),
    CLEAR("^\\s*clear\\s+((-x\\s+(?<x>\\d+)\\s*)|(-y\\s+(?<y>\\d+)\\s*)){2}\\s*$"),
    DROP_TREE("^\\s*drop\\s*tree\\s*((-x\\s*(?<x>\\d+)\\s*)|(-y\\s*(?<y>\\d+)\\s*)|(-t\\s*(?<type>[a-z ]+)\\s*)){3}\\s*$"),
    DROP_BUILDING("^\\s*drop\\s*building\\s+((-x\\s+(?<x>\\S*)\\s*)|(-y\\s+(?<y>\\S*)\\s*)|(-type\\s+(?<type>\\S*)\\s*)){3}\\s*$"),
    DROP_ROCK("^\\s*drop\\s*rock\\s+((-x\\s+(?<x>\\S*)\\s*)|(-y\\s+(?<y>\\S*)\\s*)|(-d\\s+(?<direction>\\S*)\\s*)){3}\\s*$"),
    DROP_UNIT("^\\s*drop\\s*unit\\s+((-x\\s+(?<x>\\d+)\\s*)|(-y\\s+(?<y>\\d+)\\s*)|(-t\\s+(?<type>[a-z ]+)\\s*)|(-c\\s+(?<count>\\d+)\\s*)){4}\\s*$"),

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
