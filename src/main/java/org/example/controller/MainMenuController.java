package org.example.controller;

import org.example.model.enums.SecurityQuestion;

public class MainMenuController {
    private String username;
    private String password;
    private String nickname;
    private String slogan;
    private String email;
    private String clipBoard;
    private SecurityQuestion passRecoveryQuestion;
    private String passRecoveryAnswer;
    private int score;
    private int rank;


    public MainMenuController() {
        this.username = null;
        this.password = null;
        this.nickname = null;
        this.slogan = null;
        this.email = null;
        this.clipBoard = null;
        this.passRecoveryAnswer = null;
        this.passRecoveryQuestion = null;
        this.score = 0;
    }

    public void setPassRecoveryQuestion(SecurityQuestion passRecoveryQuestion) {
        this.passRecoveryQuestion = passRecoveryQuestion;
    }

    public void setPassRecoveryAnswer(String passRecoveryAnswer) {
        this.passRecoveryAnswer = passRecoveryAnswer;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public SecurityQuestion getPassRecoveryQuestion() {
        return passRecoveryQuestion;
    }

    public String getPassRecoveryAnswer() {
        return passRecoveryAnswer;
    }

    public int getScore() {
        return score;
    }

    public int getRank() {
        return rank;
    }

    public String getClipBoard() {
        return clipBoard;
    }

    public void setClipBoard(String clipBoard) {
        this.clipBoard = clipBoard;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNickname() {
        return nickname;
    }

    public String getSlogan() {
        return slogan;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}