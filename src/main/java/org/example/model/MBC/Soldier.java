package org.example.model.MBC;

import org.example.model.User;
import org.example.model.enums.State;

public class Soldier extends Person {
    private final int speed;
    private int attackingPower;
    private final int defense;
    private int x;
    private int y;
    private final String name;
    private int maxMove;
    private State state;
    private User owner;
    //owner most set in the controller ...
    private int unitHp;

    public Soldier(int speed, int attackingPower, int defense, int x, int y, int unitHp, int maxMove, String name, State state) {
        this.speed = speed;
        this.attackingPower = attackingPower;
        this.defense = defense;
        this.x = x;
        this.y = y;
        this.unitHp = unitHp;
        this.maxMove = maxMove;
        this.name = name;
        this.state = state;
    }

    public User getOwner() {
        return this.owner;
    }

    public String getName() {
        return this.name;
    }

    public void setUnitHp(int unitHp) {
        this.unitHp = unitHp;
    }

    public void setMaxMove(int maxMove) {
        this.maxMove = maxMove;
    }

    public int getMaxMove() {
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

    public void setAttackingPower(int attackingPower) {
        this.attackingPower = attackingPower;
    }
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDefense() {
        return defense;
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
