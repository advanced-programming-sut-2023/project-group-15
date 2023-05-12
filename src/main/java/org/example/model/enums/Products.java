package org.example.model.enums;

public enum Products {
    APPLE,
    OAT,
    BREAD,
    MEAT,
    WEAT,
    BEER,
    ARMOUR,
    CHEESE,
    FLOUR,
    ROCK,
    IRON,
    PITCH,
    WOOD,
    VEST,
    HORSE,
    GOLD_COIN,
    SWORD,
    SPEAR,
    BOW,
    MACE,
    OIL_POT,
    ;

    Products() {
    }

    public static Products getproductByName(String name)
            {
                for(Products product : Products.values())
                {
                    if(String.valueOf(product).equals(name))
                        return product;
                }
                return null;
            }

    ;
}
