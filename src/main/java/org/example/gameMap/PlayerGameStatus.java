package org.example.gameMap;

import java.awt.*;

public class PlayerGameStatus {
    private final GamePanel gamePanel;
    private int level;
    private int coin;
    private int taxRate;
    private int foodRate;
    private int fearRate;
    private int religion;
    private int popularity;

    public PlayerGameStatus(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        //TODO: here the fields fill with user government
        this.level = 1;
        this.coin = 15000;
        this.taxRate = 5;
        this.foodRate = 4;
        this.fearRate = 6;
        this.religion = 0;
        this.popularity = 5;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public int getLevel() {
        return level;
    }

    public int getCoin() {
        return coin;
    }

    public int getTaxRate() {
        return taxRate;
    }

    public int getFoodRate() {
        return foodRate;
    }

    public int getFearRate() {
        return fearRate;
    }

    public int getReligion() {
        return religion;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public void setTaxRate(int taxRate) {
        this.taxRate = taxRate;
    }

    public void setFoodRate(int foodRate) {
        this.foodRate = foodRate;
    }

    public void setFearRate(int fearRate) {
        this.fearRate = fearRate;
    }

    public void setReligion(int religion) {
        this.religion = religion;
    }
}
