package org.example.model.building;

import org.example.model.enums.products;
import org.example.model.interfaces.produce;
import org.example.model.enums.Source;

public class ProductiveBuilding extends Building implements produce {
    private String name ;
    private final int rate;
    private boolean needMaterial;
    private final products product;

    public ProductiveBuilding(int hp, int xCoordiante, int yCoordiante, products material1, products material2, int numberOfMaterial1
            , int numberOfWorkers, String name, int rate, boolean needMaterial, products product) {
        super(hp, xCoordiante, yCoordiante, material1, material2, numberOfMaterial1, numberOfWorkers);
        this.name = name;
        this.rate = rate;
        this.needMaterial = needMaterial;
        this.product = product;
    }

    public products getProduct() {
        return product;
    }

    public int getRate() {
        return rate;
    }
    @Override
    public void production() {
        //TODO:
    }
}
