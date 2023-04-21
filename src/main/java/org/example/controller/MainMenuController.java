package org.example.controller;

public class MainMenuController {
    private String username;
    private String password;
    private String nickname;
    private String slogan;
    private String email;

    public MainMenuController() {
        this.username = null;
        this.password = null;
        this.nickname = null;
        this.slogan = null;
        this.email = null;
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
