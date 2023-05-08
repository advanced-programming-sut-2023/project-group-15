package org.example.model.MBC;

public class Soldier extends Person{
    public int speed;
    public int attackingPower;
    public int deffense;
    public int x;
    public int y;

    private void Soldier(int speed,int attackingPower,int deffense,int x,int y){
        this.speed = speed;
        this.attackingPower = attackingPower;
        this.deffense = deffense;
        this.x = x;
        this.y = y;
    }

    private void setSpeed(int speed){
        this.speed = speed;
    }

    private void setAttackingPower(int attackingPower) {
        this.attackingPower = attackingPower;
    }

    private void setDeffense(int deffense) {
        this.deffense = deffense;
    }

    private void setX(int x) {
        this.x = x;
    }

    private void setY(int y) {
        this.y = y;
    }

    private int getDeffense() {
        return deffense;
    }

    private int getAttackingPower() {
        return attackingPower;
    }

    private int getSpeed() {
        return speed;
    }

    private int getX() {
        return x;
    }

    private int getY() {
        return y;
    }
}
