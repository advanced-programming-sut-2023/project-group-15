package org.example.model.gameData;

import org.example.model.enums.products;

import java.util.ArrayList;


    public class Government {
        int popularity;
        int foodRate;
        int taxrate;
        ArrayList<products> foods = new ArrayList<>();

        public void setFoodRate(int foodRate) {
            //TODO foodrate should be changed based on numbers of food on the foodlist
        }

        public void setPopularity(int popularity) {
            this.popularity = popularity;
        }

        public void setTaxrate(int taxrate) {
            this.taxrate = taxrate;
        }

        public void addFood(products food) {
            this.foods.add(food);
        }
    }
