package org.example.model.MBC;

import org.example.model.MBC.Soldier;
import org.example.model.enums.State;
import org.example.model.enums.UnitName;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LauncherUnit extends Soldier {
    private UnitName name;
    private int maxMove;
    private int throwRange;
    private State state;
    private ArrayList<String> FightingFeature;


    public LauncherUnit(int speed, int attackingPower , int deffens , int x, int y, UnitName name , int maxMove , int throwRange , State state){
        super(speed, attackingPower ,deffens , x, y);
        this.name = name;
        this.maxMove = maxMove;
        this.throwRange = throwRange;
        this.state = state;
    }

    public void setThrowRange(int throwRange){
        this.throwRange = throwRange;
    }
    public int getThrowRageForChanging(){
        return this.throwRange;
    }
    public UnitName getName() {
        return name;
    }

    public void setName(UnitName name) {
        this.name = name;
    }

    public void archer(){
        this.name = UnitName.ARCHER;
    }

    public void crossbowmen(){
        this.name = UnitName.CROSSBOWMEN;
    }

    public void arrcherBow(){
        this.name = UnitName.ARCHERBOW;
    }

    public void slingers(){
        this.name = UnitName.SLINGERS;
    }

    public void horseArchers(){
        this.name = UnitName.HORSE_ARCHERS;
    }

    public void firethrowers(){
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
            case ARCHER,ARCHERBOW,CROSSBOWMEN,SLINGERS: this.throwRange = 2;
            break;
            case HORSE_ARCHERS: this.throwRange = 3;
            break;
            case FIRE_THROWERS: this.throwRange = 4;
            break;
        }
        return this.throwRange;
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
