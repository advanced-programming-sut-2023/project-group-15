//this class is completed!
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
    private static boolean newGameAccess = true;

    public static boolean isNewGameAccess() {
        return newGameAccess;
    }

    public static void setNewGameAccess(boolean newGameAccess) {
        GameInformation.newGameAccess = newGameAccess;
    }

    private static Tile[][] gameMap = new Tile[400][400];
    private final static ArrayList<User> allPlayers = new ArrayList<>();

    public static ArrayList<User> getAllPlayers() {
        return allPlayers;
    }

    public static Tile[][] getGameMap() {
        return gameMap;
    }

    private static User currentPlayer;
    private static final HashMap<User, Integer> players = new HashMap<>();
    private static final ArrayList<Soldier> allSoldiers = new ArrayList<>();
    private static final ArrayList<Building> allBuildings = new ArrayList<>();

    public static void setMapGame(int mapGame, String path) {
        try {
            String contents = new String((Files.readAllBytes(Paths.get(path))));
            JSONTokener jsonParser = new JSONTokener(contents);
            JSONObject jsonobject = new JSONObject(jsonParser);
            while (!jsonParser.end()) {
                for (int i = 0; i < mapGame; i++) {
                    for (int j = 0; j < mapGame; j++) {
                        LandType landType = LandType.getLandType(String.valueOf(jsonobject.get("Land: ")));
                        gameMap[i][j] = new Tile(null, landType, 0, null, null, false, null);
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
                if (user.getMap()[i][j].getBuilding().getName()
                        .equals(name))
                    return GameInformation.getCurrentPlayerMap()[i][j].getBuilding();
            }
        }
        return null;
    }




        public static HashMap<User, Integer> getPlayers() {
        return players;
    }

    public static ArrayList<Soldier> getAllSoldiers() {
        return allSoldiers;
    }

    public static ArrayList<Building> getAllBuildings() {
        return allBuildings;
    }

    public static boolean checkPlayerExist(String playerToBeAdded) {
        for (User user : GameDataBase.getAllUsers()) {
            if (user.getUsername().equals(playerToBeAdded)) {
                return true;
            }
        }
        return false;
    }

    public static void setLandType(int x,int y,LandType landType) {
        gameMap[x][y].setLandType(landType);
    }

    public static void setTree(int x, int y, Tree tree) {
        gameMap[x][y].setTree(tree);
    }

    public static void setBuilding(int x, int y, Building building) {
        gameMap[x][y].setBuilding(building);
    }

    public static void setRock(int x, int y, boolean isRock,Direction direction) {
        gameMap[x][y].setRock(isRock,direction);
    }

    public static void setSoldier(int x, int y, Soldier soldier) {
        gameMap[x][y].setSoldier(soldier);
    }
}