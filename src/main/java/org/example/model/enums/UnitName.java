package org.example.model.enums;

public enum UnitName {
    PIKEMEN,
    SWORDSMEN,
    KNIGHT,
    ENGINEER,
    BLACK_MONK,
    SLAVES,
    ARABIAN_SWORDSMEN,
    ARCHER,
    CROSSBOWMEN,
    ARCHERBOW,
    SLINGERS,
    HORSE_ARCHERS,
    FIRE_THROWERS,
    SPEARMEN,
    MACEMEN,
    TUNNELER,
    LADDERMEN,
    ASSASSINS,
   ;
    public static UnitName getUnitName(String name)
    {
        for(UnitName unitName : UnitName.values())
            if(unitName.equals(name))
                return unitName;
        return null;
    }

}
