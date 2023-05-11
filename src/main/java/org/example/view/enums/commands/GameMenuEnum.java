package org.example.view.enums.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum GameMenuEnum {
    SHOW_MAP("^\\s*show\\s+map\\s+((-x\\s+(?<x>\\S+)\\s*)|(-y\\s+(?<y>\\S+)\\s*))*$"),
    SET_FOOD_RATE("^\\s*food\\s*rate\\s*-r\\s*(?<foodRate>(-2|-1|0|1|2)\\s*$"),
    SET_TAX_RATE("^\\s*tax\\s*rate\\s*-r\\s*(?<taxRate>(-3|-2|-1|0|[1,8])"),
    SHOW_FOOD_RATE("^\\s*food\\s+rate\\s+show\\s*$"),
    SHOW_TAX_RATE("^\\s*food\\s+rate\\s+show\\s*$"),
    SET_FEAR_RATE("^\\s*fear\\s*rate\\s*-r\\s*(?<fearRate>(-5|-4|-3|-2|-1|0|[1,5])\\s*"),
    SHOW_FOOD_LIST("^\\s*show\\s+food\\s+list\\s*$"),
    SHOW_POPULARITY("^\\s*show\\s+popularity\\s*$"),
    SHOW_POPULARITY_FACTORS("^\\s*show\\s+popularity\\s+factors\\s*$"),
    ;


    private final String regex;

    GameMenuEnum(String regex) {
        this.regex = regex;
    }

    public static Matcher getMatcher(String input, GameMenuEnum regex) {
        Matcher matcher = Pattern.compile(regex.regex, Pattern.CASE_INSENSITIVE).matcher(input);
        matcher.matches();
        System.out.println("this is in getmatcher: "+matcher);
        /*while (matcher.find()) {
            System.out.println(matcher);
            for (int i = 0; i <= matcher.groupCount(); i++) {
                System.out.println("------------------------------------");
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
         n}*/

        return matcher.matches() ? matcher : null;
    }

    public String getRegex() {
        return regex;
    }

}
