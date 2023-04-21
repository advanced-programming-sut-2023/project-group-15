package org.example.model.MBC;

import org.example.model.MBC.Soldier;
import org.example.model.enums.LauncherUnitName;

public class LauncherUnit extends Soldier {
    public LauncherUnitName name;
    public int maxMove;
    public int throwrange;
    public int speed;
    public int attackingPower;
    public int deffense;

    private void setSpeed(int speed){
        this.speed = speed;
    }

    private void setAttackingPower(int attackingPower){
        this.attackingPower = attackingPower;
    }

    private void setDeffense(int deffense){
        this.deffense = deffense;
    }

    private int getSpeed(){
        return this.speed;
    }

    private int getAttackingPower(int attackingPower){
        return this.attackingPower;
    }

    private int getDeffense(int deffense){
        return this.deffense;
    }
    public LauncherUnitName getName() {
        return name;
    }

    public void setName(LauncherUnitName name) {
        this.name = name;
    }

    private void archer(){
        this.name = LauncherUnitName.ARCHER;
        this.maxMove = 3;
        this.throwrange = 2;
    }

    private void crossbowmen(){
        this.name = LauncherUnitName.CROSSBOWMEN;
        this.maxMove = 1;
        this.throwrange = 2;
    }

    private void arrcherBow(){
        this.name = LauncherUnitName.ARCHERBOW;
        this.maxMove = 3;
        this.throwrange = 2;
    }

    private void slingers(){
        this.name = LauncherUnitName.SLINGERS;
        this.maxMove = 3;
        this.throwrange = 2;
    }

    private void horseArchers(){
        this.name = LauncherUnitName.HORSE_ARCHERS;
        this.maxMove = 4;
        this.throwrange = 2;
    }

    private void firethrowers(){
        this.name = LauncherUnitName.FIRE_THROWERS;
        this.maxMove = 4;
        this.throwrange = 3;
    }

    private int getThrowrange(){
        return throwrange;
    }

    private int getMaxMove(){
        return maxMove;
    }

}
