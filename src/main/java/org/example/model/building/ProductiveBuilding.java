package org.example.model.building;

import org.example.model.interfaces.Produce;
import org.example.model.enums.Source;

public class ProductiveBuilding extends Building implements Produce {
    private final int rate;
    private boolean needMaterial;
    private final Source product;

    public ProductiveBuilding(int hp, int width, int height, int buildingCost, int rate,boolean needMaterial, Source product) {
        super(hp, width, height, buildingCost);
        this.rate = rate;
        this.needMaterial = needMaterial;
        this.product = product;
    }

    public Source getProduct() {
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
