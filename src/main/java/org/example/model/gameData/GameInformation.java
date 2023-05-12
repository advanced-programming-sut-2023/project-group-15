package org.example.model.gameData;

import org.example.controller.MapMenuEnvironmentController;
import org.example.model.MBC.Soldier;
import org.example.model.Tile;
import org.example.model.User;
import org.example.model.building.Building;
import org.example.model.building.Storage;
import org.example.model.enums.*;
import org.example.view.enums.outputs.GameInformationOutput;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class GameInformation {
    private static int mapGameSize;
    private static Tile[][] gameMap;
    private static User currentPlayer;
    private static final HashMap<User, Integer> players = new HashMap<>();
    private static int currentPlayerNo = 1;
    private int currentPlayerTurn;
    private int gameTurn;
    private int numberOfPlayers;
    private static ArrayList<Soldier> allSoldiers = new ArrayList<>();
    private static ArrayList<Building> allBuildings = new ArrayList<>();

    public GameInformation(int mapGameSize) {
        mapGameSize = mapGameSize;
    }

    public static void setMapGame(int mapGame, int mapNumber, String path) {
        try {
            String contents = new String((Files.readAllBytes(Paths.get(path))));
            JSONTokener jsonParser = new JSONTokener(contents);
            JSONObject jsonobject = new JSONObject(jsonParser);
            //try{
            while (!jsonParser.end()) {
                for (int i = 0; i < mapGame; i++) {
                    for (int j = 0; j < mapGame; j++) {
                        LandType landType = LandType.getLandType(String.valueOf(jsonobject.get("LAND:")));
                        //BuildingName buildingName = BuildingName.getBuildingByName(String.valueOf(jsonobject.get("building:")));
                        Tree tree = Tree.getTree(String.valueOf(jsonobject.get("Tree:")));
                        UnitName unitName = UnitName.getUnitType(String.valueOf("Soldier"));
                        int numberOfSoldires = Integer.parseInt(String.valueOf(jsonobject.get("numberOfSoldiers")));
                        boolean Rock = Boolean.valueOf(String.valueOf(jsonobject.get("ROCK")));
                        String rockDirection = String.valueOf(jsonobject.get("Rockdirection:"));
                        jsonobject = new JSONObject(jsonParser);
                        Direction direction = MapMenuEnvironmentController.findDirection(rockDirection);
                        //  gameMap[i][j] = new Tile(build,landType,numberOfSoldires,unitName,tree,Rock,direction);
                        jsonParser.next();
                        //TODO reading map from file
                    }
                }

            }
            // }catch(JSONException e){
            //System.out.println(e);
            //}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   /*public static void turnCounter()
    {
        getCurrentPlayer().getTurn()

    }*/


    public static Tile[][] getGameMap() {
        return gameMap;
    }

    public static void addPlayer(User player, int number) {
        players.put(player, number);
    }

    public static int getCurrentPlayerno() {
        return currentPlayerNo;

    }

    public static void setCurrentUserno(int currentUserno) {
        currentUserno = currentUserno;
    }

    public static User getCurrentPlayer() {
        return currentPlayer;
    }

    public static void setCurrentPlayer(User currentPlayer) {
        GameInformation.currentPlayer = currentPlayer;
    }

    public static Tile[][] getCurrentPlayerMap() {
        return GameInformation.getCurrentPlayer().getMap();
    }

    public static Building findBuilding(String name, User user) {
        for (int i = 0; i < user.getMap().length; i++) {
            for (int j = 0; j < user.getMap()[0].length; j++) {
                if (GameInformation.getCurrentPlayerMap()[i][j].getBuilding().getName()
                        .equals(name))
                    return GameInformation.getCurrentPlayerMap()[i][j].getBuilding();
            }
        }
        return null;
    }

    public static String checkForSources(Products product, int amount) {
        int current;
        Storage store = null;
        /*for(StoreProducts storeProduct : StoreProducts.values()) {
            if (String.valueOf(product).equals(String.valueOf(storeProduct))) {
                store = (Storage) GameInformation.findBuilding(String.valueOf(storeProduct.getStoreType()) , );
            }
        }*/
        if (store.getGoods().containsKey(product) && store.getGoods().get(product) >= amount) {
            current = store.getGoods().get(product);
            store.getGoods().remove(product);
            store.getGoods().put(product, current - amount);
            return GameInformationOutput.SUCCESS.getOutput();
        }
        return GameInformationOutput.NOT_ENOUGH.getOutput();
        //TODO change the return type to enum
    }

    public static Government getCurrentPlayerGovernment() {
        return currentPlayer.getGovernment();
    }
    //TODO turn methods should be added hear


    public static HashMap<User, Integer> getPlayers() {
        return players;
    }

    public static ArrayList<Soldier> getAllSoldiers() {
        return allSoldiers;
    }

    public static ArrayList<Building> getAllBuildings() {
        return allBuildings;
    }
}