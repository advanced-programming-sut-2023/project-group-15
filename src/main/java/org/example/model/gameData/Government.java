package org.example.model.gameData;

import org.example.model.enums.Products;

import java.util.ArrayList;


    public class Government {
        int popularity;
        int foodRate;
        int taxrate;
        ArrayList<Products> foods = new ArrayList<>();

        public void setFoodRate(int foodRate) {
            //TODO foodrate should be changed based on numbers of food on the foodlist
        }
    }
