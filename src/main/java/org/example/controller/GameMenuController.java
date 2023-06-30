package org.example.controller;

import org.example.model.building.Building;
import org.example.model.gameData.GameInformation;
import org.example.model.gameData.Government;

import java.util.ArrayList;
import java.util.HashMap;

public class GameMenuController {
    Government government = new Government(GameInformation.getCurrentPlayer().getUsername());
    public GameMenuController() {
        // government = Government.findGovernmentWithUsername(player);

    }

    public String showFoodRate(int number) {
        String foodRate = "";
        switch (number) {
            case -2:
                foodRate += "1-set on -2,monthly your popularity decreases by 8 unit";
                break;
            case -1:
                foodRate += "0.5-set on -1,monthly your popularity decreases by 4 unit";
                break;
            case 0:
                foodRate += "1.5-set on 0,monthly your popularity increases by 0 unit";
                break;
            case 1:
                foodRate += "1.5-set on 1,monthly your popularity increases by 4 unit";
                break;
            case 2:
                foodRate += "2-set on 2,monthly your popularity increases by 8 unit";
                break;
        }
        return foodRate;
    }

    public String showTaxRate(int checkTax) {
        String taxRate = "";
        switch (checkTax) {
            case -3:
                taxRate += "0>1>set on -3,nmonthly your popularity increases by 7 unit";
                //"0 tax\nyou give people 1 coin\nmonthly your popularity increases by 7 unit";
                break;
            case -2:
                taxRate += "0>0.8>set on -2,monthly your popularity increases by 5 unit";
                //"0 tax\nyou give people 0.8 coin\nmonthly your popularity increases by 5 unit";
                break;
            case -1:
                taxRate += "0>0.6>set on -1,monthly your popularity increases by 3 unit";
                //"0 tax\nyou give people 0.6 coin\nmonthly your popularity increases by 3 unit";
                break;
            case 0:
                taxRate += "0>0>set on 0,monthly your popularity increases by 1 unit";
                //"0 tax\nyou give people 0 coin\nmonthly your popularity increases by 1 unit";
                break;
            case 1:
                taxRate += "0>0>set on 1,monthly your popularity decreases by 2 unit";
                //"0.6 tax\nyou give people 0 coin\nmonthly your popularity decreases by 2 unit";
                break;
            case 2:
                taxRate += "0>0>set on 2,monthly your popularity decreases by 4 unit";
                //"0.8 tax\nyou give people 0 coin\nmonthly your popularity decreases by 4 unit";
                break;
            case 3:
                taxRate += "1>0>set on 3,monthly your popularity decreases by 6 unit";
                //"1 tax\nyou give people 0 coin\nmonthly your popularity decreases by 6 unit";
                break;
            case 4:
                taxRate += "1/2>0>set on 4,monthly your popularity decreases by 8 unit";
                //"1/2 tax\nyou give people 0 coin\nmonthly your popularity decreases by 8 unit";
                break;
            case 5:
                taxRate += "1/4>0>set on 5,monthly your popularity decreases by 12 unit";
                //"1/4 tax\nyou give people 0 coin\nmonthly your popularity decreases by 12 unit";
                break;
            case 6:
                taxRate += "1/6>0>set on 6,monthly your popularity decreases by 16 unit";
                //"1/6 tax\nyou give people 0 coin\nmonthly your popularity decreases by 16 unit";
                break;
            case 7:
                taxRate += "1/8>0>set on 7,monthly your popularity decreases by 20 unit";
                //"1/8 tax\nyou give people 0 coin\nmonthly your popularity decreases by 20 unit";
                break;
            case 8:
                taxRate += "2>0>set on 8,monthly your popularity decreases by 24 unit";
                //"2 tax\nyou give people 0 coin\nmonthly your popularity decreases by 24 unit";
        }
        return taxRate;
    }

