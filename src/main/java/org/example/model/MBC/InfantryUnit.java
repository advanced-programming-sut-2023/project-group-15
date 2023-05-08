package org.example.model.MBC;

import org.example.model.MBC.Soldier;
import org.example.model.enums.State;
import org.example.model.enums.UnitName;

public class InfantryUnit extends Soldier {
    public UnitName name;
    public int maxMove;
    public State state;

    /*public void setState(String state){
        switch (State.valueOf(state)){
            case STANDING:
        }
    }*/

    public InfantryUnit(int speed, int attackingPower , int deffens , int x, int y, UnitName name , int maxMove , int throwRange , State state){
        super(speed, attackingPower ,deffens , x, y);
        this.name = name;
        this.maxMove = maxMove;
        this.state = state;
    }
    public void setName(UnitName name){
        this.name = name;
    }

    public UnitName getName(){
        return this.name;
    }

    public void pikemen(){
        this.name = UnitName.PIKEMEN;
    }

    public void swordsmen(){
        this.name = UnitName.SWORDSMEN;
    }

    public void knigth(){
        this.name = UnitName.KNIGHT;
    }

    public void engineer(){
        this.name = UnitName.ENGINEER;
    }

    public void blackMonk(){
        this.name = UnitName.BLACK_MONK;
    }

    public void slaves(){
        this.name = UnitName.SLAVES;
    }

    public void arabianSwordsmen(){
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
