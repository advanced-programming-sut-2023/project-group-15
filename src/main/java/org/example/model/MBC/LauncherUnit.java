package org.example.model.MBC;

import org.example.model.MBC.Soldier;
import org.example.model.enums.UnitName;

public class LauncherUnit extends Soldier {
    public UnitName name;
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
    public UnitName getName() {
        return name;
    }

    public void setName(UnitName name) {
        this.name = name;
    }

    private void archer(){
        this.name = UnitName.ARCHER;
        this.maxMove = 3;
        this.throwrange = 2;
    }

    private void crossbowmen(){
        this.name = UnitName.CROSSBOWMEN;
        this.maxMove = 1;
        this.throwrange = 2;
    }

    private void arrcherBow(){
        this.name = UnitName.ARCHERBOW;
        this.maxMove = 3;
        this.throwrange = 2;
    }

    private void slingers(){
        this.name = UnitName.SLINGERS;
        this.maxMove = 3;
        this.throwrange = 2;
    }

    private void horseArchers(){
        this.name = UnitName.HORSE_ARCHERS;
        this.maxMove = 4;
        this.throwrange = 2;
    }

    private void firethrowers(){
        this.name = UnitName.FIRE_THROWERS;
        this.maxMove = 4;
        this.throwrange = 3;
    }

    public int getMove(UnitName name){
        switch (name){
            case ARCHER : this.maxMove = 3;
            break;
            case ARCHERBOW: this.maxMove = 3;
            break;
            case CROSSBOWMEN: this.maxMove = 1;
            break;
            case SLINGERS: this.maxMove = 3;
            break;
            case HORSE_ARCHERS: this.maxMove = 4;
            break;
            case FIRE_THROWERS: this.maxMove = 4;
            break;
        }
        return this.maxMove;
    }

    private int getThrowrange(){
        return throwrange;
    }

    private int getMaxMove(){
        return maxMove;
    }

}
