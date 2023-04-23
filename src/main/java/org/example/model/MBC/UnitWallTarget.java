package org.example.model.MBC;

import org.example.model.MBC.Soldier;
import org.example.model.enums.UnitName;

public class UnitWallTarget extends Soldier {
    public UnitName name;
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
    public void setName(UnitName name) {
        this.name = name;
    }

    public UnitName getName() {
        return name;
    }

    private void spearmen(){
        this.name = UnitName.SPEARMEN;
        this.maxMove = 2;
    }

    private void macemen(){
        this.name = UnitName.MACEMEN;
        this.maxMove = 2;
    }

    private void tunneler(){
        this.name = UnitName.TUNNELER;
        this.maxMove = 3;
    }

    private void laddermen(){
        this.name = UnitName.LADDERMEN;
        this.maxMove = 3;
    }

    private void assassins(){
        this.name = UnitName.ASSASSINS;
        this.maxMove = 2;
    }
}
