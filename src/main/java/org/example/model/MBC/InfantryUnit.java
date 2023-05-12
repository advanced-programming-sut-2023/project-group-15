package org.example.model.MBC;

import org.example.model.enums.State;

public class InfantryUnit extends Soldier {

    public InfantryUnit(int speed, int attackingPower , int defense , int x, int y , int unitHp , int maxMove ,String name,State state){
        super(speed, attackingPower ,defense , x, y , unitHp , maxMove , name,state);
    }

}
