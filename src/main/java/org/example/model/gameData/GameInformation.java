package org.example.model.gameData;

import org.example.model.Tile;
import org.example.model.User;
import org.example.view.enums.commands.GameMenuEnum;

import java.util.ArrayList;

public class GameInformation {
    private static int mapGameSize;
    private  static Tile[][] gameMap;

    public GameInformation(int map ) {
        mapGameSize = map;
    }

    public static void setMapGame(int mapGame,int mapNumber) {
        GameInformation.mapGameSize = mapGameSize;
        //TODO read the map from the file and set the map
    }
    public static Tile[][] getGameMap(){
        return gameMap;
    }

    //TODO turn methods should be added hear


}
