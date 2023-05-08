package org.example.model.MBC;

import org.example.model.MBC.Soldier;
import org.example.model.enums.State;
import org.example.model.enums.UnitName;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LauncherUnit extends Soldier {
    public UnitName name;
    public int maxMove;
    public int throwrange;
    public State state;
    public ArrayList<String> FightingFeature;



    public void setThrowrange(int throwrange){
        this.throwrange = throwrange;
    }
    public int getThrowRageForChanging(){
        return this.throwrange;
    }
    public UnitName getName() {
        return name;
    }

    public void setName(UnitName name) {
        this.name = name;
    }

    private void archer(){
        this.name = UnitName.ARCHER;
    }

    private void crossbowmen(){
        this.name = UnitName.CROSSBOWMEN;
    }

    private void arrcherBow(){
        this.name = UnitName.ARCHERBOW;
    }

    private void slingers(){
        this.name = UnitName.SLINGERS;
    }

    private void horseArchers(){
        this.name = UnitName.HORSE_ARCHERS;
    }

    private void firethrowers(){
        this.name = UnitName.FIRE_THROWERS;
    }

    public void setMove(UnitName name){
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
    }

    public int getThrowRange(UnitName name){
        switch (name){
            case ARCHER : this.throwrange = 2;
            break;
            case ARCHERBOW : this.throwrange = 2;
            break;
            case CROSSBOWMEN: this.throwrange = 2;
            break;
            case SLINGERS: this.throwrange = 2;
            break;
            case HORSE_ARCHERS: this.throwrange = 2;
            break;
            case FIRE_THROWERS: this.throwrange = 3;
            break;
        }
        return this.throwrange;
    }



    public void setState(String state){
        switch (State.valueOf(state)){
            case STANDING:
        }
    }

    public int getMaxMove(){
        return this.maxMove;
    }


}
