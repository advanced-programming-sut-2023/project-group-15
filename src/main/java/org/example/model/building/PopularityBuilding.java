package org.example.model.building;

import org.example.model.enums.Products;

public class PopularityBuilding extends Building {
    private final int popularityRate;

    public PopularityBuilding(String name, int hp, int xCoordinate, int yCoordinate, Products material1,
                              Products material2, int numberOfMaterial1, int numberOfMaterial2, int popularityRate) {
        super(name, hp, xCoordinate, yCoordinate, material1, material2, numberOfMaterial1, numberOfMaterial2);
        this.popularityRate = popularityRate;
    }

    public int getPopularityRate() {
        return popularityRate;
    }

}
