package org.example.model.building;

import java.util.ArrayList;
import org.example.model.enums.*;
public class Market extends Building{
    private ArrayList<Products> userFoods;
    private ArrayList<Source> userSources;
    private ArrayList<Weapon> userWeapons;

    public Market(int hp, int width, int height, int buildingCost) {
        super(hp, width, height, buildingCost);
        this.userFoods = new ArrayList<>();
        this.userSources = new ArrayList<>();
        this.userWeapons = new ArrayList<>();
    }

    public ArrayList<Products> getUserFoods() {
        return userFoods;
    }

    public ArrayList<Source> getUserSources() {
        return userSources;
    }

    public ArrayList<Weapon> getUserWeapons() {
        return userWeapons;
    }

    public void showUserFoodsAmount() {
        System.out.println(getUserFoods().size());
    }

    public void showUsersourcesAmount() {
        System.out.println(getUserSources().size());
    }

    public void showUserWeaponsAmount() {
        System.out.println(getUserWeapons().size());
    }

    public void buyItem(String item) {
        //TODO:
    }

    public void sellItem(String item) {
        //TODO:
    }

    public void showStoreInventory() {
        //TODO:
        return;
    }
}
