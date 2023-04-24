package org.example.model.building;

import org.example.model.enums.Products;
import org.example.model.interfaces.produce;

public class ProductiveBuilding extends Building implements produce {
    private final int rate;
    private boolean needMaterial;
    private final Products product;

    public ProductiveBuilding(int hp, int width, int height, int buildingCost, int rate,boolean needMaterial, Products product) {
        super(hp, width, height, buildingCost);
        this.rate = rate;
        this.needMaterial = needMaterial;
        this.product = product;
    }

    public Products getProduct() {
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
