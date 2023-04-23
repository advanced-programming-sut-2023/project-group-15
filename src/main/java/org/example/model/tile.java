package org.example.model;

import org.example.model.*;
import org.example.model.MBC.Soldier;
import org.example.model.building.Building;
import org.example.model.enums.LandType;

public class tile {
    private Building building = null;
    private LandType landType = null;
    private int numberOfSoldiers =  0;
    private Soldier soldier = null;
    private String treeName = null ;
    private boolean rock = false ;

    {
        soldier = null;
    }

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

    public void setTreeName(String treeName) {
        this.treeName = treeName;
    }

    public void setRock() {
        this.rock = true;
    }

    public Building getBuilding() {
        return building;
    }


    public LandType getLandType() {
        return landType;
    }

    public int getNumberOfSoldiers() {
        return numberOfSoldiers;
    }

    public Soldier getSoldier() {
        return soldier;
    }
}
