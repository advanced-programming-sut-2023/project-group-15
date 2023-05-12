package org.example.view.enums.outputs;

import org.example.model.gameData.GameInformation;
import org.example.view.enums.commands.LoginMenuEnum;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum GameInformationOutput {
    SUCCESS("success"),
    NOT_ENOUGH("not enough product"),
    ;
    private final String output;

    GameInformationOutput(String output) {
        this.output = output;
    }

    public String getOutput() {
        return output;
    }
    }

