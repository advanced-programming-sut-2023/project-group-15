package org.example.model.building;

import org.example.model.enums.products;
import org.example.model.interfaces.produce;
import org.example.model.enums.Source;

public class ProductiveBuilding extends Building implements produce {
    private final int rate;
    private boolean needMaterial;
    private final products product;

    public ProductiveBuilding(int hp, int width, int height, int buildingCost, int rate,boolean needMaterial, products product) {
        super(hp, width, height, buildingCost);
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
