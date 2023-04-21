package org.example.controller;
import org.example.model.Soldier;
import org.example.model.enums.State;
import org.example.model.User;
public class UnitMenuController {
    public User currentUser;
    public boolean unitState;
    public String type;
    public int x,y;
    private void selectUnit(int x,int y){
        // TODO: add code to verify type of unit
        this.x = x;
        this.y = y;
    }

    private void moveUnit(int x,int y){
        // TODO: add code to verify type of unit
    }

    private void setUnit(int x, int y, State state){
        // TODO: add code to select unit and set state
    }

    private void airAttack(int x,int y){
        // TODO: add code to select unit
    }

    private void disbandUnit(){

    }

    private void build(){

    }
}
