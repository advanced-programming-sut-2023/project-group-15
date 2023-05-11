package org.example.controller;

import org.example.model.Tile;
import org.example.model.building.BuildingName;
import org.example.model.enums.LandType;
import org.example.model.enums.Tree;
import org.example.model.enums.Direction;
import org.example.model.gameData.GameInformation;
import org.example.model.gameData.Map;
import org.example.view.enums.outputs.BuildingStatusOutput;

import java.util.regex.Matcher;


public class MapMenuEnvironmentController {

    public void setTileTexture(Matcher matcher) {
        int x  , y;
        String type = new String();
        if(groupFinder(matcher , "x ") == null || groupFinder(matcher , "y") == null
                || groupFinder(matcher , "-t") == null )
            System.out.println("invalid command");
        else {
            x = Integer.parseInt(groupFinder(matcher, "x"));
            y = Integer.parseInt(groupFinder(matcher, "y"));
            type = groupFinder(matcher, "-t");
            Tile currentTile = Map.findATile(x, y);
            for (LandType landType : LandType.values())
                if (String.valueOf(landType).equals(type))
                    currentTile.setLandType(landType);
        }
    }


    public void setTexture(Matcher matcher) {
        String type = new String();
        int x1 , y1 ,x2 , y2 ;
        if(groupFinder(matcher , "x1") == null || groupFinder(matcher , "x2") == null
                || groupFinder(matcher , "-t") == null || groupFinder(matcher , "y2") == null
        || groupFinder(matcher , "y1") == null )
            System.out.println("invalid command");
        else {
        x1 = Integer.parseInt(groupFinder(matcher , "x1"));
        y1 = Integer.parseInt(groupFinder(matcher , "y1"));
        x2 = Integer.parseInt(groupFinder(matcher , "x2"));
        y2 = Integer.parseInt(groupFinder(matcher , "y2"));
        type = groupFinder(matcher , "-t");
            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    for (LandType landType : LandType.values())
                        if (landType.equals(type))
                            GameInformation.getCurrentPlayer().getMap()[x][y].setLandType(landType);
                }
            }
            }
        }

    public void clear(Matcher matcher) {
        int x = 0, y = 0;
        if(groupFinder(matcher , "x ") == null || groupFinder(matcher , "y") == null
                || groupFinder(matcher , "-t") == null )
            System.out.println("invalid command");
        else {
            x = Integer.parseInt(groupFinder(matcher, "x"));
            y = Integer.parseInt(groupFinder(matcher, "y"));
            Tile currentTile = Map.findATile(x, y);
            currentTile.setBuilding(null);
            currentTile.setTree(null);
            currentTile.setSoldier(null);
            currentTile.setRock(false, null);
        }
    }

    public void dropUnit(Matcher matcher) {
        //Mobina
    }



    public void dropTree(Matcher matcher) {
        int x = 0, y = 0;
        String type = null;
        if(groupFinder(matcher , "x ") == null || groupFinder(matcher , "y") == null
                || groupFinder(matcher , "-t") == null )
            System.out.println("invalid command");
        else {
            x = Integer.parseInt(groupFinder(matcher, "x"));
            y = Integer.parseInt(groupFinder(matcher, "y"));
            type = groupFinder(matcher, "-t");
            Tile currentTile = Map.findATile(x, y);
            for (Tree tree : Tree.values())
                if (tree.equals(type))
                    currentTile.setTree(tree);
        }

    }

    public void dropRock(Matcher matcher) {
        int x = 0, y = 0;
        String direction = null;
        if(groupFinder(matcher , "x ") == null || groupFinder(matcher , "y") == null
        || groupFinder(matcher , "-t") == null )
            System.out.println("invalid command");
        else {
            x = Integer.parseInt(groupFinder(matcher, "x"));
            y = Integer.parseInt(groupFinder(matcher, "y"));
            direction = groupFinder(matcher, "-t");
            Tile currentTile = Map.findATile(x, y);
            Direction direction1 = findDirection(direction);
            currentTile.setRock(true, direction1);
        }
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
    public String groupFinder(Matcher matcher , String toFind)
    {
        while (matcher.find()) {
            for (int i = 0; i < matcher.groupCount(); i++) {
                if (matcher.group(i) == null)
                    continue;
                if (matcher.group(i).equals(toFind))
                    return matcher.group(i + 1);
            }
        }
        return null;
    }

}
