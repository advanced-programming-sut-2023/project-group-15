//this class is completed!
package org.example.controller;

import org.example.model.Tile;
import org.example.model.User;
import org.example.model.enums.FilePaths;
import org.example.Server.gameData.GameInformation;

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
        GameInformation.setMapGame(mapSize, filePath);
    }

    public void generateEachPlayerMap(User player, int mapSize) {
        int playerNumber = player.getUserNO();
        int i = 0;
        int j = findJStart(playerNumber,mapSize);
        int iFactor = mapSize / 2;
        int jFactor = mapSize / 4;
        Tile[][] playerMap = new Tile[iFactor][jFactor];
        if (playerNumber % 2 == 0) {
            i += iFactor;
        }
        int iCondition = iFactor + i;
        int jCondition = jFactor + j;
        int playerMapXCoordinate = 0;
        int playerMapYCoordinate;
        for (int i1 = i;i1<iCondition;i1++) {
            playerMapYCoordinate = 0;
            for (int j1 = j ;j1 < jCondition ; j1++) {
                playerMap[playerMapXCoordinate][playerMapYCoordinate] = GameInformation.getGameMap()[i1][j1];
                playerMapYCoordinate ++;
            }
            playerMapXCoordinate ++ ;
        }
        player.setMap(playerMap);
    }

    private int findJStart(int playerNum,int mapSize) {
        int jFactor = mapSize / 4 ;
        if (playerNum<3) {
            return 0;
        } else if (playerNum<5) {
            return jFactor ;
        } else if (playerNum<7) {
            return (jFactor*2);
        } else if (playerNum<9) {
            return (jFactor*3);
        } else return 0;
    }
}
