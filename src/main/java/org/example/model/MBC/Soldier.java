package org.example.model.MBC;

import org.example.model.User;

public class Soldier extends Person {
    private final int speed;
    private int attackingPower;
    private final int defense;
    private int x;
    private int y;
    private final String name;
    private int maxMove;
    private String state;
    private static User owner;
    public boolean patrolling;
    private int unitHp;
    private String type;

    public Soldier(int speed, int attackingPower, int defense, int x, int y, int unitHp, int maxMove, String name, String type, String state) {
        this.speed = speed;
        this.attackingPower = attackingPower;
        this.defense = defense;
        this.x = x;
        this.y = y;
        this.unitHp = unitHp;
        this.maxMove = maxMove;
        this.name = name;
        this.type = type;
        this.state = state;
        this.patrolling = false;
    }

    public void setPatrolling(boolean patrolling) {
        this.patrolling = patrolling;
    }

    public boolean isPatrolling() {
        return patrolling;
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

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
