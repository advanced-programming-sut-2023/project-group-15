package org.example.model.enums;
public enum SecurityQuestion {
    FATHER_NAME(1,"What's my father's name?"),
    BROTHER_NAME(2,"What's my brother's name?"),
    LAPTOP_MODEL(3,"What's my laptop model?"),
    PHONE_MODEL(4,"What's my cellphone model?"),
    HAIR_COLOR(5,"What's my hair color?"),
    CAR_COLOR(6,"What's my car color?"),
    FAVORITE_FOOD(7,"What's my favorite food?"),
    FAVORITE_GAME(8,"What's my favorite game?"),
    USER_JOB(9,"What's my job?"),
    USER_AGE(10,"What's my age?")
    ;
    private final String question;
    private final int questionNumber;
    SecurityQuestion(int questionNumber,String question) {
        this.question = question;
        this.questionNumber = questionNumber;
    }
    public String getQuestion() {
        return question;
    }
    public int getQuestionNumber() {
        return questionNumber;
    }
}