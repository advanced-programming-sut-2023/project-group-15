package org.example.model.MBC;

import org.example.model.MBC.Soldier;
import org.example.model.User;
import org.example.model.enums.State;
import org.example.model.enums.UnitName;
import org.example.model.gameData.Government;
import org.example.model.enums.Weapon;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class LauncherUnit extends Soldier {
    private int throwRange;
    private Weapon fightingFeature;
    public LauncherUnit(int speed, int attackingPower , int deffens , int x, int y , int unitHp , int maxMove ,
                        String name , State state , int range ){
        super(speed, attackingPower ,deffens , x, y , unitHp , maxMove , name,state);
        this.throwRange = range;
    }
    public void setThrowRange(int throwRange){
        this.throwRange = throwRange;
    }
    public int getThrowRageForChanging(){
        return this.throwRange;
    }


}
