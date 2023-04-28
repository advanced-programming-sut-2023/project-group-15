package org.example.view.enums.commands;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum MapMenuEnum {


    SHOW_MAP_DETAILS("\\s*show\\s+details\\s+-x\\s+(?<xCoordinate>[\\d]+)\\s+-y\\s+(?<yCoordinate>[\\d]+)\\s*$"),
    MAP_MOVING("map\\s+(?<firstDirection>\\d+)?\\s(?<firstMovement>\\S+)\\s(?<secondDirection>\\d+)?\\s(?<secondMovement>\\S+)\\s*"),
    ;
    private final String regex;
    MapMenuEnum(String regex)
    {
        this.regex = regex ;
    }
    public static Matcher getMatcher(String input, MapMenuEnum regex)
    {
        Matcher matcher = Pattern.compile(regex.regex,Pattern.CASE_INSENSITIVE).matcher(input);
        return matcher.matches() ? matcher : null ;
    }

}
