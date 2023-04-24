package org.example.controller;
import org.example.model.gameData.Map;
import org.example.model.Tile;

public class MapMenuController {
    public MapMenuController() {
    }

    public void showMap(int x, int y) {
        Tile currentTile = Map.getCurrentMap()[x][y];
        Tile[][] mapToShow = new Tile[11][11];
        int xS = x - 5;  // x startpoint
        int xE = x + 5;  // x endpoint
        if (xS < 0) {
            xE += -xS;
            xS = 0;
        }
        if (xE > 199) {
            xS -= xE - 199;
            xE = 199;
        }
        int yS = y - 5;  // y startpoint
        int yE = y + 5;  // y endpoint
        if (yS < 0) {
            yE += -yS;
            yS = 0;
        }
        if (yE > 199) {
            yS -= yE - 199;
            yE = 199;
        }

        for (int i = xS; i < xE; i++) {
            for (int j = yS; j < yE; j++) {
                if (Map.getCurrentMap()[i][j].getSoldier() != null) {
                    System.out.print("S ");
                    continue;
                } else if (Map.getCurrentMap()[i][j].getBuilding() != null) {
                    System.out.print("B ");
                    continue;
                } else
                    System.out.print(Map.getCurrentMap()[i][j].getLandType().getMapId() + " ");
            }
            System.out.println();

        }


    }

    private String showDetails(int x , int y) {
        String answer = "LandType : " ;
        answer = answer.concat(Map.getCurrentMap()[x][y].getLandType().values().toString());
        if (Map.getCurrentMap()[x][y].getBuilding() == null) {
            //answer = answer.concat("\n" + map.getCurrentMap()[x][y].getBuilding().get().toString());
        }
        return answer ;
    }
}




