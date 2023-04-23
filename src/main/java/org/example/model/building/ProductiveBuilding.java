package org.example.model.building;

import org.example.model.enums.products;
import org.example.model.interfaces.produce;
import org.example.model.enums.Source;

public class ProductiveBuilding extends Building implements produce {
    private String name ;
    private final int rate;
    private boolean needMaterial;
    private final products product1;
    private final products product2;

    public ProductiveBuilding(int hp, int xCoordiante, int yCoordiante, products material1, products material2,
                              int numberOfMaterial1, int numberOfMaterial2, int numberOfWorkers, String name,
                              int rate, products product1, products product2) {
        super(hp, xCoordiante, yCoordiante, material1, material2, numberOfMaterial1, numberOfMaterial2, numberOfWorkers);
        this.name = name;
        this.rate = rate;
        this.product1 = product1;
        this.product2 = product2;
    }

    public String getName() {
        return name;
    }

    public products getProduct1() {
        return product1;
    }

    public products getProduct2() {
        return product2;
    }

    public int getRate() {
        return rate;
    }
    @Override
    public void production() {
        //TODO:
    }
}
