package org.example.model.building;

import java.util.ArrayList;
import java.util.HashMap;

import org.example.model.enums.*;
public class Market extends Building{


   public static HashMap<String , Integer> test = new HashMap<>();
    public static HashMap<String, Integer> test1 = new HashMap<>();
    public static HashMap<String, Integer> test2 = new HashMap<>();
    public Market(String name, int hp, int xCoordiante, int yCoordiante, Products material1, Products material2, int numberOfMaterial1, int numberOfMaterial2,
                  int numberOfWorkers, ArrayList<Products> userFoods, ArrayList<Source> userSources, ArrayList<Weapon> userWeapons) {
        super(name, hp, xCoordiante, yCoordiante, material1, material2, numberOfMaterial1, numberOfMaterial2, numberOfWorkers);

    }

    public static HashMap<String, Integer> getUserFoods() {
        return test;
    }

    public static HashMap<String, Integer> getUserSources() {
        return test1;
    }

    public static HashMap<String, Integer> getUserWeapons() {
        return test2;
    }

  /*  public void showUserFoodsAmount() {
        System.out.println(getUserFoods().size());
    }

    public void showUsersourcesAmount() {
        System.out.println(getUserSources().size());
    }

    public void showUserWeaponsAmount() {
        System.out.println(getUserWeapons().size());
    }*/

  /*  public void buyItem(String item ) {
        //TODO:
    }

    public void sellItem(String item) {
        //TODO:
    }

    public void showStoreInventory() {
        //TODO:
        return;
    }*/

    public static void setTests() {

        System.out.println("l");
        test.put("Apple", 10);
        test.put("Hop", 20);
        test.put("Bread", 0);
        test.put("Bear", 0);
        test.put("Cheese", 0);
        test.put("Flour", 0);
        test.put("Sword", 0);
        test.put("Spear", 0);
        test.put("Archer", 0);
        test.put("Armor", 0);
        test.put("Rock", 0);
        test.put("Iron", 0);
        test.put("Pitch", 0);
        test.put("Wood", 0);
        test.put("Vest", 0);
        test.put("Horse", 0);

        test1.put("Apple", 10);
        test1.put("Hop", 20);
        test1.put("Bread", 30);
        test1.put("Bear", 40);
        test1.put("Cheese", 50);
        test1.put("Flour", 60);
        test1.put("Sword", 70);
        test1.put("Spear", 80);
        test1.put("Archer", 90);
        test1.put("Armor", 110);
        test1.put("Rock", 120);
        test1.put("Iron", 130);
        test1.put("Pitch", 140);
        test1.put("Wood", 150);
        test1.put("Vest", 160);
        test1.put("Horse", 170);

        test2.put("Apple", 11);
        test2.put("Hop", 22);
        test2.put("Bread", 33);
        test2.put("Bear", 44);
        test2.put("Cheese", 55);
        test2.put("Flour", 66);
        test2.put("Sword", 77);
        test2.put("Spear", 88);
        test2.put("Archer", 99);
        test2.put("Armor", 210);
        test2.put("Rock", 230);
        test2.put("Iron", 250);
        test2.put("Pitch", 260);
        test2.put("Wood", 270);
        test2.put("Vest", 280);
        test2.put("Horse", 290);
    }

    public static void sellItemNumber(String item ,int number){
        int newNumber = test.get(item) - number;
        test.replace(item, newNumber);
    }

    public static void buyItemNumber(String Item ,int number){
        int newNumber = test.get(Item) + number;
        test.replace(Item, newNumber);
    }
    public static HashMap<String, Integer> getTest() {
        return test;
    }

    public static HashMap<String, Integer> getTest1() {
        return test1;
    }

    public static HashMap<String, Integer> getTest2() {
        return test2;
    }

    public static int getSellCoin(String item){
        return test1.get(item);
    }

    public static int getBuyCoin(String item){
        return test2.get(item);
    }

    public static int getNumberOfItem(String item){
        return test.get(item);
    }
}
