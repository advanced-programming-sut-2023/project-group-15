package org.example.model.gameData;

import java.util.HashMap;

public class Government {
    private int popularity;
    private int foodRate;
    private int taxRate;
    private int fearRate;
    private double coins;
    private final HashMap<String, Double> foods = new HashMap<>();
    public void foodList() {
        foods.put("Apple", 0.00);
        foods.put("Hop", 0.00);
        foods.put("Bread", 0.00);
        foods.put("Cheese", 0.00);
    }
    public void setCoins(double coin) {
        this.coins = coin;
    }

    public void deCoin(double coin) {
        this.coins -= coin;
    }

    public void InCoin(double coin) {
        this.coins += coin;
    }

    public double getCoins() {
        return this.coins;
    }
    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public void setTaxRate(int taxRate) {
        this.taxRate = taxRate;
        switch (this.taxRate) {
            case -3:
                this.popularity += 7;
                break;
            case -2:
                this.popularity += 5;
                break;
            case -1:
                this.popularity += 3;
                break;
            case 0:
                this.popularity += 1;
                break;
            case 1:
                this.popularity -= 2;
                break;
            case 2:
                this.popularity -= 4;
                break;
            case 3:
                this.popularity -= 6;
                break;
            case 4:
                this.popularity -= 8;
                break;
            case 5:
                this.popularity -= 12;
                break;
            case 6:
                this.popularity -= 16;
                break;
            case 7:
                this.popularity -= 20;
                break;
            case 8:
                this.popularity -= 24;
                break;
        }
    }

    public void setFearRate(int fearRate) {
        this.fearRate = fearRate;
    }

    public void addFood(String food, double amount) {
        double number = this.foods.get(food) + amount;
        this.foods.replace(food, number);
    }
    public void removeFood(String food, double amount) {
        double number = this.foods.get(food) - amount;
        this.foods.replace(food, number);
    }
    public int getTaxRate() {
        return this.taxRate;
    }

    public int getFoodRate() {
        return this.foodRate;
    }

    public int getPopularity() {
        return this.popularity;
    }

    public int getFearRate() {
        return this.fearRate;
    }

    public void setFoodRate(int rate) {
        this.foodRate = rate;
    }

    public HashMap<String, Double> getFoods() {
        return foods;
    }

    public void changeFoodGivingPeople(double number) {
        foods.replaceAll((k, v) -> v -= number);
    }

    public int checkFoodVariety() {
        int varity = 0;
        double zero = 0.00;
        if (Double.compare(foods.get("Apple"), zero) != 0)
            ++varity;
        if (Double.compare(foods.get("Hop"), zero) != 0)
            ++varity;
        if (Double.compare(foods.get("Bread"), zero) != 0)
            ++varity;
        if (Double.compare(foods.get("Cheese"), zero) != 0)
            ++varity;
        switch (varity) {
            case 4:
                return 3;
            case 3:
                return 2;
            case 2:
                return 1;
            default:
                return 0;
        }
    }

}
