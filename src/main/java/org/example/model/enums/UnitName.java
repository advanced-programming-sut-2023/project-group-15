package org.example.model.enums;

public enum UnitName {
    PIKEMEN(3, 9, 8, 1, 10, "pikemen", "infantry", 60),
    SWORDSMEN(3, 15, 2, 1, 10, "swordsmen", "infantry", 50),
    KNIGHT(4, 15, 8, 1, 10, "knight", "infantry", 100),
    ENGINEER(2, 0, 2, 2, 10, "engineer", "infantry", 25),
    BLACK_MONK(2, 9, 6, 1, 10, "black monk", "infantry", 45),
    SLAVES(4, 3, 2, 3, 10, "slaves", "infantry", 40),
    ARABIAN_SWORDSMEN(3, 12, 8, 4, 10, "arabian swordsmen", "infantry", 100),
    ARCHER(3, 6, 4, 3, 10, 2, "archer", "launcher", 50),
    CROSSBOWMEN(1, 6, 6, 1, 10, 2, "crossbowmen", "launcher", 40),
    ARCHERBOW(3, 6, 4, 3, 10, 2, "archerbow", "launcher", 45),
    SLINGERS(3, 6, 2, 3, 10, 2, "slingers", "launcher", 50),
    HORSE_ARCHERS(4, 6, 6, 4, 10, 3, "horse archers", "launcher", 65),
    FIRE_THROWERS(4, 12, 8, 4, 10, 4, "fire throwers", "launcher", 80),
    SPEARMEN(2, 9, 8, 2, 10, "spearmen", "wallTarget", 50),
    MACEMEN(2, 12, 6, 2, 10, "macemen", "wallTarget", 70),
    TUNNELER(3, 9, 2, 3, 10, "tunneler", "wallTarget", 55),
    LADDERMEN(3, 0, 2, 3, 10, "laddermen", "wallTarget", 35),
    ASSASSINS(2, 9, 6, 2, 10, "laddermen", "wallTarget", 65),
    ;

    private final int speed;
    private final int attackingPower;
    private final int defense;
    private final int maxMove;
    private int throwRange;
    private final int unitHp;
    private final String name;
    private final double cost;
    private final String type;


    public int getSpeed() {
        return this.speed;
    }

    public int getAttackingPower() {
        return this.attackingPower;
    }

    public int getDefense() {
        return this.defense;
    }

    public int getMaxMove() {
        return this.maxMove;
    }

    public int getThrowRange() {
        return this.throwRange;
    }

    public int getUnitHp() {
        return this.unitHp;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    UnitName(int speed, int attackingPower, int defense, int maxMove, int unitHp, String name, String type, double cost) {
        this.speed = speed;
        this.attackingPower = attackingPower;
        this.defense = defense;
        this.maxMove = maxMove;
        this.unitHp = unitHp;
        this.name = name;
        this.type = type;
        this.cost = cost;
    }

    UnitName(int speed, int attackingPower, int defense, int maxMove, int unitHp, int throwRange, String name, String type, double cost) {
        this.speed = speed;
        this.attackingPower = attackingPower;
        this.defense = defense;
        this.maxMove = maxMove;
        this.unitHp = unitHp;
        this.throwRange = throwRange;
        this.name = name;
        this.type = type;
        this.cost = cost;
    }

    public static UnitName getUnitType(String name) {
        for (UnitName unitName : UnitName.values())
            if (unitName.name.equals(name))
                return unitName;
        return null;
    }
    public double getCost() {
        return cost;
    }

}
