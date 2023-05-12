package org.example.model.MBC;

import org.example.model.User;
import org.example.model.enums.State;
import org.example.model.enums.UnitName;
import org.example.model.gameData.Government;

public class Soldier extends Person{
    private int speed;
    private int attackingPower;
    private int deffense;
    private int x;
    private int y;
    private String name;
    private int maxMove;
    private State state;
    private static User owner;
    private int unitHp;
    public Soldier(int speed,int attackingPower,int deffense,int x,int y , int unitHp ,int maxMove,String name,State state){
        this.speed = speed;
        this.attackingPower = attackingPower;
        this.deffense = deffense;
        this.x = x;
        this.y = y;
        this.unitHp = unitHp;
        this.maxMove = maxMove;
        this.name = name;
        this.state = state;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public static User getOwner() {
        return owner;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
    public void setUnitHp(int unitHp) {
        this.unitHp = unitHp;
    }

    public void setMaxMove(int maxMove) {
        this.maxMove = maxMove;
    }

    public int getMaxMove(){
        return this.maxMove;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public int getUnitHp() {
        return unitHp;
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }

    public void setAttackingPower(int attackingPower) {
        this.attackingPower = attackingPower;
    }

    public void setDeffense(int deffense) {
        this.deffense = deffense;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDeffense() {
        return deffense;
    }

    public int getAttackingPower() {
        return attackingPower;
    }

    public int getSpeed() {
        return speed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
