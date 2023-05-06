package org.example.model;

import org.example.model.MBC.Soldier;
import org.example.model.building.Building;
import org.example.model.enums.LandType;
import org.example.model.enums.Tree;
import org.example.model.enums.UnitName;

public class Tile {
    private Building building;
    private LandType landType;
    private int numberOfSoldiers =  0;
    private UnitName soldier = null;

    private Tree tree = null ;
    private boolean rock = false ;
    private String rockDirection;

    public Tile() {
        this.building = null;
        this.landType= LandType.DEFAULT;
        this.numberOfSoldiers = 0 ;
        this.soldier = null ;
        this.tree = null ;
        this.rock = false ;
    }

    public Tile(Building building, LandType landType, int numberOfSoldiers, UnitName soldier, Tree tree, boolean rock, String rockDirection) {
        this.building = building;
        this.landType = landType;
        this.numberOfSoldiers = numberOfSoldiers;
        this.soldier = soldier;
        this.tree = tree;
        this.rock = rock;
        this.rockDirection = rockDirection;
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

    public void setSoldier(UnitName soldier) {
        this.soldier = soldier;
    }

    public void setTreeName(Tree treeName) {
        this.tree = treeName;
    }

    public void setRock(boolean rockStatus,String direction) {
        this.rock = rockStatus;
        this.rockDirection = direction;
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

    public UnitName getSoldier() {
        return soldier;
    }

    public Tree getTree() {
        return tree;
    }

    public boolean isRock() {
        return rock;
    }

    public String getRockDirection() {
        return rockDirection;
    }
}