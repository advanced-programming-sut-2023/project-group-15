package org.example.model;

public class Styles {
    String successfulMessage = String.format("-fx-text-fill: Green;");
    String errorMessage = String.format("-fx-text-fill: RED;");
    String errorStyle = String.format("-fx-border-color: RED; -fx-border-width: 2; -fx-border-radius: 5;");
    String successStyle = String.format("-fx-border-color: #A9A9A9; -fx-border-width: 2; -fx-border-radius: 5;");

    public String getSuccessfulMessage() {
        return successfulMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getErrorStyle() {
        return errorStyle;
    }

    public String getSuccessStyle() {
        return successStyle;
    }
}
