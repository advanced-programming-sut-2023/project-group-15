package org.example.model.enums;

public enum Weapon {
    SWORD(0),
    SPEAR(0),
    ARCHER(0),
    ARMOR(0),
    ;
    Weapon(int damage) {
        this.damage = damage;
    }
    public int getDamage() {
        return damage;
    }
    private final int damage ;
}
