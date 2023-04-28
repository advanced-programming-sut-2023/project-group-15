package org.example.controller;

import org.example.model.Tile;
import org.example.model.User;
import org.example.view.enums.outputs.GameMenuOutput;
import org.example.model.gameData.Map;
import java.util.ArrayList;

public class GameMenuController {

    public int foodrate(){
       return 1;
    }

    public int taxRate(){
        return 2;
    }

    public void setFoodRate(int rate){
        //return 1;
    }

    public void setTaxRate(int rate){
        //TODO: set rate in goverment
    }

    public void setFearRate(int rate){
        //TODO: set rate in goverment
    }

    public void foodList(){
        //TODO: get list from goverment
    }

    public int popularity(int rate){
        return 1;
    }
        private void setTexture(int x , int y,String type)
        {

        }
        private void setTexture(int x1, int y1,int x2, int y2,String type)
        {

        }
        private void clear(int x , int y)
        {
            Tile currentTile = Map.findATile(x,y);
            currentTile.setBuilding(null);
            currentTile.setTreeName(null);
            currentTile.setSoldier(null);
            currentTile.setRock(false);
        }
        private void dropUnit(int x , int y, String type)
        {

        }
        private void dropBuilding(int x , int y)
        {

        }
        private void dropTree(int x , int y, String type)
        {

        }
        private void dropRock(int x , int y , char direction)
        {

        }


    }

   /* public ArrayList factors(){
        //TODO: get list of factors from goverment
    }*/

