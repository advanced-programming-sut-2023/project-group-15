package org.example.controller;

import org.example.model.MBC.*;
import org.example.model.building.Building;
import org.example.model.gameData.GameInformation;
import org.example.model.gameData.Government;

import java.util.ArrayList;
import java.util.HashMap;

public class GameMenuController {

    Government government;
    People people;
    InfantryUnit infantryUnit;
    LauncherUnit launcherUnit;
    UnitWallTarget unitWallTarget;
    Worker worker;

    public GameMenuController() {
        government = new Government();
        people = new People(50);
    }

    public String showFoodRate() {
        String foodRate = "your food rate is " + government.getFoodRate() + "\nmeans:\n";
        switch (government.getFoodRate()) {
            case -2:
                foodRate += "you feed people 1 unit\nmonthly your popularity decreases by 8 unit";
                break;
            case -1:
                foodRate += "you feed people 0.5 unit\nmonthly your popularity decreases by 4 unit";
                break;
            case 0:
                foodRate += "you feed people 1.5 unit\nmonthly your popularity increases by 0 unit";
                break;
            case 1:
                foodRate += "you feed people 1.5 unit\nmonthly your popularity increases by 4 unit";
                break;
            case 2:
                foodRate += "you feed people 2 units\nmonthly your popularity increases by 8 unit";
                break;
        }
        return foodRate;
    }

    public String taxRate() {
        String taxRate = "your tax rate is " + government.getTaxRate() + "\nmeans:\n";

        switch (government.getTaxRate()) {
            case -3:
                taxRate += "0 tax\nyou give people 1 coin\nmonthly your popularity increases by 7 unit";
                break;
            case -2:
                taxRate += "0 tax\nyou give people 0.8 coin\nmonthly your popularity increases by 5 unit";
                break;
            case -1:
                taxRate += "0 tax\nyou give people 0.6 coin\nmonthly your popularity increases by 3 unit";
                break;
            case 0:
                taxRate += "0 tax\nyou give people 0 coin\nmonthly your popularity increases by 1 unit";
                break;
            case 1:
                taxRate += "0.6 tax\nyou give people 0 coin\nmonthly your popularity decreases by 2 unit";
                break;
            case 2:
                taxRate += "0.8 tax\nyou give people 0 coin\nmonthly your popularity decreases by 4 unit";
                break;
            case 3:
                taxRate += "1 tax\nyou give people 0 coin\nmonthly your popularity decreases by 6 unit";
                break;
            case 4:
                taxRate += "1/2 tax\nyou give people 0 coin\nmonthly your popularity decreases by 8 unit";
                break;
            case 5:
                taxRate += "1/4 tax\nyou give people 0 coin\nmonthly your popularity decreases by 12 unit";
                break;
            case 6:
                taxRate += "1/6 tax\nyou give people 0 coin\nmonthly your popularity decreases by 16 unit";
                break;
            case 7:
                taxRate += "1/8 tax\nyou give people 0 coin\nmonthly your popularity decreases by 20 unit";
                break;
            case 8:
                taxRate += "2 tax\nyou give people 0 coin\nmonthly your popularity decreases by 24 unit";
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

        double zero = 0.00;
        if (Double.compare(government.getCoins(), zero) == 0)
            rate = 0;
        switch (rate) {
            case -3:
                government.setCoins(government.getCoins() - people.getPeopleNumber());
                government.setTaxRate(-3);
                break;
            case -2:
                government.setCoins(government.getCoins() - 0.8 * people.getPeopleNumber());
                government.setTaxRate(-2);
                break;
            case -1:
                government.setCoins(government.getCoins() - 0.6 * people.getPeopleNumber());
                government.setTaxRate(-1);
                break;
            case 1:
                government.setCoins(government.getCoins() + 0.6 * people.getPeopleNumber());
                government.setTaxRate(1);
                break;
            case 2:
                government.setCoins(government.getCoins() + 0.8 * people.getPeopleNumber());
                government.setTaxRate(2);
                break;
            case 3:
                government.setCoins(government.getCoins() + people.getPeopleNumber());
                government.setTaxRate(3);
                break;
            case 4:
                government.setCoins(government.getCoins() + 0.5 * people.getPeopleNumber());
                government.setTaxRate(4);
                break;
            case 5:
                government.setCoins(government.getCoins() + 0.25 * people.getPeopleNumber());
                government.setTaxRate(5);
                break;
            case 6:
                government.setCoins(government.getCoins() + 0.17 * people.getPeopleNumber());
                government.setTaxRate(6);
                break;
            case 7:
                government.setCoins(government.getCoins() + 0.13 * people.getPeopleNumber());
                government.setTaxRate(7);
                break;
            case 8:
                government.setCoins(government.getCoins() + 2 * people.getPeopleNumber());
                government.setTaxRate(8);
                break;
        }
    }

    public void religionAccordingToChurch() {
        int number = people.getPeopleNumber() / 4;
        government.setPopularity(government.getPopularity() + 2 * number + 1);
    }

    public void religionAccordingToCathedral() {
        int number = people.getPeopleNumber() / 4;
        government.setPopularity(government.getPopularity() + 2 * number + 2);
    }

    public void setFearRate(int rate) {
        government.setFearRate(rate);
        ArrayList building = GameInformation.getAllBuildings();
        switch (rate) {
            //TODO: add code to Increase in the production of buildings by workers
            case -5, -4, -3, -2, -1, 0:
                for (int i = 0; i != building.size(); i++) {
                    Building building1 = (Building) building.get(i);
                }
                unitWallTarget.setAttackingPower(unitWallTarget.getAttackingPower() - 1);
                launcherUnit.setThrowRange(launcherUnit.getThrowRageForChanging() - 1);
                infantryUnit.setAttackingPower(infantryUnit.getAttackingPower() - 1);
                break;
            case 1:
                unitWallTarget.setAttackingPower(unitWallTarget.getAttackingPower() + 1);
                launcherUnit.setThrowRange(launcherUnit.getThrowRageForChanging() + 1);
                infantryUnit.setAttackingPower(infantryUnit.getAttackingPower() + 1);
                break;
            case 2:
                unitWallTarget.setAttackingPower(unitWallTarget.getAttackingPower() + 2);
                launcherUnit.setThrowRange(launcherUnit.getThrowRageForChanging() + 2);
                infantryUnit.setAttackingPower(infantryUnit.getAttackingPower() + 2);
                break;
            case 3:
                unitWallTarget.setAttackingPower(unitWallTarget.getAttackingPower() + 3);
                launcherUnit.setThrowRange(launcherUnit.getThrowRageForChanging() + 3);
                infantryUnit.setAttackingPower(infantryUnit.getAttackingPower() + 3);
                break;
            case 4:
                unitWallTarget.setAttackingPower(unitWallTarget.getAttackingPower() + 4);
                launcherUnit.setThrowRange(launcherUnit.getThrowRageForChanging() + 4);
                infantryUnit.setAttackingPower(infantryUnit.getAttackingPower() + 4);
                break;
            case 5:
                unitWallTarget.setAttackingPower(unitWallTarget.getAttackingPower() + 5);
                launcherUnit.setThrowRange(launcherUnit.getThrowRageForChanging() + 5);
                infantryUnit.setAttackingPower(infantryUnit.getAttackingPower() + 5);
                break;
        }
    }

    public HashMap foodList() {
        return government.getFoods();
    }

    public int popularity() {
        return government.getPopularity();
    }

}


