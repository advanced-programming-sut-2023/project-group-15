package org.example.controller;
import org.example.model.gameData.Map;
import org.example.model.Tile;
import org.example.view.MapMenu;

import java.util.regex.Matcher;

public class MapMenuController {

    int xStart = 0 ;
    int yStart = 0 ;
    public MapMenuController() {
    }
    public void setStartingPoint(int x , int y)
    {
        this.xStart =  x ;
        this.yStart = y ;
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
    public void moving(Matcher matcher) {
        int x=0 , y=0 ;

       /* if (hor.equals("left"))
            x = -x;
        if(ver.equals("down"))
            y = -y;
        xStart += x ;
        yStart += y ;
        showMap(xStart , yStart);*/
    }

    public String showDetails(int x , int y) {
        Tile currentTile = Map.findATile(x , y);
        String answer = "LandType : " ;
        answer = answer.concat(currentTile.getLandType().values().toString());
        if (currentTile.getBuilding() != null) {
            answer = answer.concat("\n" +currentTile.getBuilding().getName().toString());
            //TODO soldiers should be added to the string
        }
        return answer ;
    }

}




