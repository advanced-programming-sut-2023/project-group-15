package org.example.model;

import javafx.scene.image.Image;
import org.example.model.enums.SecurityQuestion;
import org.example.model.gameData.GameDataBase;
import org.example.model.gameData.Government;
import org.example.view.userView.ChooseAvatar;

import java.util.Objects;

public class User {
    ChooseAvatar chooseAvatar = new ChooseAvatar();
    private String username;
    private String password;
    private String clipBoard;
    private String nickname;
    private String email;
    private String passRecoveryQuestion;
    private String passRecoveryAnswer;
    private int highScore;
    private int rank;
    private String slogan;
    private int userNO;
    private boolean stayLoggedIn;
    private Tile[][] playerMap;
    private Government government;
    private Image avatar;
    public void setGovernment(Government government) {
        this.government = government;
    }
    private int turn;
    int lastOrderIndex = 0;

    public User(String username, String password, String nickname, String email, String passRecoveryQuestion, String passRecoveryAnswer, int rank, int highScore) {
        this.userNO = 0;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.passRecoveryAnswer = passRecoveryAnswer;
        this.passRecoveryQuestion = passRecoveryQuestion;
        this.rank = rank;
        this.email = email;
        this.highScore = highScore;
        this.stayLoggedIn = false;
        this.slogan = "the slogan is empty";
        this.avatar = chooseAvatar.getImage6();
    }

    public String getClipBoard() {
        return clipBoard;
    }

    public void setClipBoard(String clipBoard) {
        this.clipBoard = clipBoard;
    }

    public User(String username, String password, String nickname, String email, String slogan, String passRecoveryQuestion, String passRecoveryAnswer, String rank, String highScore) {
        this.userNO = 0;
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
    }

    public User(String username, String password, String nickname, String email) {
        this.userNO = 0;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.passRecoveryAnswer = null;
        this.slogan = "empty";
        this.passRecoveryQuestion = null;
        this.highScore = 0;
        this.email = email;
        this.stayLoggedIn = false;

    }

    public User(String username, String password,String clipBoard, String nickname, String email) {
        this.userNO = 0;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.clipBoard = clipBoard;
        this.email = email;
        this.slogan = "empty";
        this.stayLoggedIn = false;
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
        this.playerMap = map;
    }

    public Image getAvatar() {
        return avatar;
    }

    public void setAvatar(Image avatar) {
        this.avatar = avatar;
    }

    public static User findUserWithPass(String password) {
        for (User user : GameDataBase.getAllUsers()) {
            if (user.getPassword().equals(password))
                return user;
        }
        return null;
    }

    public Tile[][] getMap() {
        return playerMap;
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
