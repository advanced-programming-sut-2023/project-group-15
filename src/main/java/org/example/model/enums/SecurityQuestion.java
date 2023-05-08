package org.example.model.enums;

import org.example.model.User;

import java.util.ArrayList;

public enum SecurityQuestion {
    FATHER_NAME("1","What's my father's name?"),
    BROTHER_NAME("2","What's my brother's name?"),
    LAPTOP_MODEL("3","What's my laptop model?"),
    PHONE_MODEL("4","What's my cellphone model?"),
    HAIR_COLOR("5","What's my hair color?"),
    CAR_COLOR("6","What's my car color?"),
    FAVORITE_FOOD("7","What's my favorite food?"),
    FAVORITE_GAME("8","What's my favorite game?"),
    USER_JOB("9","What's my job?"),
    USER_AGE("10","What's my age?")
    ;
    private final String question;
    private static final ArrayList<SecurityQuestion> questions = new ArrayList<>();

    static {
        for (int i=1;i<=10;i++) {
            questions.add(FATHER_NAME);
            questions.add(BROTHER_NAME);
            questions.add(LAPTOP_MODEL);
            questions.add(PHONE_MODEL);
            questions.add(HAIR_COLOR);
            questions.add(CAR_COLOR);
            questions.add(FAVORITE_GAME);
            questions.add(FAVORITE_GAME);
            questions.add(USER_JOB);
            questions.add(USER_AGE);
        }
    }
    public static ArrayList<SecurityQuestion> allQuestions() {
        return questions;
    }

    private final String questionNumber;
    SecurityQuestion(String questionNumber,String question) {
        this.question = question;
        this.questionNumber = questionNumber;
    }
    public String getQuestion() {
        return question;
    }
    public String getQuestionNumber() {
        return questionNumber;
    }
}