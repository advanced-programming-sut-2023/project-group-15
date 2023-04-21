package org.example.model;

import java.util.ArrayList;

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
    public static final ArrayList<User> allUsers = new ArrayList<>();

    private void User(String username,String password,String nickname,String email){
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
    }

    private void User(String username,String password,String nickname,String email,String slogan){
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

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    public String getNickname(){
        return this.nickname;
    }

    public String getEmail(){
        return this.email;
    }

    public String getSlogan(){
        return this.slogan;
    }

    public int getRank(){
        return this.rank;
    }

    public int getScore(){
        return this.score;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setNickname(String nickname){
        this.nickname = nickname;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setSlogan(String slogan){
        this.slogan = slogan;
    }

    public void setPassRecoveryQuestion(String passRecoveryQuestion){
        this.passRecoveryQuestion = passRecoveryQuestion;
    }

    public void setPassRecoveryAnswer(String passRecoveryAnswer){
        this.passRecoveryAnswer = passRecoveryAnswer;
    }

    public String getPassRecoveryQuestion(){
        return this.passRecoveryQuestion;
    }

    public String getPassRecoveryAnswer(){
        return this.passRecoveryAnswer;
    }

    public static User findUserWithPass(String password) {
        for (User user:User.allUsers) {
            if (user.getPassword().equals(password))
                return user;
        }
        return null;
    }
}