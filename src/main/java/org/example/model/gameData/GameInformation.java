package org.example.model.gameData;

import org.example.model.Tile;
import org.example.model.User;
import org.example.model.building.Building;
import org.example.model.enums.LandType;
import org.example.view.enums.commands.GameMenuEnum;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GameInformation {
    private static int mapGameSize;
    private  static Tile[][] gameMap;

    public GameInformation(int map ) {
        mapGameSize = map;
    }

    public static void setMapGame(int mapGame,int mapNumber, String path) {
        try {
            String contents = new String((Files.readAllBytes(Paths.get(path))));
            JSONTokener jsonParser = new JSONTokener(contents);
            JSONObject jsonobject=new JSONObject(jsonParser);
            //try{
            while(!jsonParser.end()) {
                for(int i=0 ; i<mapGame ; i++) {
                    for (int j = 0; j < mapGame; j++) {
                        LandType landType = LandType.getLandType(String.valueOf(jsonobject.get("LAND")));



                        jsonobject = new JSONObject(jsonParser);
                        gameMap[i][j] = new Tile();
                    }
                }

                System.out.println(jsonobject);
                jsonParser.next();
            }
            // }catch(JSONException e){
            //System.out.println(e);
            //}
        }catch(IOException e){
            e.printStackTrace();
        }
    }
        //TODO read the map from the file and set the map

    public static Tile[][] getGameMap(){
        return gameMap;
    }

    //TODO turn methods should be added hear


}
