package org.example.controller;

import org.example.model.Tile;
import org.example.model.User;
import org.example.model.enums.FilePaths;
import org.example.model.gameData.GameInformation;

public class GameInformationController {
    public void setMap(int mapSize, int mapNumber) {
        String filePath = "d:/Map/";
        switch (mapNumber) {
            case (1):
                filePath = FilePaths.MAP1.getFilePaths();
                break;
            case (2):
                filePath = FilePaths.Map2.getFilePaths();
                break;
            case (3):
                filePath = FilePaths.Map3.getFilePaths();
                break;
            case (4):
                filePath = FilePaths.Map4.getFilePaths();
                break;
        }
        GameInformation.setMapGame(mapSize,filePath);
    }

    public void generateEachPlayerMap(int mapSize) {
        int playerNumber = GameInformation.getCurrentPlayerNo();
        Tile[][] playerMap = new Tile[mapSize / 2][];
        if (playerNumber <= 4) {
            for (int i = 0; i < mapSize / 2; i++) {
                for (int j = 0; j < mapSize / 4; j++)
                    playerMap[i][j] = GameInformation.getGameMap()[i][(playerNumber - 1) * mapSize / 4];
            }
        } else {
            for (int i = 0; i < mapSize / 2; i++) {
                for (int j = 0; j < mapSize / 4; j++) {
                    playerMap[i][j] = GameInformation.getGameMap()[i + mapSize / 2][((playerNumber % 4) - 1) * mapSize / 4];
                }
            }
        }
        GameInformation.getCurrentPlayer().setMap(playerMap);
    }
}
