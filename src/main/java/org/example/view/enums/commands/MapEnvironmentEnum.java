package org.example.view.enums.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum MapEnvironmentEnum {
    SET_TEXTURE("settexture\\s+(((\\s-(?<flag>(x|y))( ((?<group>\\S+)|(\"(?<group2[^\"].+)\")))){3}"),
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