    public void setFoodRate(int rate) {
        if (government.checkFoodVariety() == 0)
            rate = -2;
        switch (rate) {
            case -2:
                government.setPopularity(government.getPopularity() - 8 + government.checkFoodVariety());
                government.setFoodRate(-2);
                break;
            case -1:
                government.setPopularity(government.getPopularity() - 4 + government.checkFoodVariety());
                government.changeFoodGivingPeople(0.5);
                government.setFoodRate(-1);
                break;
            case 0:
                government.changeFoodGivingPeople(1.0);
                government.setFoodRate(0);
                break;
            case 1:
                government.setPopularity(government.getPopularity() + 4 + government.checkFoodVariety());
                government.changeFoodGivingPeople(1.5);
                government.setFoodRate(1);
                break;
            case 2:
                government.setPopularity(government.getPopularity() + 8 + government.checkFoodVariety());
                government.changeFoodGivingPeople(2.0);
                government.setFoodRate(2);
                break;
        }
    }
    public void setTaxRate(int rate) {
        if (Double.compare(government.getCoins(), 0.00) == 0)
            government.setTaxRate(0);
        else {
            switch (rate) {
                case -3:
                    government.setCoins(government.getCoins() - government.getPeople());
                    government.setTaxRate(-3);
                    break;
                case -2:
                    government.setCoins(government.getCoins() - 0.8 * government.getPeople());
                    government.setTaxRate(-2);
                    break;
                case -1:
                    government.setCoins(government.getCoins() - 0.6 * government.getPeople());
                    government.setTaxRate(-1);
                    break;
                case 1:
                    government.setCoins(government.getCoins() + 0.6 * government.getPeople());
                    government.setTaxRate(1);
                    break;
                case 2:
                    government.setCoins(government.getCoins() + 0.8 * government.getPeople());
                    government.setTaxRate(2);
                    break;
                case 3:
                    government.setCoins(government.getCoins() + government.getPeople());
                    government.setTaxRate(3);
                    break;
                case 4:
                    government.setCoins(government.getCoins() + 0.5 * government.getPeople());
                    government.setTaxRate(4);
                    break;
                case 5:
                    government.setCoins(government.getCoins() + 0.25 * government.getPeople());
                    government.setTaxRate(5);
                    break;
                case 6:
                    government.setCoins(government.getCoins() + 0.17 * government.getPeople());
                    government.setTaxRate(6);
                    break;
                case 7:
                    government.setCoins(government.getCoins() + 0.13 * government.getPeople());
                    government.setTaxRate(7);
                    break;
                case 8:
                    government.setCoins(government.getCoins() + 2 * government.getPeople());
                    government.setTaxRate(8);
                    break;
            }
        }
    }

    public boolean setTaxRateCheckInput(int rate) {
        return rate <= 8 && rate >= -3;
    }

    public boolean setFearRateCheckInput(int rate) {
        return rate <= 5 && rate >= -5;
    }

    public void setFirsts(){
        government.setCoins(20.0);
        government.setPopularity(100);
    }

    public void religionAccordingToChurch() {
        int number = government.getPeople() / 4;
        government.setPopularity(government.getPopularity() + 2 * number + 1);
    }

    public void religionAccordingToCathedral() {
        int number = government.getPeople() / 4;
        government.setPopularity(government.getPopularity() + 2 * number + 2);
    }

    public void setFearRate(int rate) {
        government.setFearRate(rate);
        ArrayList<Building> building = GameInformation.getAllBuildings();
        switch (rate) {
            //TODO: add code to Increase in the production of buildings by workers
            case -5, -4, -3, -2, -1, 0:
                for (int i = 0; i != building.size(); i++) {
                    Building building1 = (Building) building.get(i);
                }
                if (government.getUnitWallTargetNumber() != 0) {
                    government.getUnitWallTarget().setAttackingPower(government.getUnitWallTarget().getAttackingPower() - 1);
                }
                if (government.getLauncherUnitNumber() != 0) {
                    government.getLauncherUnit().setThrowRange(government.getLauncherUnit().getThrowRageForCharging() - 1);
                }
                if (government.getInfantryUnitNumber() != 0) {
                    government.getInfantryUnit().setAttackingPower(government.getInfantryUnit().getAttackingPower() - 1);
                }
                break;
            case 1:
                setAttackingPowers(1);
                break;
            case 2:
                setAttackingPowers(2);
                break;
            case 3:
                setAttackingPowers(3);
                break;
            case 4:
                setAttackingPowers(4);
                break;
            case 5:
                setAttackingPowers(5);
                break;
        }
    }

    private void setAttackingPowers(int rate) {
        if (government.getUnitWallTargetNumber() != 0) {
            government.getUnitWallTarget().setAttackingPower(government.getUnitWallTarget().getAttackingPower() + rate);
        }
        if (government.getLauncherUnitNumber() != 0) {
            government.getLauncherUnit().setThrowRange(government.getLauncherUnit().getThrowRageForCharging() + rate);
        }
        if (government.getInfantryUnitNumber() != 0) {
            government.getInfantryUnit().setAttackingPower(government.getInfantryUnit().getAttackingPower() + rate);
        }
    }

    public HashMap<String, Double> foodList() {
        return government.getFoods();
    }

    public int showPopularity() {
        return government.getPopularity();
    }

    public boolean setFoodRateCheckInput(int rateFood) {
        return rateFood >= -2 && rateFood <= 2;
    }

    public void governmentStatus() {
        System.out.println("coins: " + government.getCoins());
        System.out.println("tax rate: " + government.getTaxRate());
        System.out.println("food rate: " + government.getFoodRate());
        System.out.println("fear rate: " + government.getFearRate());
        System.out.println("religion rate: " + government.getReligion());
        System.out.println("people: " + government.getPeople());
        System.out.println("workers: " + government.getWorkers());
        System.out.println("popularity: " + government.getPopularity());

    }

    public double getCoin(){
        return government.getCoins();
    }

    public int getFoodRate(){
        return government.getFoodRate();
    }

    public int getTaxRate(){
        return government.getTaxRate();
    }

    public int getFearRate(){
        return government.getFearRate();
    }
}


