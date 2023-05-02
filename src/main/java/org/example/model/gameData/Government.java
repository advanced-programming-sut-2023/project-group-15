package org.example.model.gameData;

import org.example.model.enums.Products;

import java.util.ArrayList;


    public class Government {
        int popularity;
        int foodRate;
        int taxRate;
        int fearRate;
        ArrayList<Products> foods = new ArrayList<>();

        public void setFoodRate(int foodRate) {

            //TODO foodrate should be changed based on numbers of food on the foodlist
        }

        public void setPopularity(int popularity) {
            // TODO : the popularity should be set here by the user
            this.popularity = popularity;
        }

        public void setTaxrate(int taxrate) {
            // TODO : the taxrate should be
            this.taxRate = taxrate;
        }

        public void setFeaRate(int fearrate) {

            this.fearRate = fearrate;
        }

        public void addFood(Products food) {
            this.foods.add(food);
        }

        public static ArrayList<Products> getFoods() {
            //TODO the food list is going to be shown here
            return foods;
        }

        public void showPopularityRates()
        {

        }
        public void showPopularity()
        {

        }

        public int getTaxrate() {
            //TODO show tax rate here
            return taxrate;
        }
    }
