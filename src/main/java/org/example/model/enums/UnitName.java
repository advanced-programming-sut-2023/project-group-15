package org.example.model.enums;

import org.example.model.User;

public enum UnitName {
    PIKEMEN(3,9,8,1,10),
    SWORDSMEN(3,15,2,1,10),
    KNIGHT(4,15,8,1,10),
    ENGINEER(2,0,2,2,10),
    BLACK_MONK(2,9,6,1,10),
    SLAVES(4,3,2,3,10),
    ARABIAN_SWORDSMEN(3,12,8,4,10),
    ARCHER(3,6,4,3,10,2),
    CROSSBOWMEN(1,6,6,1,10,2),
    ARCHERBOW(3,6,4,3,10,2),
    SLINGERS(3,6,2,3,10,2),
    HORSE_ARCHERS(4,6,6,4,10,3),
    FIRE_THROWERS(4,12,8,4,10,4),
    SPEARMEN(2,9,8,2,10),
    MACEMEN(2,12,6,2,10),
    TUNNELER(3,9,2,3,10),
    LADDERMEN(3,0,2,3,10),
    ASSASSINS(2,9,6,2,10),
   ;

    private int speed;
    private int attackingPower;
    private int deffense;
    private int maxMove;
    private int throwRange;
    private int unitHp;

    public int getSpeed(){
        return this.speed;
    }
    public int getAttackingPower(){
        return this.attackingPower;
    }
    public int getDeffense(){
        return this.deffense;
    }
    public int getMaxMove(){
        return this.maxMove;
    }
    public int getThrowRange(){
        return this.throwRange;
    }
    public int getUnitHp(){
        return this.unitHp;
    }
    UnitName(int speed,int attackingPower,int deffense, int maxMove,int unitHp){
        this.speed = speed;
        this.attackingPower = attackingPower;
        this.deffense = deffense;
        this.maxMove = maxMove;
        this.unitHp = unitHp;
    }
    UnitName(int speed,int attackingPower,int deffense, int maxMove,int unitHp,int throwRange){
        this.speed = speed;
        this.attackingPower = attackingPower;
        this.deffense = deffense;
        this.maxMove = maxMove;
        this.unitHp = unitHp;
        this.throwRange = throwRange;
    }
    public static UnitName getUnitName(String name)
    {
        for(UnitName unitName : UnitName.values())
            if(unitName.equals(name))
                return unitName;
        return null;
    }

}
