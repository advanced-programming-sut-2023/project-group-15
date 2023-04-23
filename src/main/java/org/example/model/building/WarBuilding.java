package org.example.model.building;

import org.example.model.enums.products;
import org.example.model.interfaces.fighting;
public class WarBuilding extends Building implements fighting {
    private int fireRange;
    private int defendRange;

    public WarBuilding(int hp, int xCoordiante, int yCoordiante, products material1,
                       products material2, int numberOfMaterial1, int numberOfWorkers, int fireRange, int defendRange) {
        super(hp, xCoordiante, yCoordiante, material1, material2, numberOfMaterial1, numberOfWorkers);
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
