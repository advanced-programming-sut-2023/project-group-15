package org.example.controller;

import org.example.model.Tile;
import org.example.model.enums.Direction;
import org.example.model.enums.LandType;
import org.example.model.enums.Tree;
import org.example.model.gameData.GameInformation;
import org.example.model.gameData.Map;

import java.util.regex.Matcher;


public class MapMenuEnvironmentController {
    public void setMapGame(int size, int number) {
        GameInformation.setMapGame(size, number);
        //TODO hear we set the whole map game from the templates
        // no changes on the ready template hear

    }

    public void generateEachPlayerMap(int playerNumber, int mapSize) {
        Tile[][] playerMap = new Tile[mapSize / 2][];
        if (playerNumber <= 4) {
            for (int i = 0; i < mapSize / 2; i++) {
                for (int j = 0; j < mapSize / 4; j++)
                    playerMap[i][j] = GameInformation.getGameMap()[i][(playerNumber - 1) * mapSize / 4];
            }
        } else {
            for (int i = 0; i < mapSize / 2; i++) {
                for (int j = 0; j < mapSize / 4; j++) {
                    playerMap[i][j] = GameInformation.getGameMap()[i + mapSize / 2][((playerNumber % 4) - 1) * mapSize / 4];
                }
            }
        }
    }

    public void setTileTexture(Matcher matcher) {
        int x = 0;
        int y = 0;
        String type = null;
        while (matcher.find()) {
            for (int i = 0; i < matcher.groupCount(); i++) {
                if (matcher.group(i) == null)
                    continue;
                if (matcher.group(i).equals("x"))
                    x = Integer.parseInt(matcher.group(i + 1));
                if ((matcher.group(i).equals("y")))
                    y = Integer.parseInt(matcher.group(i + 1));
                if ((matcher.group(i).equals("-t")))
                    type = matcher.group(i + 1);
            }
        }
        Tile currentTile = Map.findATile(x, y);
        for (LandType landType : LandType.values())
            if (landType.equals(type))
                currentTile.setLandType(landType);
    }


    public void setTexture(Matcher matcher) {
        String type = null;
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;
        for (int i = 0; i < matcher.groupCount(); i++) {
            if (matcher.group(i).equals("x1"))
                x1 = Integer.parseInt(matcher.group(i + 1));
            if (matcher.group(i).equals("y1"))
                y1 = Integer.parseInt(matcher.group(i + 1));
            if (matcher.group(i).equals("x2"))
                x2 = Integer.parseInt(matcher.group(i + 1));
            if (matcher.group(i).equals("y2"))
                y2 = Integer.parseInt(matcher.group(i + 1));
            if (matcher.group(i).equals("t"))
                type = matcher.group(i + 1);
            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    for (LandType landType : LandType.values())
                        if (landType.equals(type))
                            Map.findATile(x, y).setLandType(landType);
                }
            }
        }
    }

    public void clear(Matcher matcher) {
        int x = 0, y = 0;
        for (int i = 0; i < matcher.groupCount(); i++) {
            if (matcher.group(i) == null)
                continue;
            if (matcher.group(i).equals("x"))
                x = Integer.parseInt(matcher.group(i + 1));
            if ((matcher.group(i).equals("y")))
                y = Integer.parseInt(matcher.group(i + 1));
        }
        Tile currentTile = Map.findATile(x, y);
        currentTile.setBuilding(null);
        currentTile.setTree(null);
        currentTile.setSoldier(null);
        currentTile.setRock(false, null);
    }

    public void dropUnit(Matcher matcher) {
        //Mobina
    }

    public void dropBuilding(Matcher matcher) {
        //Mahdi
    }

    public void dropTree(Matcher matcher) {
        int x = 0, y = 0;
        String type = new String();
        for (int i = 0; i < matcher.groupCount(); i++) {
            if (matcher.group(i) == null)
                continue;
            if (matcher.group(i).equals("x"))
                x = Integer.parseInt(matcher.group(i + 1));
            if ((matcher.group(i).equals("y")))
                y = Integer.parseInt(matcher.group(i + 1));
            if ((matcher.group(i).equals("-t")))
                type = matcher.group(i + 1);
        }
        Tile currentTile = Map.findATile(x, y);
        for (Tree tree : Tree.values())
            if (tree.equals(type))
                currentTile.setTree(tree);

    }

    public void dropRock(Matcher matcher) {
        int x = 0, y = 0;
        String direction = null;
        for (int i = 0; i < matcher.groupCount(); i++) {
            if (matcher.group(i) == null)
                continue;
            if (matcher.group(i).equals("x"))
                x = Integer.parseInt(matcher.group(i + 1));
            if ((matcher.group(i).equals("y")))
                y = Integer.parseInt(matcher.group(i + 1));
            if ((matcher.group(i).equals("-t")))
                direction = matcher.group(i + 1);
        }
        Tile currentTile = Map.findATile(x, y);
        Direction direction1 = findDirection(direction);
        currentTile.setRock(true, direction1);
    }

    private Direction findDirection(String direction) {
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
}
