package org.example.view.enums.commands;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum mapMenuEnum {


    SHOW_MAP_DETAILS("\\s*show\\s+details\\s+-x\\s+(?<xCoordinate>[\\d]+)\\s+-y\\s+(?<yCoordinate>[\\d]+)\\s*$");
    private final String regex;
    mapMenuEnum(String regex)
    {
        this.regex = regex ;
    }
    public static Matcher getMatcher(String input,mapMenuEnum regex)
    {
        Matcher matcher = Pattern.compile(regex.regex,Pattern.CASE_INSENSITIVE).matcher(input);
        return matcher.matches() ? matcher : null ;
    }

}
