package org.example.model.gameData;

import org.example.model.enums.Products;

import java.util.ArrayList;


    public class Government {
        int popularity;
        int foodRate;
        int taxRate;
        int fearRate;
        //ArrayList<products> foods = new ArrayList<>();
        ArrayList<Products> foods = new ArrayList<>();

        public void setFoodRate(int foodRate) {

            //TODO foodrate should be changed based on numbers of food on the foodlist
        }

        public void setPopularity(int popularity) {
            // TODO : the popularity should be set here by the user
            this.popularity = popularity;
        }

        public void setTaxrate(int taxRate) {
            // TODO : the taxrate should be
            this.taxRate = taxRate;
        }

        public void setFearRate(int fearRate) {
            this.fearRate = fearRate;
        }

        public void addFood(Products food) {
            this.foods.add(food);
        }

        public ArrayList<Products> getFoods() {
            //TODO the food list is going to be shown here
            return foods;
        }

        public void showPopularityRates()
        {

        }
        public void showPopularity()
        {

        }

        public int getTaxRate() {
            //TODO show tax rate here
            return taxRate;
        }
    }
