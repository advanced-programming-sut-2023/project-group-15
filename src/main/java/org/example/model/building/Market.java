package org.example.model.building;

import java.util.ArrayList;
import java.util.HashMap;

import org.example.model.enums.*;
public class Market extends Building{
    private static HashMap < String, Integer > number = new HashMap < > ();
    private static HashMap < String, Integer > sellCoin = new HashMap < > ();
    private static HashMap < String, Integer > buyCoin = new HashMap < > ();
    public Market(String name, int hp, int xCoordiante, int yCoordiante, Products material1, Products material2, int numberOfMaterial1, int numberOfMaterial2,
                  int numberOfWorkers, ArrayList < Products > userFoods, ArrayList < Source > userSources, ArrayList < Weapon > userWeapons) {
        super(name, hp, xCoordiante, yCoordiante, material1, material2, numberOfMaterial1, numberOfMaterial2, numberOfWorkers);

    }

    public static void setMarket() {

        number.put("Apple", 10);
        number.put("Hop", 0);
        number.put("Bread", 0);
        number.put("Bear", 0);
        number.put("Cheese", 3);
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
        sellCoin.put("Hop", 5);
        sellCoin.put("Bread", 15);
        sellCoin.put("Bear", 20);
        sellCoin.put("Cheese", 20);
        sellCoin.put("Flour", 5);
        sellCoin.put("Sword", 30);
        sellCoin.put("Spear", 30);
        sellCoin.put("Archer", 30);
        sellCoin.put("Armor", 30);
        sellCoin.put("Rock", 25);
        sellCoin.put("Iron", 35);
        sellCoin.put("Pitch", 40);
        sellCoin.put("Wood", 15);
        sellCoin.put("Vest", 40);
        sellCoin.put("Horse", 60);

        buyCoin.put("Apple", 15);
        buyCoin.put("Hop", 10);
        buyCoin.put("Bread", 20);
        buyCoin.put("Bear", 25);
        buyCoin.put("Cheese", 25);
        buyCoin.put("Flour", 10);
        buyCoin.put("Sword", 35);
        buyCoin.put("Spear", 35);
        buyCoin.put("Archer", 35);
        buyCoin.put("Armor", 35);
        buyCoin.put("Rock", 25);
        buyCoin.put("Iron", 35);
        buyCoin.put("Pitch", 45);
        buyCoin.put("Wood", 20);
        buyCoin.put("Vest", 45);
        buyCoin.put("Horse", 65);
    }

    public static void sellItemNumber(String item, int num) {
        int newNumber = number.get(item) - num;
        number.replace(item, newNumber);
    }

    public static void buyItemNumber(String Item, int num) {
        int newNumber = number.get(Item) + num;
        number.replace(Item, newNumber);
    }
    public static HashMap < String, Integer > getNumber() {
        return number;
    }

    public static HashMap < String, Integer > getSellCoin() {
        return sellCoin;
    }

    public static HashMap < String, Integer > getBuyCoin() {
        return buyCoin;
    }

    public static int getSellCoin(String item) {
        return sellCoin.get(item);
    }

    public static int getBuyCoin(String item) {
        return buyCoin.get(item);
    }

    public static int getNumberOfItem(String item) {
        return number.get(item);
    }
}
