//this is class is completed!
package org.example.view.enums.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum ProfileMenuEnum {
    CHANGE_PROFILE_USERNAME("^\\s*profile\\s+change\\s*(\\s*-u\\s+(?<username>[^\\\"][^\\s]+|\\\"[^\\\"]+\\\"))\\s*$"),
    CHANGE_PROFILE_NICKNAME("^\\s*profile\\s+change\\s+-n\\s+(?<nickname>[^\\\"]\\S*|\\\"[^\\\"]+\\\")\\s*$"),
    CHANGE_PROFILE_EMAIL("^\\s*profile\\s+change\\s+-e\\s+(?<email>[^\\\"]\\S*|\\\"[^\\\"]+\\\")\\s*$"),
    CHANGE_PASSWORD("^\\s*profile\\s+change\\s+password\\s+((-o\\s+(?<oldPass>[^\\\"]\\S*|\\\"[^\\\"]+\\\")\\s*)|" +
            "(-n\\s+(?<newPass>[^\\\"]\\S*|\\\"[^\\\"]+\\\")\\s*))+$"),
    CHANGE_SLOGAN("^\\s*profile\\s+change\\s+slogan\\s+-s\\s+(?<slogan>[^\\\"]\\S*|\\\"[^\\\"]+\\\")\\s*$"),
    REMOVE_SLOGAN("^\\s*profile\\s+remove\\s+slogan\\s*$"),
    DISPLAY_USER_PROFILE("^\\s*profile\\s+display\\s+high\\s*score\\s*$"),
    DISPLAY_USER_RANK("^\\s*profile\\s+display\\s+rank\\s*$"),
    DISPLAY_USER_SLOGAN("^\\s*profile\\s+display\\s+slogan\\s*$"),
    DISPLAY_PROFILE("^\\s*profile\\s+display\\s*$"),
    LOGOUT("^\\s*log\\s*out\\s*$");
    private final String regex;

    ProfileMenuEnum(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return this.regex;
    }

    public static Matcher getMatcher(String input, ProfileMenuEnum regex) {
        Matcher matcher = Pattern.compile(regex.regex, Pattern.CASE_INSENSITIVE).matcher(input);
        return matcher.matches() ? matcher : null;
    }
}
