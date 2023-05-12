package org.example.model.building;

import org.example.model.enums.Products;

public class WarBuilding extends Building {
    private int fireRange;
    private int defendRange;

    public WarBuilding(String name, int hp, int xCoordinate, int yCoordinate, Products material1, Products material2,
                       int numberOfMaterial1, int numberOfMaterial2, int fireRange, int defendRange) {
        super(name, hp, xCoordinate, yCoordinate, material1, material2, numberOfMaterial1, numberOfMaterial2);
        this.fireRange = fireRange;
        this.defendRange = defendRange;
    }

    public int getFireRange() {
        return fireRange;
    }

    public int getDefendRange() {
        return defendRange;
    }

    public void setDefendRange(int defendRange) {
        this.defendRange = defendRange;
    }

    public void setFireRange(int fireRange) {
        this.fireRange = fireRange;
    }

}
