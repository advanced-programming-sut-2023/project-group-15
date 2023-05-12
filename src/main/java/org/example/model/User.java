package org.example.model;

import org.example.model.enums.SecurityQuestion;
import org.example.model.gameData.GameDataBase;
import org.example.model.gameData.Government;
import org.example.model.gameData.Trade;

import java.util.ArrayList;
import java.util.Objects;
import java.util.List;

public class User {
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String passRecoveryQuestion;
    private String passRecoveryAnswer;
    private int highScore;
    private int rank;
    private String slogan;
    private int userNO;
    private boolean stayLoggedIn;
    private Tile[][] map;
    private Government government;
    private int turn;
    private final List<Trade> tradeSendList;
    private final List<Trade> tradeReqList;
    private final List<Trade> tradeHistoryList;
    int lastOrderIndex = 0;

    public User(String username, String password, String nickname, String email, String passRecoveryQuestion, String passRecoveryAnswer, int rank, int highScore) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.passRecoveryAnswer = passRecoveryAnswer;
        this.passRecoveryQuestion = passRecoveryQuestion;
        this.rank = rank;
        this.email = email;
        this.highScore = highScore;
        this.stayLoggedIn = false;
        this.addUser();
        this.tradeHistoryList = new ArrayList<>();
        this.tradeReqList = new ArrayList<>();
        this.tradeSendList = new ArrayList<>();
    }

    public User(String username, String password, String nickname, String email, String slogan, String passRecoveryQuestion, String passRecoveryAnswer, String rank, String highScore) {
        this.username = username;
        this.password = password;
        this.slogan = slogan;
        this.nickname = nickname;
        this.passRecoveryAnswer = passRecoveryAnswer;
        this.passRecoveryQuestion = passRecoveryQuestion;
        this.rank = Integer.parseInt(rank);
        this.email = email;
        this.highScore = Integer.parseInt(highScore);
        this.stayLoggedIn = false;
        this.addUser();
        this.tradeHistoryList = new ArrayList<>();
        this.tradeReqList = new ArrayList<>();
        this.tradeSendList = new ArrayList<>();
    }

    public User(String username, String password, String nickname, String email) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.passRecoveryAnswer = null;
        this.passRecoveryQuestion = null;
        this.highScore = 0;
        this.email = email;
        this.stayLoggedIn = false;
        this.addUser();
        this.tradeHistoryList = new ArrayList<>();
        this.tradeReqList = new ArrayList<>();
        this.tradeSendList = new ArrayList<>();
    }

    public User(String username, String password, String nickname, String email, String slogan) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.slogan = slogan;
        this.stayLoggedIn = false;
        this.addUser();
        this.tradeHistoryList = new ArrayList<>();
        this.tradeReqList = new ArrayList<>();
        this.tradeSendList = new ArrayList<>();
    }


    public void addUser() {
        GameDataBase.getAllUsers().add(this);
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getEmail() {
        return this.email;
    }

    public String getSlogan() {
        return this.slogan;
    }

    public int getRank() {
        return this.rank;
    }

    public int getHighScore() {
        return this.highScore;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public void setUserNO(int userNO) {
        this.userNO = userNO;
    }

    public void setPassRecoveryQuestion(String passRecoveryQuestion) {
        this.passRecoveryQuestion = passRecoveryQuestion;
    }

    public void setPassRecoveryAnswer(String passRecoveryAnswer) {
        this.passRecoveryAnswer = passRecoveryAnswer;
    }

    public String getPassRecoveryQuestion() {
        return this.passRecoveryQuestion;
    }

    public String getPassRecoveryAnswer() {
        return this.passRecoveryAnswer;
    }

    public int getUserNO() {
        return userNO;
    }

    public void setMap(Tile[][] map) {
        this.map = map;
    }

    public static User findUserWithPass(String password) {
        for (User user : GameDataBase.getAllUsers()) {
            if (user.getPassword().equals(password))
                return user;
        }
        return null;
    }

    public Tile[][] getMap() {
        return map;
    }

    public SecurityQuestion findUserQuestionWithUsername() {
        for (User user : GameDataBase.getAllUsers()) {
            if (user.getUsername().equals(this.getUsername())) {
                for (SecurityQuestion question : SecurityQuestion.allQuestions()) {
                    if (question.getQuestion().equals(user.getPassRecoveryQuestion())) {
                        return question;
                    }
                }
            }
        }
        return null;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public Government getGovernment() {
        return government;
    }

    public List<Trade> getTradeSendList() {
        return tradeSendList;
    }

    public List<Trade> getTradeReqList() {
        return tradeReqList;
    }

    public List<Trade> getTradeHistoryList() {
        return tradeHistoryList;
    }

    public int getLastOrderIndex() {
        return lastOrderIndex;
    }

    public boolean isStayLoggedIn() {
        return stayLoggedIn;
    }

    public void setStayLoggedIn(boolean stayLoggedIn) {
        this.stayLoggedIn = stayLoggedIn;
    }

    public void setLastOrderIndex(int lastOrderIndex) {
        this.lastOrderIndex = lastOrderIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username.equals(user.username) && password.equals(user.password) && nickname.equals(user.nickname) && email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, nickname, email, slogan);
    }
}
