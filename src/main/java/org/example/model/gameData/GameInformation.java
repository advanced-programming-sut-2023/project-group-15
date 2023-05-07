package org.example.model.gameData;

import org.example.model.Tile;
import org.example.model.User;
<<<<<<< HEAD
import org.example.view.enums.commands.GameMenuEnum;

import java.util.ArrayList;
=======
import org.example.model.building.Building;
import org.example.model.building.BuildingName;
import org.example.model.enums.LandType;
import org.example.model.enums.Tree;
import org.example.model.enums.UnitName;
import org.example.view.enums.commands.GameMenuEnum;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
>>>>>>> 5b2d190069a17219a3b79b0ff745eb8211fc2fd1

public class GameInformation {
    private static int mapGameSize;
    private  static Tile[][] gameMap;
<<<<<<< HEAD

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

=======
    private static HashMap<User,Integer> players = new HashMap<User,Integer>();
    private static int currentUserno;

    public GameInformation(int mapGameSize) {
        mapGameSize = mapGameSize;
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
                        LandType landType = LandType.getLandType(String.valueOf(jsonobject.get("LAND:")));
                        BuildingName buildingName = BuildingName.getBuildingByName(String.valueOf(jsonobject.get("building:")));
                        Tree tree = Tree.getTree(String.valueOf(jsonobject.get("Tree:")));
                        UnitName unitName = UnitName.getUnitName(String.valueOf("Soldier"));
                        int numberOfSoldires = Integer.parseInt(String.valueOf(jsonobject.get("numberOfSoldiers")));
                        boolean Rock = Boolean.valueOf(String.valueOf(jsonobject.get("ROCK")));
                        String rockDirection = String.valueOf(jsonobject.get("Rockdirection:"));
                        jsonobject = new JSONObject(jsonParser);
                        gameMap[i][j] = new Tile(buildingName,landType,numberOfSoldires,unitName,tree,Rock,rockDirection);
                        jsonParser.next();
                    }
                }


            }
            // }catch(JSONException e){
            //System.out.println(e);
            //}
        }catch(IOException e){
            e.printStackTrace();
        }
    }


    public static Tile[][] getGameMap(){
        return gameMap;
    }
    public static void addPlayer(User player , int number)
    {
        players.put(player,number);
    }

    public static int getCurrentUserno() {
        return  currentUserno;

    }

    public static  void setCurrentUserno(int currentUserno) {
        currentUserno = currentUserno;
    }
>>>>>>> 5b2d190069a17219a3b79b0ff745eb8211fc2fd1
    //TODO turn methods should be added hear


}
