package org.example.model.MBC;

import org.example.model.MBC.Soldier;
import org.example.model.User;
import org.example.model.enums.State;
import org.example.model.enums.UnitName;
import org.example.model.gameData.Government;

public class InfantryUnit extends Soldier {

    public InfantryUnit(int speed, int attackingPower , int deffens , int x, int y , int unitHp , int maxMove , UnitName name , State state , User owner){
        super(speed, attackingPower ,deffens , x, y , unitHp , maxMove , name,state,owner);
    }

}
