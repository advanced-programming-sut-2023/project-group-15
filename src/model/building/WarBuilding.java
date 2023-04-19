package model.building;

import model.interfaces.fighting;

public class WarBuilding extends Building implements fighting {
    private int fireRange;
    private int defendRange;

    public WarBuilding(int hp, int width, int height, int buildingCost, int fireRange, int defendRange) {
        super(hp, width, height, buildingCost);
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
