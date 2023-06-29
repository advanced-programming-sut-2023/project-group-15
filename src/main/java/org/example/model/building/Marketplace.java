package org.example.model.building;

import java.util.HashMap;

import org.example.model.enums.*;

public class Marketplace extends Building {
    private static HashMap<String, Integer> number = new HashMap<>();
    private static final HashMap<String, Integer> sellCoin = new HashMap<>();
    private static final HashMap<String, Integer> buyCoin = new HashMap<>();
    private int numberOfWorkers;
    private static String name ;

    public Marketplace(String name, int hp, int xCoordinate, int yCoordinate,
                       Products material1, Products material2, int numberOfMaterial1,
                       int numberOfMaterial2, int numberOfWorkers) {
        super(name, hp, xCoordinate, yCoordinate, material1, material2, numberOfMaterial1, numberOfMaterial2);
        this.numberOfWorkers = numberOfWorkers;
        this.setMarket();
    }

    public static void setName(String name1){
        name = name1;
    }
    public static String getName1(){
        return name;
    }
    public void setMarket() {
        number.put("apple", 10);
        number.put("hop", 0);
        number.put("bread", 0);
        number.put("meat", 0);
        number.put("cheese", 3);
        number.put("wheat", 0);
        number.put("sword", 0);
        number.put("spear", 0);
        number.put("archer", 0);
        number.put("lather", 0);
        number.put("rock", 0);
        number.put("iron", 0);
        number.put("pitch", 0);
        number.put("wood", 0);
        number.put("vest", 0);
        number.put("mace", 0);
        sellCoin.put("apple", 10);
        sellCoin.put("hop", 5);
        sellCoin.put("bread", 15);
        sellCoin.put("meat", 20);
        sellCoin.put("cheese", 20);
        sellCoin.put("wheat", 5);
        sellCoin.put("sword", 30);
        sellCoin.put("spear", 30);
        sellCoin.put("archer", 30);
        sellCoin.put("lather", 30);
        sellCoin.put("rock", 25);
        sellCoin.put("iron", 35);
        sellCoin.put("pitch", 40);
        sellCoin.put("wood", 15);
        sellCoin.put("vest", 40);
        sellCoin.put("mace", 60);
        buyCoin.put("apple", 15);
        buyCoin.put("hop", 10);
        buyCoin.put("bread", 20);
        buyCoin.put("meat", 25);
        buyCoin.put("cheese", 25);
        buyCoin.put("wheat", 10);
        buyCoin.put("sword", 35);
        buyCoin.put("spear", 35);
        buyCoin.put("archer", 35);
        buyCoin.put("lather", 35);
        buyCoin.put("rock", 25);
        buyCoin.put("iron", 35);
        buyCoin.put("pitch", 45);
        buyCoin.put("wood", 20);
        buyCoin.put("vest", 45);
        buyCoin.put("mace", 65);
    }

    public void sellItemNumber(String item, int num) {
        int newNumber = number.get(item) - num;
        number.replace(item, newNumber);
    }

    public void buyItemNumber(String Item, int num) {
        int newNumber = number.get(Item) + num;
        number.replace(Item, newNumber);
    }

    public HashMap<String, Integer> getNumber() {
        return number;
    }

    public HashMap<String, Integer> getSellCoin() {
        return sellCoin;
    }

    public HashMap<String, Integer> getBuyCoin() {
        return buyCoin;
    }

    public int getSellCoin(String item) {
        return sellCoin.get(item);
    }

    public int getBuyCoin(String item) {
        return buyCoin.get(item);
    }

    public int getNumberOfItem(String item) {
        return number.get(item);
    }

    public int getNumberOfWorkers() {
        return numberOfWorkers;
    }

    public void setNumberOfWorkers(int numberOfWorkers) {
        this.numberOfWorkers = numberOfWorkers;
    }
}
