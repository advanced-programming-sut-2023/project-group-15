//this class is completed!
package org.example.model.enums;

public enum Products {
    HOP("hop"),
    ARCHER("archer"),
    APPLE("apple"),
    OAT("oat"),
    BREAD("bead"),
    MEAT("meat"),
    WEAT("weat"),
    BEER("beer"),
    ARMOUR("armour"),
    CHEESE("cheese"),
    FLOUR("flour"),
    ROCK("rock"),
    IRON("iron"),
    PITCH("pitch"),
    WOOD("wood"),
    VEST("vest"),
    HORSE("horse"),
    GOLD_COIN("gold coin"),
    SWORD("sword"),
    SPEAR("spear"),
    BOW("bow"),
    MACE("mace"),
    OIL_POT("oil pot"),
    ARCHE("armoury"),

    ;

    private final String productName;

    Products(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public static Products findProduct(String productName) {
        for (Products product : Products.values()) {
            if (product.getProductName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    public static Products getProductByName(String name) {
        for (Products product : Products.values()) {
            if (String.valueOf(product).equals(name))
                return product;
        }
        return null;
    }

}
