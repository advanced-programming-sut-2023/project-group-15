package org.example.controller;
import org.example.model.MBC.Soldier;
import org.example.model.building.BuildingName;
import org.example.model.gameData.GameInformation;
import org.example.model.gameData.Map;
import org.example.model.Tile;
import org.example.view.MapMenu;

import javax.management.StringValueExp;
import java.util.regex.Matcher;

public class MapMenuController {

    private static int xStart = 0;
    private static int yStart = 0;
    private static Tile[][] currentUserMap;

    public MapMenuController() {
        currentUserMap = GameInformation.getGameMap();
    }

    public void setStartingPoint(Matcher matcher) {
        int x = 0, y = 0;
        for (int i = 0; i < matcher.groupCount(); i++) {
            if (matcher.group(i) == null)
                continue;
            if (matcher.group(i).equals("x"))
                x = Integer.parseInt(matcher.group(i + 1));
            if (matcher.group(i).equals("y"))
                y = Integer.parseInt(matcher.group(i + 1));
        }
        xStart = x;
        yStart = y;
    }

    public int getxStart() {
        return xStart;
    }

    public int getyStart() {
        return yStart;
    }

    public void showMap(int x, int y) {
        Tile currentTile = currentUserMap[x][y];
        Tile[][] mapToShow = new Tile[11][11];
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
                    continue;
                } else if (GameInformation.getCurrentPlayerMap()[i][j].getBuilding() != null) {
                    System.out.print("B ");
                    continue;
                } else
                    System.out.print(GameInformation.getCurrentPlayerMap()[i][j].getLandType().getMapId() + " ");
            }
            System.out.println();
        }
    }

    public void moving(Matcher matcher) {
        int x = 0, y = 0;
        for (int i = 0; i < matcher.groupCount(); i++) {
            if (matcher.group(i) == null)
                continue;
            if (matcher.group(i).equals("right"))
                x = Integer.parseInt(matcher.group(i + 1));
            else if (matcher.group(i).equals("left"))
                x = -Integer.parseInt(matcher.group(i + 1));
            else if (matcher.group(i).equals("up"))
                y = Integer.parseInt(matcher.group(i + 1));
            else if (matcher.group(i).equals("down"))
                y = -Integer.parseInt(matcher.group(i + 1));
            showMap(xStart + x, yStart + y);
        }
    }

    public String showDetails(Matcher matcher) {
        int x = 0, y = 0 , landTypeCounter = 0;
        Tile currentTile = currentUserMap[x][y];
        String answer = "LandType : ";
        for(int i=0 ; i< currentUserMap.length ; i++)
        {
            for(int j=0 ; j< currentUserMap.length ; j++){
                if(currentUserMap[i][j].getLandType().equals(currentTile.getLandType()))
                    landTypeCounter ++;

            }
        }
        answer = answer.concat(currentTile.getLandType().values().toString() +
                "number of tiles with this landtype on map : " + String.valueOf(landTypeCounter));
        if (currentTile.getBuilding() != null)
            answer = answer.concat("\n" + "Building(s): " + currentTile.getBuilding().getName().toString());
        if (currentTile.getSoldier() != null) {
            answer = answer.concat("\n" + "Soldier(s) : " + currentTile.getSoldier().values().toString() +
                    "\n" + "number of soldiers: " + String.valueOf(currentTile.getNumberOfSoldiers()));
        }

        return answer;
    }
}





