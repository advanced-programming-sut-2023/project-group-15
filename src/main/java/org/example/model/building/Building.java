package org.example.model.building;


import org.example.model.MBC.Person;
import org.example.model.tile;
import org.example.model.enums.*;

public class Building {
    private final int hp;
    private int xCoordiante;
    private int yCoordiante;
    private products material1 ;
    private products material2 ;
    private int numberOfMaterial1;
    private int numberOfWorkers;

    public Building(int hp, int xCoordiante, int yCoordiante, products material1, products material2, int numberOfMaterial1, int numberOfWorkers) {
        this.hp = hp;
        this.xCoordiante = xCoordiante;
        this.yCoordiante = yCoordiante;
        this.material1 = material1;
        this.material2 = material2;
        this.numberOfMaterial1 = numberOfMaterial1;
        this.numberOfWorkers = numberOfWorkers;
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

    public products getMaterial1() {
        return material1;
    }

    public products getMaterial2() {
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

    public void setMaterial1(products material1) {
        this.material1 = material1;
    }

    public void setMaterial2(products material2) {
        this.material2 = material2;
    }
}
