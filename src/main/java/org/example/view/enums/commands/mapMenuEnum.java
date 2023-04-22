package org.example.view.enums.commands;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum mapMenuEnum {


    SHOW_MAP("^\\s+show\\s+map\\s+-x\\s+-y\\s*"),
    SHOW_MAP_DETAILS("\\s*show\\s+details\\s+-x\\s+-y\\s*");
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
