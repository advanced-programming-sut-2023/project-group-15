package org.example.model.enums;

public enum Tree {
    SHRUB,
    CHERRY_PALM,
    OLIVE_TREE,
    COCONUT_PALM,
    DATE_PALM,
    ;

    public static Tree getTree(String name) {
        for (Tree tree : Tree.values())
            if (String.valueOf(tree).equals(name))
                return tree;
        return null;
    }

}
