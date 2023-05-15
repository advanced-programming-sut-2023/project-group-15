//this class is completed!
package org.example.model.enums;

public enum Tree {
    SHRUB("shrub"),
    CHERRY_PALM("cherry palm"),
    OLIVE_TREE("olive tree"),
    COCONUT_PALM("coconut palm"),
    DATE_PALM("date palm"),
    ;
    private final String tree;

    public String getTree() {
        return tree;
    }

    Tree(String tree) {
        this.tree = tree;
    }


}
