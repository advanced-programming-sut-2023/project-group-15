//this class is completed!
package org.example.model.enums;

public enum StoreProducts {
    APPLE("foodStore"),
    OAT("foodStore"),
    BREAD("foodStore"),
    MEAT("foodStore"),
    WEAT("foodStore"),
    BEER("foodStore"),
    ARMOUR("foodStore"),
    CHEESE("foodStore"),
    FLOUR("foodStore"),
    ROCK("sourceStore"),
    IRON("sourceStore"),
    PITCH("sourceStore"),
    WOOD("sourceStore"),
    VEST("foodStore"),
    HORSE("foodStore"),
    SWORD("armoury"),
    SPEAR("armoury"),
    ARCHE("armoury"),
    MACE("armoury"),
    OIL_POT("armoury"),

    ;
    private final String storeType;

    StoreProducts(String storeType) {
        this.storeType = storeType;
    }

    public String getStoreType() {
        return storeType;
    }

}
