package org.example.model.building;

import java.util.ArrayList;
import java.util.HashMap;

import org.example.model.enums.*;
public class Market extends Building{


   private static HashMap<String , Integer> number = new HashMap<>();
    private static HashMap<String, Integer> sellCoin = new HashMap<>();
    private static HashMap<String, Integer> buyCoin = new HashMap<>();
    public Market(String name, int hp, int xCoordiante, int yCoordiante, Products material1, Products material2, int numberOfMaterial1, int numberOfMaterial2,
                  int numberOfWorkers, ArrayList<Products> userFoods, ArrayList<Source> userSources, ArrayList<Weapon> userWeapons) {
        super(name, hp, xCoordiante, yCoordiante, material1, material2, numberOfMaterial1, numberOfMaterial2);

    }


    public static void setTests() {


        number.put("Apple", 10);
        number.put("Hop", 20);
        number.put("Bread", 0);
        number.put("Bear", 0);
        number.put("Cheese", 0);
        number.put("Flour", 0);
        number.put("Sword", 0);
        number.put("Spear", 0);
        number.put("Archer", 0);
        number.put("Armor", 0);
        number.put("Rock", 0);
        number.put("Iron", 0);
        number.put("Pitch", 0);
        number.put("Wood", 0);
        number.put("Vest", 0);
        number.put("Horse", 0);

        sellCoin.put("Apple", 10);
        sellCoin.put("Hop", 20);
        sellCoin.put("Bread", 30);
        sellCoin.put("Bear", 40);
        sellCoin.put("Cheese", 50);
        sellCoin.put("Flour", 60);
        sellCoin.put("Sword", 70);
        sellCoin.put("Spear", 80);
        sellCoin.put("Archer", 90);
        sellCoin.put("Armor", 110);
        sellCoin.put("Rock", 120);
        sellCoin.put("Iron", 130);
        sellCoin.put("Pitch", 140);
        sellCoin.put("Wood", 150);
        sellCoin.put("Vest", 160);
        sellCoin.put("Horse", 170);

        buyCoin.put("Apple", 11);
        buyCoin.put("Hop", 22);
        buyCoin.put("Bread", 33);
        buyCoin.put("Bear", 44);
        buyCoin.put("Cheese", 55);
        buyCoin.put("Flour", 66);
        buyCoin.put("Sword", 77);
        buyCoin.put("Spear", 88);
        buyCoin.put("Archer", 99);
        buyCoin.put("Armor", 210);
        buyCoin.put("Rock", 230);
        buyCoin.put("Iron", 250);
        buyCoin.put("Pitch", 260);
        buyCoin.put("Wood", 270);
        buyCoin.put("Vest", 280);
        buyCoin.put("Horse", 290);
    }

    public static void sellItemNumber(String item ,int num){
        int newNumber = number.get(item) - num;
        number.replace(item, newNumber);
    }

    public static void buyItemNumber(String Item ,int num){
        int newNumber = number.get(Item) + num;
        number.replace(Item, newNumber);
    }
    public static HashMap<String, Integer> getNumber() {
        return number;
    }

    public static HashMap<String, Integer> getSellCoin() {
        return sellCoin;
    }

    public static HashMap<String, Integer> getBuyCoin() {
        return buyCoin;
    }

    public static int getSellCoin(String item){
        return sellCoin.get(item);
    }

    public static int getBuyCoin(String item){
        return buyCoin.get(item);
    }

    public static int getNumberOfItem(String item){
        return number.get(item);
    }
}
