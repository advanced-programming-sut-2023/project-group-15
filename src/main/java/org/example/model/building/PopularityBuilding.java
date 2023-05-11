package org.example.model.building;

import org.example.model.enums.Products;
import org.example.model.enums.UnitName;

public class PopularityBuilding extends Building {
    private int popularityRate;
    private UnitName unitName = null;


    public PopularityBuilding(String name, int hp, int xCoordinate, int yCoordinate, Products material1,
                              Products material2, int numberOfMaterial1, int numberOfMaterial2, int popularityRate) {
        super(name, hp, xCoordinate, yCoordinate, material1, material2, numberOfMaterial1, numberOfMaterial2);
        this.popularityRate = popularityRate;
    }

    public int getPopularityRate() {
        return popularityRate;
    }

    public void addToPopularity() {
        //TODO add to popularity based on the rate

    }
}
