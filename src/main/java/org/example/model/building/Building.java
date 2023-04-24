package org.example.model.building;


import org.example.model.enums.*;

public class Building {
    private final int hp;
    private int width;
    private int height;
    private final int buildingCost;
    private Person worker;

    public Building(int hp, int width, int height, int buildingCost) {
        this.hp = hp;
        this.width = width;
        this.height = height;
        this.buildingCost = buildingCost;
    }

    public int getHp() {
        return hp;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getBuildingCost() {
        return buildingCost;
    }

    public Person getWorker() {
        return worker;
    }

    public void setPosition(int width,int height) {
        this.height = height;
        this.width = width;
    }
}
