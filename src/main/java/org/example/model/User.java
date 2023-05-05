package org.example.model;

import org.example.model.gameData.GameDataBase;
import org.example.model.gameData.Map;

import java.util.ArrayList;
import java.util.Arrays;

public class User {
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String passRecoveryQuestion;
    private String passRecoveryAnswer;
    private int score;
    private int rank;
    private String slogan;
    private int userNO;
    private Tile[][] map;
    private String[] tradeHistory;
    private String [] tradeList;
    private ArrayList<GameDataBase> userGames;
    public static final ArrayList<User> allUsers = new ArrayList<>();
    public User(String username, String password, String nickname, String email) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.passRecoveryAnswer = null;
        this.passRecoveryQuestion = null;
        this.score = 0;
        this.email = email;
        this.userGames = new ArrayList<>();
        this.addUser();
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

    public void setScore(int score) {
        this.score = score;
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

    public int getScore() {
        return this.score;
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

    public String[] getTradeHistory() {
        return tradeHistory;
    }

    public String[] getTradeList() {
        return tradeList;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", passRecoveryQuestion='" + passRecoveryQuestion + '\'' +
                ", passRecoveryAnswer='" + passRecoveryAnswer + '\'' +
                ", score=" + score +
                ", rank=" + rank +
                ", slogan='" + slogan + '\'' +
                ", userNO=" + userNO +
                ", tradeHistory=" + Arrays.toString(tradeHistory) +
                ", tradeList=" + Arrays.toString(tradeList) +
                '}';
    }
}
