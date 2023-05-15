//this class is completed!
package org.example.controller;

import org.example.model.enums.LandType;
import org.example.model.enums.Tree;
import org.example.model.enums.Direction;
import org.example.model.gameData.GameInformation;


public class MapMenuEnvironmentController {

    public boolean setTextureOneCoordinate(int x, int y, String type) {
        for (LandType landType : LandType.values()) {
            if (String.valueOf(landType).equalsIgnoreCase(type)) {
                GameInformation.setLandType(x, y, landType);
                return true;
            }
        }
        return false;
    }

    public void setTextureTwoCoordinate(int x1, int y1, int x2, int y2, String type) {
        LandType landType = LandType.DEFAULT;
        for (LandType landType1 : LandType.values()) {
            if (String.valueOf(landType1).equalsIgnoreCase(type))
                landType = landType1;
        }
        for (int x = x1; x < x2; x++) {
            for (int y = y1; y < y2; y++) {
                GameInformation.setLandType(x, y, landType);
            }
        }
    }

    public void clear(int x, int y) {
        GameInformation.setLandType(x, y, LandType.DEFAULT);
        GameInformation.setTree(x, y, null);
        GameInformation.setBuilding(x, y, null);
        GameInformation.setRock(x, y, false, Direction.NULL);
        GameInformation.setSoldier(x, y, null);
    }

    public void dropTree(int x, int y, String treeType) {
        for (Tree tree : Tree.values()) {
            if (String.valueOf(tree).equalsIgnoreCase(treeType))
                GameInformation.setTree(x, y, tree);
        }
    }

    public void dropRock(int x, int y, String direction) {
        Direction directionI = findDirection(direction);
        GameInformation.setRock(x, y, true, directionI);
    }

    public static Direction findDirection(String direction) {
        if (direction.matches("\\s*[nN]\\s*")) {
            return Direction.UP;
        } else if (direction.matches("\\s*[eE]\\s*")) {
            return Direction.RIGHT;
        } else if (direction.matches("\\s*[wW]\\s*")) {
            return Direction.LEFT;
        } else if (direction.matches("\\s*[sS]\\s*")) {
            return Direction.DOWN;
        }
        return Direction.NULL;
    }

    public boolean checkLandType(String type) {
        for (LandType landType : LandType.values()) {
            if (String.valueOf(landType).equalsIgnoreCase(type))
                return true;
        }
        return false;
    }

    public boolean treeTypeCheck(String type) {
        for (Tree tree : Tree.values()) {
            if (String.valueOf(tree).equalsIgnoreCase(type))
                return true;
        }
        return false;
    }
}
