package org.example.model.MBC;

public class Soldier extends Person{
    private int speed;
    private int attackingPower;
    private int deffense;
    private int x;
    private int y;

    public Soldier(int speed,int attackingPower,int deffense,int x,int y){
        this.speed = speed;
        this.attackingPower = attackingPower;
        this.deffense = deffense;
        this.x = x;
        this.y = y;
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
