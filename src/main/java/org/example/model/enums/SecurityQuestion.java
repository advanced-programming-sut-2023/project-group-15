//this class is completed!
package org.example.model.enums;


import java.util.ArrayList;

public enum SecurityQuestion {
    FATHER_NAME("1", "What's my father's name?"),
    BROTHER_NAME("2", "What's my brother's name?"),
    LAPTOP_MODEL("3", "What's my laptop model?"),
    PHONE_MODEL("4", "What's my cellphone model?"),
    HAIR_COLOR("5", "What's my hair color?"),
    CAR_COLOR("6", "What's my car color?"),
    FAVORITE_FOOD("7", "What's my favorite food?"),
    FAVORITE_GAME("8", "What's my favorite game?"),
    USER_JOB("9", "What's my job?"),
    USER_AGE("10", "What's my age?");
    private final String question;
    private static final ArrayList<SecurityQuestion> questions = new ArrayList<>();

    static {
        for (int i = 1; i <= 10; i++) {
            questions.add(FATHER_NAME);
            questions.add(BROTHER_NAME);
            questions.add(LAPTOP_MODEL);
            questions.add(PHONE_MODEL);
            questions.add(HAIR_COLOR);
            questions.add(CAR_COLOR);
            questions.add(FAVORITE_FOOD);
            questions.add(FAVORITE_GAME);
            questions.add(USER_JOB);
            questions.add(USER_AGE);
        }
    }

    public static ArrayList<SecurityQuestion> allQuestions() {
        return questions;
    }

    private final String questionNumber;
    public static void questions() {
        System.out.println("1." + SecurityQuestion.FATHER_NAME.getQuestion());
        System.out.println("2." + SecurityQuestion.BROTHER_NAME.getQuestion());
        System.out.println("3." + SecurityQuestion.LAPTOP_MODEL.getQuestion());
        System.out.println("4." + SecurityQuestion.PHONE_MODEL.getQuestion());
        System.out.println("5." + SecurityQuestion.HAIR_COLOR.getQuestion());
        System.out.println("6." + SecurityQuestion.CAR_COLOR.getQuestion());
        System.out.println("7." + SecurityQuestion.FAVORITE_FOOD.getQuestion());
        System.out.println("8." + SecurityQuestion.FAVORITE_GAME.getQuestion());
        System.out.println("9." + SecurityQuestion.USER_JOB.getQuestion());
        System.out.println("10." + SecurityQuestion.USER_AGE.getQuestion());
    }
    SecurityQuestion(String questionNumber, String question) {
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