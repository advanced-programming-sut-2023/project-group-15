package org.example.model.building;


import org.example.model.enums.Products;

public class Transforation extends Building{
    private final int amount;

    public Transforation(String name, int hp, int xCoordiante, int yCoordiante, Products material1, Products material2,
                         int numberOfMaterial1, int numberOfMaterial2, int numberOfWorkers, int amount) {
        super(name, hp, xCoordiante, yCoordiante, material1, material2, numberOfMaterial1, numberOfMaterial2, numberOfWorkers);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
