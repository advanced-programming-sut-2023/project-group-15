package org.example.controller;

import org.example.model.Tile;
import org.example.model.enums.LandType;
import org.example.model.enums.Tree;
import org.example.model.enums.Direction;
import org.example.model.gameData.GameInformation;


public class MapMenuEnvironmentController {

    public void setTextureOneCoordinate(int x, int y, String type) {
        Tile currentTile = GameInformation.getGameMap()[x][y];
        for (LandType landType : LandType.values()) {
            if (String.valueOf(landType).equals(type))
                currentTile.setLandType(landType);
        }
    }

    public void setTextureTwoCoordinate(int x1, int y1, int x2, int y2, String type) {
        LandType landType = LandType.DEFAULT;
        for (LandType landType1 : LandType.values()) {
            if (String.valueOf(landType1).equals(type))
                landType = landType1;
        }
        for (int x = x1; x < x2; x++) {
            for (int y = y1; y < y2; y++) {
                GameInformation.getCurrentPlayer().getMap()[x][y].setLandType(landType);
            }
        }
    }

    public void clear(int x, int y) {
        Tile currentTile = GameInformation.getGameMap()[x][y];
        currentTile.setBuilding(null);
        currentTile.setTree(null);
        currentTile.setSoldier(null);
        currentTile.setRock(false, null);
        currentTile.setLandType(LandType.DEFAULT);
    }

    public void dropTree(int x, int y, String treeType) {
        Tile currentTile = GameInformation.getGameMap()[x][y];
        for (Tree tree : Tree.values()) {
            if (String.valueOf(tree).equals(treeType))
                currentTile.setTree(tree);
        }
    }

    public void dropRock(int x, int y, String direction) {
        Tile currentTile = GameInformation.getGameMap()[x][y];
        Direction directionI = findDirection(direction);
        currentTile.setRock(true, directionI);
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
            if (String.valueOf(landType).equals(type))
                return true;
        }
        return false;
    }

    public boolean treeTypeCheck(String type) {
        for (Tree tree : Tree.values()) {
            if (String.valueOf(tree).equals(type))
                return true;
        }
        return false;
    }
}
