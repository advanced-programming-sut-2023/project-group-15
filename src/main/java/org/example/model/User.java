package org.example.model;

public class User {
    public String username;
    public String password;
    public String nickname;
    public String email;
    private String passRecoveryQuestion;
    public String passRecoveryAnswer;
    public int score;
    public int rank;
    public String slogan;

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
    }

    private String getUsername(){
        return this.username;
    }

    private String getPassword(){
        return this.password;
    }

    private String getNickname(){
        return this.nickname;
    }

    private String getEmail(){
        return this.email;
    }

    private String getSlogan(){
        return this.slogan;
    }

    private int getRank(){
        return this.rank;
    }

    private int getScore(){
        return this.score;
    }

    private void setPassword(String password){
        this.password = password;
    }

    private void setUsername(String username){
        this.username = username;
    }

    private void setNickname(String nickname){
        this.nickname = nickname;
    }

    private void setEmail(String email){
        this.email = email;
    }

    private void setSlogan(String slogan){
        this.slogan = slogan;
    }

    private void setPassRecoveryQuestion(String passRecoveryQuestion){
        this.passRecoveryQuestion = passRecoveryQuestion;
    }

    private void setPassRecoveryAnswer(String passRecoveryAnswer){
        this.passRecoveryAnswer = passRecoveryAnswer;
    }

    private String getPassRecoveryQuestion(){
        return this.passRecoveryQuestion;
    }

    private String getPassRecoveryAnswer(){
        return this.passRecoveryAnswer;
    }
}
