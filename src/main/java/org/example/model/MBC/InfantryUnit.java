package org.example.model.MBC;

import org.example.model.MBC.Soldier;
import org.example.model.enums.UnitName;

public class InfantryUnit extends Soldier {
    public UnitName name;
    public int maxMove;
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

    private int getAttackingPower(){
        return this.attackingPower;
    }

    private int getDeffense(){
        return this.deffense;
    }
    public void setName(UnitName name){
        this.name = name;
    }

    public UnitName getName(){
        return this.name;
    }

    private void pikemen(){
        this.name = UnitName.PIKEMEN;
    }

    private void swordsmen(){
        this.name = UnitName.SWORDSMEN;
    }

    private void knigth(){
        this.name = UnitName.KNIGHT;
    }

    private void engineer(){
        this.name = UnitName.ENGINEER;
    }

    private void blackMonk(){
        this.name = UnitName.BLACK_MONK;
    }

    private void slaves(){
        this.name = UnitName.SLAVES;
    }

    private void arabianSwordsmen(){
        this.name = UnitName.ARABIAN_SWORDSMEN;
    }

    public void setMaxMove(UnitName name){
        switch (name){
            case PIKEMEN: this.maxMove = 1;
            break;
            case SWORDSMEN: this.maxMove = 1;
            break;
            case KNIGHT: this.maxMove = 4;
            break;
            case ENGINEER: this.maxMove = 2;
            break;
            case BLACK_MONK: this.maxMove = 1;
            break;
            case SLAVES: this.maxMove = 3;
            break;
            case ARABIAN_SWORDSMEN: this.maxMove = 4;
            break;
        }
    }

    public int getMaxMove(){
        return this.maxMove;
    }
}
