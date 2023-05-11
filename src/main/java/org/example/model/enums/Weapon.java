package org.example.model.enums;

public enum Weapon {
    SWORD(0),
    SPEAR(0),
    BOW(4),
    CROSS_BOW(8),
    LATHER_ARMOR(0),
    SLING(4),
    GREEK_FIRE(10),

    ;
    Weapon(int damage) {
        this.damage = damage;
    }
    public int getDamage() {
        return damage;
    }
    private final int damage ;
}
