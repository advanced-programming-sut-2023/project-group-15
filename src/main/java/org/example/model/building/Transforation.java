package org.example.model.building;


import org.example.model.enums.products;

public class Transforation extends Building{
    private final int amount;

    public Transforation(int hp, int xCoordiante, int yCoordiante, products material1, products material2, int numberOfMaterial1, int numberOfWorkers, int amount) {
        super(hp, xCoordiante, yCoordiante, material1, material2, numberOfMaterial1, numberOfWorkers);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
