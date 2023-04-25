package org.example.model;

import org.example.model.MBC.Soldier;
import org.example.model.building.Building;
import org.example.model.enums.LandType;

public class Tile {
    private Building building;
    private LandType landType;
    private int numberOfSoldiers =  0;
    private Soldier soldier = null;
    private String treeName = null ;
    private boolean rock = false ;

    public Tile() {
        this.building = null;
        this.landType= LandType.DEFAULT;
        this.numberOfSoldiers = 0 ;
        this.soldier = null ;
        this.treeName = null ;
        this.rock = false ;
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