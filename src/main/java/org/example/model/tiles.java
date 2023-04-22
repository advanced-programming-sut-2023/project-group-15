package org.example.model;

import org.example.model.MBC.Person;
import org.example.model.MBC.Soldier;
import org.example.model.building.Building;

public class tiles {
    private Building building = null;
    private LandType landType;
    private int numberOfSoldiers;
    private Soldier soldier = null;

    public void setBuilding(Building building) {
        this.building = building;
    }

    public void setLandType(LandType landType) {
        this.landType = landType;
    }

    public void addToNumberOfSoldiers(int numberOfSoldiers) {
        this.numberOfSoldiers += numberOfSoldiers;
    }

    public void setSoldier(Soldier soldier) {
        this.soldier = soldier;
    }
}
