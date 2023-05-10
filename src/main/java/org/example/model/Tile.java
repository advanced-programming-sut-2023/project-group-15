package org.example.model;

import org.example.model.enums.Direction;
import org.example.model.building.BuildingName;
import org.example.model.enums.LandType;
import org.example.model.enums.Tree;
import org.example.model.enums.UnitName;

public class Tile {
    private BuildingName building;
    private LandType landType;
    private int numberOfSoldiers;
    private UnitName soldier;
    private Tree tree;
    private boolean rock;
    private Direction rockDirection;

    public Tile() {
        this.building = null;
        this.landType= LandType.DEFAULT;
        this.numberOfSoldiers = 0 ;
        this.soldier = null ;
        this.tree = null ;
        this.rock = false ;
        this.rockDirection = Direction.NULL;
    }

    public Tile(BuildingName building, LandType landType, int numberOfSoldiers, UnitName soldier, Tree tree, boolean rock,Direction rockDirection) {
        this.building = building;
        this.landType = landType;
        this.numberOfSoldiers = numberOfSoldiers;
        this.soldier = soldier;
        this.tree = tree;
        this.rock = rock;
        this.rockDirection = rockDirection;
    }

    public void setBuilding(BuildingName building) {
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

    public void setTree(Tree tree) {
        this.tree = tree;
    }

    public void setRock(boolean rockStatus,Direction direction) {
        this.rock = rockStatus;
        this.rockDirection = direction;
    }

    public BuildingName getBuilding() {
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

    public Direction getRockDirection() {
        return rockDirection;
    }
}