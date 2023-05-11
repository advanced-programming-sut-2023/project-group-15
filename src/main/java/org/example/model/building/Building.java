package org.example.model.building;


import org.example.model.enums.*;

public class Building {
//    private final BuildingName buildingName;
    private final String name ;
    private int hp;
    private int xCoordinate;
    private int yCoordinate;
    private Products material1 ;
    private Products material2 ;
    private int numberOfMaterial1;
    private int numberOfMaterial2;

    public Building(String name, int hp, int xCoordinate, int yCoordinate,
                    Products material1, Products material2, int numberOfMaterial1,
                    int numberOfMaterial2) {
        this.name = name;
        this.hp = hp;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.material1 = material1;
        this.material2 = material2;
        this.numberOfMaterial1 = numberOfMaterial1;
        this.numberOfMaterial2 = numberOfMaterial2;

    }

    public String getName() {
        return name;
    }

    public void setHp(int hp){
        this.hp = hp;
    }
    public int getHp() {
        return hp;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public Products getMaterial1() {
        return material1;
    }

    public Products getMaterial2() {
        return material2;
    }

    public int getNumberOfMaterial1() {
        return numberOfMaterial1;
    }
    /*public Building getBuildingByName(String name)
    {


    }*/


    public void setPosition(int x, int y) {
        this.xCoordinate = x;
        this.yCoordinate = y;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public void setMaterial1(Products material1) {
        this.material1 = material1;
    }

    public void setMaterial2(Products material2) {
        this.material2 = material2;
    }


}
