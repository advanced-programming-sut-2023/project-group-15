package org.example.model.enums;

public enum Unitcosts {
    PIKEMEN(60),
    SWORDSMEN(50),
    KNIGHT(100),
    ENGINEER(25),
    BLACK_MONK(45),
    SLAVES(40),
    ARABIAN_SWORDSMEN(100),
    ARCHER(50),
    CROSSBOWMEN(40),
    ARCHERBOW(45),
    SLINGERS(50),
    HORSE_ARCHERS(65),
    FIRE_THROWERS(80),
    SPEARMEN(50),
    MACEMEN(70),
    TUNNELER(55),
    LADDERMEN(35),
    ASSASSINS(65),
    ;
    private double cost;

    Unitcosts(int cost) {
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }
}
