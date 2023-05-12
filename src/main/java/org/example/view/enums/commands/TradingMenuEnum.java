package org.example.view.enums.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum TradingMenuEnum {
    TRADE("trade (-(m) ([a-z]+) -(t) ([a-z]+))|(-(t) ([a-z]+) -(m) ([a-z]+))"),

    TRADE_LIST("trade list"),

    TRADE_ACCEPT("trade accept ((-i) (\\d+) (-m) ([a-z]+)|(-m) ([a-z]+) (-i) (\\d+))"),

    TRADE_HISTORY("trade history"),
    SHOW_PRICELIST("^\\s*show\\s+price\\s+list\\s*$"),

    BUY("buy ((-i) ([a-z]+) (-a) ([a-z]+))|((-a) ([a-z]+) (-i) ([a-z]+))"),

    SELL("sell ((-i) ([a-z]+) (-a) ([a-z]+))|((-a) ([a-z]+) (-i) ([a-z]+))"),
    ;
    private String regex;

     TradingMenuEnum(String regex) {
        this.regex = regex;
    }
    public String getRegex() {
        return regex;
    }

    public static Matcher getMatcher(String input, TradingMenuEnum regex) {
        Matcher matcher = Pattern.compile(regex.getRegex(), Pattern.CASE_INSENSITIVE).matcher(input);
        return matcher.matches() ? matcher : null;
    }
}
