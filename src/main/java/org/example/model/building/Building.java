package org.example.model.building;


import org.example.model.enums.*;

public class Building {
    private String name ;
    private final int hp;
    private int xCoordiante;
    private int yCoordiante;
    private Products material1 ;
    private Products material2 ;
    private int numberOfMaterial1;
    private int numberOfMaterial2;
    private int numberOfWorkers;

    public Building(String name, int hp, int xCoordiante, int yCoordiante,
                    Products material1, Products material2, int numberOfMaterial1,
                    int numberOfMaterial2, int numberOfWorkers) {
        this.name = name;
        this.hp = hp;
        this.xCoordiante = xCoordiante;
        this.yCoordiante = yCoordiante;
        this.material1 = material1;
        this.material2 = material2;
        this.numberOfMaterial1 = numberOfMaterial1;
        this.numberOfMaterial2 = numberOfMaterial2;
        this.numberOfWorkers = numberOfWorkers;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getxCoordiante() {
        return xCoordiante;
    }

    public int getyCoordiante() {
        return yCoordiante;
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

    public int getNumberOfWorker() {
        return numberOfWorkers;
    }

    public void setPosition(int x, int y) {
        this.xCoordiante = x;
        this.yCoordiante = y;
    }

    public void setxCoordiante(int xCoordiante) {
        this.xCoordiante = xCoordiante;
    }

    public void setyCoordiante(int yCoordiante) {
        this.yCoordiante = yCoordiante;
    }

    public void setMaterial1(Products material1) {
        this.material1 = material1;
    }

    public void setMaterial2(Products material2) {
        this.material2 = material2;
    }
}
