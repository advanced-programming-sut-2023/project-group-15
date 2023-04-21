package org.example.veiw.enums.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum SignupMenuEnum{
    USER_CREATION("^\\s*user\\s+create\\s*"),
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
        Matcher matcher = Pattern.compile(regex.getRegex(),Pattern.CASE_INSENSITIVE).matcher(input);
        return matcher.matches() ? matcher : null ;
    }

}
