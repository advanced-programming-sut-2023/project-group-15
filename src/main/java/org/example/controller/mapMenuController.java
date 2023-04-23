package org.example.controller;
import org.example.model.map;
import org.example.model.tile;

public class mapMenuController {
    public mapMenuController() {
    }

    public void showMap(int x, int y) {
        tile currentTile = map.getCurrentMap()[x][y];
        tile[][] mapToShow = new tile[11][11];
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
                if (map.getCurrentMap()[i][j].getSoldier() != null) {
                    System.out.println("S");
                    continue;
                } else if (map.getCurrentMap()[i][j].getBuilding() != null) {
                    System.out.println("B");
                    continue;
                } else
                    System.out.println(map.getCurrentMap()[i][j].getLandType().getMapId());
            }

        }


    }

    private String showDetails(int x , int y) {
        String answer = "LandType : " ;
        answer = answer.concat(map.getCurrentMap()[x][y].getLandType().values().toString());
        if (map.getCurrentMap()[x][y].getBuilding() == null) {
            //answer = answer.concat("\n" + map.getCurrentMap()[x][y].getBuilding().get().toString());
        }
        return answer ;
    }
}




