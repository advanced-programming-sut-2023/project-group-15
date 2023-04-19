package model.building;

import model.enums.Source;
import model.interfaces.produce;

public class ProductiveBuilding extends Building implements produce {
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
