//this class is completed!
package org.example.model.enums;

import org.example.model.building.BuildingName;
import org.example.model.building.Storage;

public enum StoreProducts {
    APPLE("FOODSTORE"),
    OAT("FOODSTORE"),
    BREAD("FOODSTORE"),
    MEAT("FOODSTORE"),
    WEAT("FOODSTORE"),
    BEER("FOODSTORE"),
    ARMOUR("FOODSTORE"),
    CHEESE("FOODSTORE"),
    FLOUR("FOODSTORE"),
    ROCK("SOURCESTORE"),
    IRON("SOURCESTORE"),
    PITCH("SOURCESTORE"),
    WOOD("SOURCESTORE"),
    VEST("SOURCESTORE"),
    HORSE("SOURCESTORE"),
    SWORD("ARMOURY"),
    SPEAR("ARMOURY"),
    ARCHE("ARMOURY"),
    MACE("ARMOURY"),
    OIL_POT("ARMOURY"),
    ;
    private final String storeType;

    StoreProducts(String storeType) {
        this.storeType = storeType;
    }

    public String getStoreType() {
        return storeType;
    }

}
