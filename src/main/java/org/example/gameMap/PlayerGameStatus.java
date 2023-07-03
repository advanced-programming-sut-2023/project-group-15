package org.example.gameMap;

import org.example.controller.GameMenuController;
import org.example.model.gameData.GameInformation;
import org.example.model.gameData.Government;

public class PlayerGameStatus {
    private final GamePanel gamePanel;
    private int level;
    private double coin;
    private int taxRate;
    private int foodRate;
    private int fearRate;
    private int religion;
    private int popularity;

    public PlayerGameStatus(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        Government government = GameMenuController.getGovernment();
        if (government == null) {
            government = new Government("mahd");
        }
        this.level = 1;
        this.coin = government.getCoins();
        this.taxRate = government.getTaxRate();
        this.foodRate = government.getFoodRate();
        this.fearRate = government.getFearRate();
        this.religion = government.getReligion();
        this.popularity = government.getPopularity();
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public int getLevel() {
        return level;
    }

    public double getCoin() {
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

    public void setCoin(double coin) {
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
