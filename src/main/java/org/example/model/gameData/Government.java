package org.example.model.gameData;

import org.example.model.enums.Products;

import java.util.ArrayList;
import java.util.HashMap;


public class Government {
        private static int popularity;
       private static int foodRate;
       private static  int taxRate;
        private static int fearRate;
        private static HashMap<Products , Double> foods = new HashMap<>();
        public void showPopularityFactors()
        {
            System.out.print("1.food\n2.tax\n3.religion\n4.fear");
        }

        public void setFoodRate(int foodRate) {
            foodRate = foodRate;
            switch (foodRate)
            {
                case(-2):
                    popularity -= 8;
                    break;
                case(-1):
                    popularity -= 4;
                    break;
                case(1):
                    popularity += 4 ;
                    break;
                case(2):
                    popularity += 8 ;
                    break;
            }
        }

        public void setPopularity(int popularity) {
            popularity = popularity;
        }
        public static void setTaxrate(int taxrate) {
            taxRate = taxrate;
            switch (taxRate) {
                case (-3):
                    popularity += 7;
                    break;
                case(-2):
                    popularity += 5;
                    break;
                case(-1):
                    popularity += 3;
                    break;
                case(0):
                    popularity += 1;
                    break;
                case(1):
                    popularity -= 2;
                    break;
                case(2):
                    popularity -= 4;
                    break;
                case(3):
                    popularity -= 6;
                    break;
                case(4):
                    popularity -= 8;
                    break;
                case(5):
                    popularity -= 12;
                    break;
                case(6):
                    popularity -= 16;
                    break;
                case(7):
                    popularity -= 20;
                    break;
                case(8):
                    popularity -= 24 ;
                    break;
            }

        }

        public void setFearRate(int fearRate) {
            this.fearRate = fearRate;
        }
        public void addFood(Products food , double  amount) {
            foods.put(food , amount);
        }

        public static int getTaxrate() {
            return taxRate;
        }

    public static int getFoodRate() {
        return foodRate;
    }

    public static int getPopularity() {
        return popularity;
    }

    public static int getTaxRate() {
        return taxRate;
    }

    public static int getFearRate() {
        return fearRate;
    }

    public static HashMap<Products, Double> getFoods() {
        return foods;
    }
}
