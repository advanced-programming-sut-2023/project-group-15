package org.example.model.MBC;

import org.example.model.enums.State;

public class InfantryUnit extends Soldier {

    public InfantryUnit(int speed, int attackingPower , int deffens , int x, int y , int unitHp , int maxMove , String name , String state){
        super(speed, attackingPower ,deffens , x, y , unitHp , maxMove , name,state);
    }

}
