package org.example.view.enums.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum GameMenuEnum {
    SHOW_MAP("^\\s*show\\s+map\\s+((-x\\s+(?<x>\\d+)\\s*)|(-y\\s+(?<y>\\d+)\\s*))*\\s*$"),
    SET_TAX_RATE("^\\s*tax\\s+rate\\s+-r\\s+(?<taxRate>-3|-2|-1|0|[1-8])\\s*$"),
    SET_FOOD_RATE("^\\s*food\\s+rate\\s+-r\\s+(?<foodRate>-2|-1|0|1|2)\\s*$"),
    SET_FEAR_RATE("^\\s*fear\\s+rate\\s+-r\\s+(?<fearRate>-5|-4|-3|-2|-1|0|[1-5])\\s*$"),
    SHOW_FOOD_RATE("^\\s*food\\s+rate\\s+show\\s*$"),
    SHOW_TAX_RATE("^\\s*((tax\\s+rate\\s*)|(show\\s*)){2}\\s*$"),
    SHOW_FOOD_LIST("^\\s*((food\\s+rate\\s*)|(show\\s*)){2}\\s*$"),
    SHOW_POPULARITY("^\\s*show\\s+popularity\\s*$"),
    SHOW_POPULARITY_FACTORS("^\\s*show\\s+popularity\\s+factors\\s*$"),


    DROP_UNIT("^\\s*drop\\s*unit\\s+((-x\\s+(?<x>\\d+)\\s*)|(-y\\s+(?<y>\\d+)\\s*)|(-t\\s+(?<name>\\w+)\\s*)|(-c\\s+(?<count>\\d+)\\s*)){4}\\s*$"),
    SELECT_UNIT("^\\s*select\\s+unit\\s+((-x\\s+(?<x>\\d+)\\s*)|(-y\\s+(?<y>\\d+)\\s*))+\\s*$$"),
    MOVE_UNIT("^\\s*move\\s+unit\\s+((-x\\s+(?<x>\\d+)\\s*)|(-y\\s+(?<y>\\d+)\\s*))*\\s*$"),
    DIG_TUNNEL("^\\s*dig\\s+tunnel\\s+((-x\\s+(?<x>\\d+)\\s*)|(-y\\s+(?<y>\\d+)\\s*))*\\s*$"),
    SET_STATE("^\\s*set\\s+((-x\\s+(?<x>\\d+)\\s*)|(-y\\s+(?<y>\\d+)\\s*)|(-s\\s+(?<state>standing|defensive|offensive)\\s*))*\\s*$"),
    AIR_ATTACK("^\\s*attack\\s+((-x\\s+(?<x>\\d+)\\s*)|(-y\\s+(?<y>\\d+)\\s*))*\\s*$"),
    POUR_OIL("^\\s*pour\\s+oil\\s+-d\\s+(?<direction>up|down|right|left)\\s*$"),
    DISBAND_UNIT("^\\s*disband\\s+unit\\s*$"),
    DIG_DITCH("^\\s*dig\\s+ditch\\s+((-x\\s+(?<x>\\d+)\\s*)|(-y\\s+(?<y>\\d+)\\s*))*\\s*$"),
    PATROL_UNIT("^\\s*patrol\\s+unit\\s+((-x1\\s+(?<x1>\\d+)\\s*)|(-y1\\s+(?<y1>\\d+)\\s*)|(-x2\\s+(?<x2>\\d+)\\s*)|(-y2\\s+(?<y2>\\d+)\\s*))*\\s*$"),
    STOP_PATROLLING("^\\s*stop\\s+patrolling\\s*$"),
    BUILD_EQUIPMENT("^\\s*build\\s+-q\\s+(?<equipment>trebuchet|portable\\s+shield|battering\\s+ram|catapults)\\s*$"),
    SELL_ITEM("^\\s*sell\\s+((-i\\s+(?<item>\\w+)\\s*)|(-a\\s+(?<number>\\d+)\\s*))*\\s*$"),
    BUY_ITEM("^\\s*buy\\s+((-i\\s+(?<item>\\w+)\\s*)|(-a\\s+(?<number>\\d+)\\s*))*\\s*$"),
    SHOW_PRICE_LIST("^\\s*show\\s+price\\s+list\\s*$"),
    SELECT_BUILDING("^\\s*select\\s+building\\s+-(x|y)\\s+(\\d+)\\s+-(x|y)\\s+(\\d+)\\s*$"),
    TRADE_MENU("^\\s*enter\\s+trade\\s+menu\\s*$"),
    BUILDING_MENU("^\\s*enter\\s+building\\s+menu\\s*$"),
    ;


    private final String regex;

    GameMenuEnum(String regex) {
        this.regex = regex;
    }

    public static Matcher getMatcher(String input, GameMenuEnum regex) {
        Matcher matcher = Pattern.compile(regex.regex, Pattern.CASE_INSENSITIVE).matcher(input);
        return matcher.matches() ? matcher : null;
    }

    public String getRegex() {
        return regex;
    }

}
