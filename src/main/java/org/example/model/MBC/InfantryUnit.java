package org.example.model.MBC;

import org.example.model.enums.State;
import org.example.model.gameData.Government;

public class InfantryUnit extends Soldier {

    public InfantryUnit(int speed, int attackingPower , int defense , int x, int y , int unitHp , int maxMove , String name ,String type, String state){
        super(speed, attackingPower ,defense , x, y , unitHp , maxMove , name,type,state);
    }

}
