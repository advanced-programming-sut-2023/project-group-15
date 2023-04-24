package org.example.model.building;

import org.example.model.enums.Products;
import org.example.model.interfaces.Fighting;
public class WarBuilding extends Building implements Fighting {
    private int fireRange;
    private int defendRange;

    public WarBuilding(String name, int hp, int xCoordiante, int yCoordiante, Products material1, Products material2,
                       int numberOfMaterial1, int numberOfMaterial2, int numberOfWorkers, int fireRange, int defendRange) {
        super(name, hp, xCoordiante, yCoordiante, material1, material2, numberOfMaterial1, numberOfMaterial2, numberOfWorkers);
        this.fireRange = fireRange;
        this.defendRange = defendRange;
    }

    public int getFireRange() {
        return fireRange;
    }

    public int getDefendRange() {
        return defendRange;
    }

    public void repear() {
        //should be in the controller not here!
        return;
    }

    public void setDefendRange(int defendRange) {
        this.defendRange = defendRange;
    }
    public void setFireRange(int fireRange) {
        this.fireRange = fireRange;
    }

    @Override
    public void fightingStrategy() {
        //TODO:
        return;
    }
}
