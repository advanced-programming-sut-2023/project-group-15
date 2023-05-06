package org.example.controller;

import org.example.model.User;
import org.example.view.enums.outputs.GameMenuOutput;

import java.util.ArrayList;

public class GameMenuController {

    public int foodRate(){
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

   /* public ArrayList factors(){
        //TODO: get list of factors from goverment
    }*/


}
