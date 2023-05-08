package org.example.view.enums.commands;

import org.example.view.GameStartMenu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum GameStartMenuEnum {

        NEW_GAME("start\\s+new\\s+game"),
        ADD_PLAYER("add user -u (?<name>\\S+)"),
                ;
        private final String regex;

         GameStartMenuEnum(String regex) {
            this.regex = regex;
        }

        public String getRegex() {
            return regex;
        }
            public static Matcher getMatcher (String input,GameStartMenuEnum regex) {
                Matcher matcher = Pattern.compile(regex.getRegex(),Pattern.CASE_INSENSITIVE).matcher(input);
                return matcher.matches() ? matcher : null;

    }

}
