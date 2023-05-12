package org.example.model;

import org.example.model.enums.Direction;
import org.example.model.enums.LandType;
import org.example.model.enums.Tree;
import org.example.model.building.Building;
import org.example.model.MBC.Soldier;
public class Tile {
    private Building building;
    private LandType landType;
    private int numberOfSoldiers;
    private Soldier soldier;
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

    public void setBuilding(Building building) {
        this.building = building;
    }

    public void setLandType(LandType landType) {
        this.landType = landType;
    }

    public void addNumberOfSoldiers(int numberOfSoldiers) {
        this.numberOfSoldiers += numberOfSoldiers;
    }

    public void setSoldier(Soldier soldier) {
        this.soldier = soldier;
    }

    public void setTree(Tree tree) {
        this.tree = tree;
    }

    public void setRock(boolean rockStatus,Direction direction) {
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

    public Soldier getSoldier() {
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