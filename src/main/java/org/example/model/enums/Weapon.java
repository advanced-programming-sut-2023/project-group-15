//this class is completed!
package org.example.model.enums;

public enum Weapon {
    SWORD("sword"),
    SPEAR("spear"),
    BOW("bow"),
    CROSS_BOW("cross bow"),
    LATHER_ARMOR("lather armor"),
    SLING("sling"),
    GREEK_FIRE("greek fire"),
    ;
    private final String weapon;

    Weapon(String weapon) {
        this.weapon = weapon;
    }

    public String getWeapon() {
        return weapon;
    }
}

