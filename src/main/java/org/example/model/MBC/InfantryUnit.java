package org.example.model.MBC;

import org.example.model.MBC.Soldier;
import org.example.model.enums.InfantryUnitName;

public class InfantryUnit extends Soldier {
    public InfantryUnitName name;
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
    public void setName(InfantryUnitName name){
        this.name = name;
    }

    public InfantryUnitName getName(){
        return this.name;
    }

    private void pikemen(){
        this.name = InfantryUnitName.PIKEMEN;
        this.maxMove = 1;
    }

    private void swordsmen(){
        this.name = InfantryUnitName.SWORDSMEN;
        this.maxMove = 1;
    }

    private void knigth(){
        this.name = InfantryUnitName.KNIGHT;
        this.maxMove = 4;
    }

    private void engineer(){
        this.name = InfantryUnitName.ENGINEER;
        this.maxMove = 2;
    }

    private void blackMonk(){
        this.name = InfantryUnitName.BLACK_MONK;
        this.maxMove = 1;
    }

    private void slaves(){
        this.name = InfantryUnitName.SLAVES;
        this.maxMove = 3;
    }

    private void arabianSwordsmen(){
        this.name = InfantryUnitName.ARABIAN_SWORDSMEN;
        this.maxMove = 4;
    }

    private int getMaxMove(){
        return this.maxMove;
    }
}
