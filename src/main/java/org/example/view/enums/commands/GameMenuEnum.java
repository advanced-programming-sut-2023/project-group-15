package org.example.view.enums.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum GameMenuEnum {
    SET_FOOD_RATE("^\\s*food\\s+rate\\s+-r\\s+?<foodRate>(-2|-1|0|1|2)"),
    SET_TAX_RATE("^\\s*tax\\s+rate\\s+-r\\s+(?<taxRate>-3|-2|-1|0|[1,8])"),
    SHOW_FOOD_RATE("^\\s*food\\s+rate\\s+show\\s*$"),
    SHOW_TAX_RATE("^\\s*tax\\s+rate\\s+show\\s*$"),
    SET_FEAR_RATE("^\\s*fear\\s+rate\\s+-r\\s+(?<fearRate>-5|-4|-3|-2|-1|0|[1,5])$"),
    SHOW_FOOD_LIST("^\\s*show\\s+food\\s+list\\s*$"),
    SHOW_POPULARITY("^\\s*show\\s+popularity\\s*$"),
    SHOW_POPULARITY_FACTORS("^\\s*show\\s+popularity\\s+factors\\s*$"),
    SELECT_UNIT("^\\s*select\\s+unit\\s+-x\\s+(?<x>\\d)\\s+-y\\s+(?<y>\\d)$"),
    MOVE_UNIT("^\\s*move\\s+unit\\s+-x\\s+(?<x>\\d)\\s+-y\\s+(?<y>\\d)$"),
    DIG_TUNNEL("^\\s*dig\\s+tunnel\\s+-x\\s+(?<x>\\d)\\s+-y\\s+(?<y>\\d)$"),
    SET_STATE("^\\s*set\\s+-x\\s+(?<x>\\d)\\s+-y(?<y>\\d)\\s+-s(?<state>standing|defensive|offensive)$"),
    AIR_ATTACK("^\\s*attack\\s+-x\\s+(?<x>\\d)\\s+-y\\s+(?<y>\\d)$"),
    POUR_OIL("^\\s*pour\\s+oil\\s+-d\\s+(?<direction>up|down|right|left)$"),
    DISBAND_UNIT("^\\s*disband\\s+unit$"),
    DIG_DITCH("^\\s*dig\\s+ditch\\s+-x\\s+(?<x>\\d)\\s+-y\\s+(?<y>\\d)$"),
    PATROL_UNIT("^\\s*patrol\\s+unit\\s+-x1\\s+(?<x1>\\d)\\s+-y1\\s+(?<y1>\\d)\\s+-x2\\s+(?<x2>\\d)\\s+-y2\\s+(?<y2>\\d)$"),
    STOP_PATROLLING("^\\s*stop\\s+patrolling\\s*$"),
    BUILD_EQUIPMENT("^\\s*build\\s+-q\\s+(?<equipment>trebuchet|portable shield|battering ram|catapults)$"),
    SELL_ITEM("^\\s*sell\\s+-i\\s+(?<item>\\w+)\\s+-a\\s+(?<number>\\d)$"),
    BUY_ITEM("^\\s*buy\\s+-i\\s+(?<item>\\w+)\\s+-a\\s+(?<number>\\d)$"),
    SHOW_PRICE_LIST("^\\s*show\\s+price\\s+list$"),
    SHOW_MAP("show map -(x|y) (\\d+) -(x|y) (\\d+)"),
    SELECT_BUILDING("select building -(x|y) (\\d+) -(x|y) (\\d+) ")
    ;


    private final String regex;

    GameMenuEnum(String regex) {
        this.regex = regex;
    }

    public static Matcher getMatcher(String input, GameMenuEnum regex) {
        Matcher matcher = Pattern.compile(regex.regex, Pattern.CASE_INSENSITIVE).matcher(input);
        matcher.matches();
       // System.out.println("this is in getmatcher: "+matcher);
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
