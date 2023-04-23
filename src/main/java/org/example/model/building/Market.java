package org.example.model.building;

import java.util.ArrayList;
import org.example.model.enums.*;
public class Market extends Building{
    private ArrayList<products> userFoods;
    private ArrayList<Source> userSources;
    private ArrayList<Weapon> userWeapons;

    public Market(int hp, int xCoordiante, int yCoordiante, products material1, products material2, int numberOfMaterial1,
                  int numberOfWorkers, ArrayList<products> userFoods, ArrayList<Source> userSources, ArrayList<Weapon> userWeapons) {
        super(hp, xCoordiante, yCoordiante, material1, material2, numberOfMaterial1, numberOfWorkers);
        this.userFoods = userFoods;
        this.userSources = userSources;
        this.userWeapons = userWeapons;
    }

    public ArrayList<products> getUserFoods() {
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
