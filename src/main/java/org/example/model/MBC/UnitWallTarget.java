package org.example.model.MBC;

import org.example.model.MBC.Soldier;
import org.example.model.enums.UnitName;

public class UnitWallTarget extends Soldier {
    public UnitName name;
    public int maxMove;


    public void setName(UnitName name) {
        this.name = name;
    }

    public UnitName getName() {
        return name;
    }

    private void spearmen(){
        this.name = UnitName.SPEARMEN;
    }

    private void macemen(){
        this.name = UnitName.MACEMEN;
    }

    private void tunneler(){
        this.name = UnitName.TUNNELER;
    }

    private void laddermen(){
        this.name = UnitName.LADDERMEN;
    }

    private void assassins(){
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
