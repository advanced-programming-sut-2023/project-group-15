package org.example.model.gameData;

import org.example.model.MBC.Soldier;
import org.example.model.Tile;
import org.example.model.User;
import org.example.model.building.Building;
import org.example.model.enums.*;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class GameInformation {
    private static int mapGameSize;
    private final static Tile[][] gameMap = new Tile[200][200];
    private final static ArrayList<User> allPlayers = new ArrayList<>();
    public static ArrayList<User> getAllPlayers() {
        return allPlayers;
    }
    public static Tile[][] getGameMap() {
        return gameMap;
    }
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

    public static void setMapGame(int mapGame, String path) {
        try {
            String contents = new String((Files.readAllBytes(Paths.get(path))));
            JSONTokener jsonParser = new JSONTokener(contents);
            JSONObject jsonobject = new JSONObject(jsonParser);
            while (!jsonParser.end()) {
                for (int i = 0; i < mapGame; i++) {
                    for (int j = 0; j < mapGame; j++) {
                        LandType landType = LandType.getLandType(String.valueOf(jsonobject.get("Land: ")));
                        gameMap[i][j] = new Tile(null,landType,0,null,null,false,null);
                        jsonParser.next();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addPlayer(User player) {
        allPlayers.add(player);
    }

    public static int getCurrentPlayerNo() {
        return currentPlayerNo;

    }

    public static void setCurrentUserNo(int currentUserno) {
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

    public static boolean checkPlayer(String playerToBeAdded) {
        for (User user:GameDataBase.getAllUsers()) {
            if (user.getUsername().equals(playerToBeAdded))
                return true;
        }
        return false;
    }

    public static boolean checkPlayerExist(String playerToBeAdded) {
        for (User user:GameDataBase.getAllUsers()) {
            if (user.getUsername().equals(playerToBeAdded)) {
                return allPlayers.contains(user);
            }
        }
        return false;
    }
}