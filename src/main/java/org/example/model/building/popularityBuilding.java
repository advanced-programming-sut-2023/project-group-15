package org.example.model.building;

import org.example.model.enums.Products;

public class popularityBuilding extends Building {
    int popularityRate;

    public popularityBuilding(String name, int hp, int xCoordinate, int yCoordinate, Products material1,
                              Products material2, int numberOfMaterial1, int numberOfMaterial2, int numberOfWorkers, int popularityRate) {
        super(name, hp, xCoordinate, yCoordinate, material1, material2, numberOfMaterial1, numberOfMaterial2);
        this.popularityRate = popularityRate;
    }

    public int getPopularityRate() {
        return popularityRate;
    }

    public void setPopularityRate(int popularityRate) {
        this.popularityRate = popularityRate;
    }
}
