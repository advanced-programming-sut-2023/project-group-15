package org.example.controller;

import org.example.model.User;
import org.example.model.enums.FilePaths;
import org.example.model.gameData.GameDataBase;
import org.example.model.User;
import org.example.model.enums.FilePaths;
import org.example.model.gameData.GameInformation;

public class GameInformationController {
    public void setMap(int mapSize,int mapNumber)
    {
        String filePath = new String();
        switch (mapNumber) {
            case (1):
                filePath = FilePaths.MAP1.getFilePaths();
                break;
            case(2):
                filePath = FilePaths.Map2.getFilePaths();
                break;
            case(3):
                filePath = FilePaths.Map3.getFilePaths();
            case(4):
                filePath = FilePaths.Map4.getFilePaths();
        }

        GameInformation.setMapGame(mapSize,mapNumber,filePath);
    }
    public void playerAdder(User player)
    {
        int playerNO = GameInformation.getCurrentUserno();
        GameInformation.addPlayer(player,playerNO);
        playerNO ++;
        GameInformation.setCurrentUserno(playerNO);
    }
}
