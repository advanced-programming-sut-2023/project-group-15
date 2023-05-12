package org.example.model;

import org.example.model.enums.SecurityQuestion;
import org.example.model.gameData.GameDataBase;
import org.example.model.gameData.Government;
import org.example.model.gameData.Trade;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String passRecoveryQuestion;
    private String passRecoveryAnswer;
    private int highscore;
    private int rank;
    private String slogan;
    private int userNO;
    private Tile[][] map;
    private Government government;
    private int turn;
    private ArrayList<GameDataBase> userGames;
    private List <Trade> tradeList = new ArrayList<>();
    private List <Trade> tradeReqList = new ArrayList<>();
    private List <Trade > tradeHistory = new ArrayList<>();

    public static final ArrayList<User> allUsers = new ArrayList<>();
    public User(String username, String password, String nickname, String email , String passRecoveryQuestion , String passRecoveryAnswer , int rank , int highscore) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.passRecoveryAnswer = passRecoveryAnswer;
        this.passRecoveryQuestion = passRecoveryQuestion;
        this.rank = rank;
        this.email = email;
        this.highscore = highscore;
    }
    public User(String username, String password, String nickname, String email , String slogan, String passRecoveryQuestion , String passRecoveryAnswer , String rank , String  highscore) {
        this.username = username;
        this.password = password;
        this.slogan = slogan;
        this.nickname = nickname;
        this.passRecoveryAnswer = passRecoveryAnswer;
        this.passRecoveryQuestion = passRecoveryQuestion;
        this.rank = Integer.valueOf(rank);
        this.email = email;
        this.highscore = Integer.valueOf(highscore);
    }
    public User(String username, String password, String nickname, String email) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
    }

    public User(String username, String password, String nickname, String email, String slogan) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.slogan = slogan;
        this.addUser();
    }

    public ArrayList<User> getAllUsers() {
        return allUsers;
    }

    public void addUser() {
        allUsers.add(this);
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setHighscore(int highscore) {
        this.highscore = highscore;
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

    public int getHighscore() {
        return this.highscore;
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

    public void setMap(Tile[][] map)
    {
        this.map = map ;
    }

    public static User findUserWithPass(String password) {
        for (User user : User.allUsers) {
            if (user.getPassword().equals(password))
                return user;
        }
        return null;
    }

    public GameDataBase findUserGame() {
        //TODO: search in user games
        return null;
    }
    public void addGame(GameDataBase gameDataBase) {
        this.userGames.add(gameDataBase);
    }

    public Tile[][] getMap() {
        return map;
    }

    public SecurityQuestion findUserQuestionWithUsername() {
        for (User user:User.allUsers) {
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

    public List<Trade> getTradeList() {
        return tradeList;
    }

    public void setTradeList(List<Trade> tradeList) {
        this.tradeList = tradeList;
    }

    public List<Trade> getTradeReqList() {
        return tradeReqList;
    }

    public void setTradeReqList(List<Trade> tradeReqList) {
        this.tradeReqList = tradeReqList;
    }

    public List<Trade> getTradeHistory() {
        return tradeHistory;
    }

    public void setTradeHistory(List<Trade> tradeHistory) {
        this.tradeHistory = tradeHistory;
    }
}
