package org.example.model.building;

import org.example.model.enums.Products;
//import org.example.model.interfaces.Produce;

public class ProductiveBuilding extends Building {
    private final int rate;
    private boolean needMaterial;
    private final Products product1;
    private final Products product2;
    private final int numberOfWorkers;

    public ProductiveBuilding(String name, int hp, int xCoordiante, int yCoordiante, Products material1, Products material2, int numberOfMaterial1,
                              int numberOfMaterial2, int numberOfWorkers, int rate
                              , Products product1, Products product2) {
        super(name, hp, xCoordiante, yCoordiante, material1, material2, numberOfMaterial1, numberOfMaterial2);
        this.rate = rate;
        this.product1 = product1;
        this.product2 = product2;
        this.numberOfWorkers = numberOfWorkers;
    }


    public Products getProduct1() {
        return product1;
    }

    public Products getProduct2() {
        return product2;
    }

    public int getRate() {
        return rate;
    }
   /* @Override
    public void production() {
        //TODO:
    }*/
}


