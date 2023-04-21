package org.example.veiw.enums.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum LoginMenuEnum {
    USER_LOGIN("^\\s*user\\s+login\\s*"),
    FORGET_PASSWORD("^\\s*forgot\\s+my\\s+password\\s*$"),
    USER_LOGOUT("^\\s*user\\s+logout\\s*$"),

    ;
    private final String regex;
    LoginMenuEnum(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }

    public static Matcher getMatcher (String input, LoginMenuEnum regex) {
        Matcher matcher = Pattern.compile(regex.regex,Pattern.CASE_INSENSITIVE).matcher(input);
        return matcher.matches() ? matcher : null;
    }

}
