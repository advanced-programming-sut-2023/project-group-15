package org.example.model.gameData;

import org.example.model.enums.Food;

import java.util.ArrayList;
import java.util.HashMap;


public class Government {
        public int popularity;
       private int foodRate;
       private int taxRate;
        private static int fearRate;
        public double coins;
        private static HashMap<String , Double> foods = new HashMap<>();


    public void foodList(){
        foods.put("Apple" , 0.00);
        foods.put("Hop" , 0.00);
        foods.put("Bread" , 0.00);
        foods.put("Cheese" , 0.00);
    }
    public void setCoins(double coins) {
       this.coins = coins;
       Double zero = 0.00;
       if(Double.compare(getCoins() , zero) == 0)
           setTaxrate(0);
    }

    public double getCoins() {
        return this.coins;
    }

   /* public void setFoodRate(int foodRate) {
            foodRate = foodRate;
            switch (foodRate)
            {
                case(-2):
                    this.popularity -= 8;
                case(-1):
                    this.popularity -= 4;
                case(1):
                    this.popularity += 4 ;
                case(2):
                    this.popularity += 8 ;

            }
        } */

        public void setPopularity(int popularity) {
            this.popularity = popularity;
        }

        public void setTaxrate(int taxrate) {
            this.taxRate = taxrate;
            switch (this.taxRate) {
                case -3:
                    this.popularity += 7;
                    break;
                case -2:
                    this.popularity += 5;
                    break;
                case -1:
                   this.popularity += 3;
                   break;
                case 0:
                    this.popularity += 1;
                    break;
                case 1:
                   this.popularity -= 2;
                   break;
                case 2:
                    this.popularity -= 4;
                    break;
                case 3:
                    this.popularity -= 6;
                    break;
                case 4:
                    this.popularity -= 8;
                    break;
                case 5:
                    this.popularity -= 12;
                    break;
                case 6:
                    this.popularity -= 16;
                    break;
                case 7:
                    this.popularity -= 20;
                    break;
                case 8:
                    this.popularity -= 24 ;
                    break;


            }

        }

        public void setFearRate(int fearRate) {

            this.fearRate = fearRate;
        }

        public void addFood(String food , double  amount) {
            foods.put(food , amount);
        }

        public int getTaxrate() {
            return this.taxRate;
        }

    public int getFoodRate() {
        return this.foodRate;
    }

    public int getPopularity() {
        return this.popularity;
    }

    public int getTaxRate() {
        return taxRate;
    }

    public static int getFearRate() {
        return fearRate;
    }

    public void setFoodRate(int rate){
         this.foodRate = rate;
    }
    public HashMap<String, Double> getFoods() {
        return foods;
    }

    public void changeFoodGivingPeople(double number){
        foods.replaceAll( (k,v)->v-=number);
    }

    public int checkFoodVariety(){
            int varity = 0 ;
            double zero = 0.00;
            if(Double.compare(foods.get("Apple") , zero) != 0)
                ++varity;
            if(Double.compare(foods.get("Hop") , zero) != 0)
                ++varity;
            if(Double.compare(foods.get("Bread") , zero) != 0)
                ++varity;
        if(Double.compare(foods.get("Cheese") , zero) != 0)
                ++varity;

        switch (varity){
            case 4:
                return 3;
            case 3:
                return 2;
            case 2:
                return 1;
            case 0:
                return 0;
            default:
                return 0;
        }
    }
}
