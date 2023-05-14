package org.example.view.enums.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum TradingMenuEnum {
    TRADE("^\\s*trade\\s+((-m\\s+(?<message>\\w+)\\s*)|(-t\\s+(?<resourceType>\\w+)\\s*)|" +
            "(-a\\s+(?<resourceAmount>\\d+)\\s*)|(-p\\s+(?<price>\\d+))){4}\\s*$"),
    TRADE_LIST("^\\s*trade\\s+list\\s*$"),
    TRADE_ACCEPT("^\\s*trade\\s+accept\\s+((-i\\s+(?<number>\\d+)\\s*)|(-m\\s+(?<message>)\\w+)\\s*){2}\\s*$"),
    TRADE_HISTORY("^\\s*trade\\s+history\\s*$"),
    SHOW_PRICELIST("^\\s*show\\s+price\\s+list\\s*$"),
    BUY("^\\s*buy\\s+((-i\\s+(?<name>\\w+)\\s*)|(-a\\s+(?<amount>\\d+)\\s*))*\\s*$"),
    SELECT_USER("^\\s*select\\s+user\\s+-u\\s+(?<username>\\S+)\\s*$"),
    SELL("^\\s*sell\\s+((-i\\s+(?<item>\\w+)\\s*)|(-a\\s+(?<amount>\\d+)\\s*))*\\s*$"),

    ;
    private final String regex;

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
