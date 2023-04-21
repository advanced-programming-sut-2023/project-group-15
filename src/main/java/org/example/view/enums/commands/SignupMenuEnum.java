package org.example.view.enums.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum SignupMenuEnum {
    USER_CREATION("^user\\s+create\\s+((-u\\s+(?<username>[^\\\"]\\S*|\\\"[^\\\"]+\\\")\\s*)|" +
            "(\\s*-p\\s+(?<password>[^\\\"]\\S*|\\\"[^\\\"]+\\\")\\s+(?<configuration>)[^\\\"]\\S*|" +
            "\\\"[^\\\"]+\\\")\\s*|(-e\\s+(?<email>[^\\\"]\\S*|\\\"[^\\\"]+\\\")\\s*)|" +
            "(-n\\s+(?<nickname>[^\\\"]\\S*|\\\"[^\\\"]+\\\")\\s*)|" +
            "(-s\\s+(?<slogan>[^\\\"]\\S*|\\\"[^\\\"]+\\\")\\s*))+$"),
    PICK_QUESTION("^\\s*question\\s*pick\\s*"),

    ;

    private final String regex;

    SignupMenuEnum(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }

    public static Matcher getMatcher(String input, SignupMenuEnum regex) {
        Matcher matcher = Pattern.compile(regex.getRegex(), Pattern.CASE_INSENSITIVE).matcher(input);
        return matcher.matches() ? matcher : null;
    }

}
