package org.example.view.enums.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum GameMenuEnum {
    SHOW_MAP("^\\s*show\\s+map\\s+-x\\s+(?<xCoordinate>[\\d]+)\\s+-y\\s+(?<yCoordinate>[\\d]+)\\s*$"),
    ;
    public final  String regex;

    GameMenuEnum(String regex) {
        this.regex = regex;
    }
    public static Matcher getMatcher (String input , GameMenuEnum regex)
    {
        Matcher matcher = Pattern.compile(regex.regex,Pattern.CASE_INSENSITIVE).matcher(input);
        return matcher.matches() ? matcher : null;
    }
}
