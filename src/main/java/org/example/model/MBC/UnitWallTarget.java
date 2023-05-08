package org.example.model.MBC;

import org.example.model.MBC.Soldier;
import org.example.model.enums.UnitName;

public class UnitWallTarget extends Soldier {
    private UnitName name;
    private int maxMove;


    public UnitWallTarget(int speed, int attackingPower , int deffens , int x, int y, UnitName name , int maxMove){
        super(speed, attackingPower ,deffens , x, y);
        this.name = name;
        this.maxMove = maxMove;
    }
    public void setName(UnitName name) {
        this.name = name;
    }

    public UnitName getName() {
        return name;
    }

    public void spearmen(){
        this.name = UnitName.SPEARMEN;
    }

    public void macemen(){
        this.name = UnitName.MACEMEN;
    }

    public void tunneler(){
        this.name = UnitName.TUNNELER;
    }

    public void laddermen(){
        this.name = UnitName.LADDERMEN;
    }

    public void assassins(){
        this.name = UnitName.ASSASSINS;
    }

    public void setMaxMove(UnitName name){
        switch (name){
            case SPEARMEN: this.maxMove = 2;
            break;
            case MACEMEN: this.maxMove = 2;
            break;
            case TUNNELER: this.maxMove = 3;
            break;
            case LADDERMEN: this.maxMove = 3;
            break;
            case ASSASSINS: this.maxMove = 2;
            break;
        }
    }

    public int getMaxMove(){
        return this.maxMove;
    }
    public void changeMove(int maxMove){
        this.maxMove = maxMove;
    }
}
