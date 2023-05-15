package org.example.controller;

import org.example.model.gameData.GameInformation;
import org.example.model.Tile;

import java.util.regex.Matcher;

public class MapMenuController {

    private int xStart;
    private int yStart;
    private final Tile[][] currentUserMap;

    public MapMenuController() {
        this.currentUserMap = GameInformation.getCurrentPlayerMap();
    }

    public int getxStart() {
        return xStart;
    }

    public int getyStart() {
        return yStart;
    }

    public void setxStart(int xStart) {
        this.xStart = xStart;
    }

    public void setyStart(int yStart) {
        this.yStart = yStart;
    }

    public void showMap(int x, int y) {
        int xS = x - 5;  // x startpoint
        int xE = x + 5;  // x endpoint
        if (xS < 0) {
            xE -= xS;
            xS = 0;
        }
        if (xE > 199) {
            xS -= xE - 199;
            xE = 199;
        }
        int yS = y - 5;  // y startpoint
        int yE = y + 5;  // y endpoint
        if (yS < 0) {
            yE -= yS;
            yS = 0;
        }
        if (yE > 199) {
            yS -= yE - 199;
            yE = 199;
        }
        for (int i = xS; i < xE; i++) {
            for (int j = yS; j < yE; j++) {
                if (GameInformation.getCurrentPlayerMap()[i][j].getSoldier() != null) {
                    System.out.print("S ");
                } else if (GameInformation.getCurrentPlayerMap()[i][j].getBuilding() != null) {
                    System.out.print("B ");
                } else if (GameInformation.getCurrentPlayerMap()[i][j].getLandType() != null) {
                    System.out.print(GameInformation.getCurrentPlayerMap()[i][j].getLandType().getMapId() + " ");
                } else
                    System.out.print("D ");
            }
            System.out.println();
        }
    }

    public void moving(Matcher matcher) {
        int x,y;
        x = findX(matcher);
        y = findY(matcher);
        showMap(xStart + x, yStart + y);
    }

    private int findY(Matcher matcher) {
        if (matcher.group("n") != null) {
            if (matcher.group("un") != null)
                return Integer.parseInt(matcher.group("un"));
            else
                return  1;
        } else {
            if (matcher.group("dn") != null)
                return  -Integer.parseInt(matcher.group("dn"));
            else
                return  -1;
        }
    }

    private int findX(Matcher matcher) {
        if (matcher.group("l") != null) {
            if (matcher.group("ln") != null)
                return  -Integer.parseInt(matcher.group("ln"));
            else
                return  -1;
        } else {
            if (matcher.group("rn") != null)
                return Integer.parseInt(matcher.group("rn"));
            else
                return  1;
        }
    }

    public String showDetails(int x, int y) {
        int landTypeCounter = 0;
        Tile currentTile = currentUserMap[x][y];
        String answer = "LandType : ";
        for (int i = 0; i < currentUserMap.length; i++) {
            for (int j = 0; j < currentUserMap.length; j++) {
                if (currentUserMap[i][j].getLandType().equals(currentTile.getLandType()))
                    landTypeCounter++;
            }
        }
        answer = answer.concat(currentTile.getLandType().values().toString() +
                "number of tiles with this landtype on map : " + String.valueOf(landTypeCounter));
        if (currentTile.getBuilding() != null)
            answer = answer.concat("\n" + "Building(s): " + currentTile.getBuilding().getName().toString());
        if (currentTile.getSoldier() != null) {
            answer = answer.concat("\n" + "Soldier(s) : " + currentTile.getSoldier().getName().toString() +
                    "\n" + "number of soldiers: " + String.valueOf(currentTile.getNumberOfSoldiers()));
        }
        return answer;
    }

    public boolean checkMatcher(Matcher matcher) {
        return matcher.group("x") != null && matcher.group("y") != null;
    }

    public boolean checkMovingMapArguments(Matcher matcher) {
        if (matcher.group("l") != null && matcher.group("r") != null) {
            return false;
        } else if (matcher.group("u") != null && matcher.group("d") != null) {
            return false;
        } else
            return true;
    }
}





