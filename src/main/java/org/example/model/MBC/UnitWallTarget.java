package org.example.model.MBC;

import org.example.model.MBC.Soldier;
import org.example.model.enums.UnitWallTargetName;

public class UnitWallTarget extends Soldier {
    public UnitWallTargetName name;
    public int maxMove;
    public int speed;
    public int attackingPower;
    public int deffense;

    private void setSpeed(int speed){
        this.speed = speed;
    }

    private void setattackingPower(int attackingPower){
        this.attackingPower = attackingPower;
    }

    private void setDeffense(int deffense){
        this.deffense = deffense;
    }

    private int getSpeed(){
        return this.speed;
    }

    private int getAttackingPower(){
        return this.attackingPower;
    }

    private int getDeffense(){
        return this.deffense;
    }
    public void setName(UnitWallTargetName name) {
        this.name = name;
    }

    public UnitWallTargetName getName() {
        return name;
    }

    private void spearmen(){
        this.name = UnitWallTargetName.SPEARMEN;
        this.maxMove = 2;
    }

    private void macemen(){
        this.name = UnitWallTargetName.MACEMEN;
        this.maxMove = 2;
    }

    private void tunneler(){
        this.name = UnitWallTargetName.TUNNELER;
        this.maxMove = 3;
    }

    private void laddermen(){
        this.name = UnitWallTargetName.LADDERMEN;
        this.maxMove = 3;
    }

    private void assassins(){
        this.name = UnitWallTargetName.ASSASSINS;
        this.maxMove = 2;
    }
}
