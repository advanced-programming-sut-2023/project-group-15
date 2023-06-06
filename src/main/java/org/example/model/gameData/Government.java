//this class is completed!
package org.example.model.gameData;

import org.example.model.MBC.InfantryUnit;
import org.example.model.MBC.LauncherUnit;
import org.example.model.MBC.UnitWallTarget;
import org.example.model.building.Building;
import org.example.model.building.Marketplace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Government {
    private final String owner;
    private int people;
    private int workers;
    private Marketplace market;
    private ArrayList<InfantryUnit> infantryUnit;
    private ArrayList<LauncherUnit> launcherUnit;
    private ArrayList<UnitWallTarget> unitWallTarget;
    private final List<Trade> tradeSendList;
    private final List<Trade> tradeReqList;
    private int popularity;
    private int foodRate;
    private int taxRate;
    private int fearRate;
    private int religion;
    private double coins;
    private boolean storeBuilt;
    private final ArrayList<Building> builtBuildings;
    private final HashMap<String, Double> foods;
    private static final ArrayList<Government> allGovernments = new ArrayList<>();
    private static final List<Trade> tradeHistoryList = new ArrayList<>();

    public Government(String owner) {
        this.owner = owner;
        this.coins = 100.00;
        this.people = 50;
        this.workers = 0;
        this.fearRate = 0;
        this.foodRate = -8;
        this.taxRate = 0;
        this.religion = 0;
        this.popularity = -8;
        this.storeBuilt = false;
        this.market = null;
        this.builtBuildings = new ArrayList<>();
        this.newUnitForGovernment();
        this.tradeReqList = new ArrayList<>();
        this.tradeSendList = new ArrayList<>();
        this.foods = new HashMap<>();
        setPrimitiveFoods();
        allGovernments.add(this);
    }

    private void newUnitForGovernment() {
        this.infantryUnit = new ArrayList<>();
        this.launcherUnit = new ArrayList<>();
        this.unitWallTarget = new ArrayList<>();
    }

    public Marketplace playerMarket() {
        return market;
    }

    public void setPayerMarket(Marketplace market) {
        this.market = market;
        this.storeBuilt = true;
    }

    public ArrayList<Building> getAllBuiltBuildings() {
        return builtBuildings;
    }

    public void addBuiltBuilding(Building building) {
        this.getAllBuiltBuildings().add(building);
    }

    public int getReligion() {
        return religion;
    }

    public void setReligion(int religion) {
        this.religion = religion;
    }

    private void setPrimitiveFoods() {
        this.foods.put("Apple", 0.00);
        this.foods.put("Hop", 0.00);
        this.foods.put("Bread", 0.00);
        this.foods.put("Cheese", 0.00);
    }

    public String getOwner() {
        return owner;
    }

    public static Government findGovernmentWithUsername(String username) {
        for (Government government : Government.allGovernments) {
            if (government.getOwner().equals(username))
                return government;
        }
        return null;
    }

    public void setCoins(double coin) {
        this.coins = coin;
    }

    public void deCoin(double coin) {
        this.coins -= coin;
    }

    public void InCoin(double coin) {
        this.coins += coin;
    }

    public double getCoins() {
        return this.coins;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public void setTaxRate(int taxRate) {
        this.taxRate = taxRate;
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
                this.popularity -= 24;
                break;
        }
    }

    public void setFearRate(int fearRate) {
        this.fearRate = fearRate;
    }

    public void addFood(String food, double amount) {
        double number = this.foods.get(food) + amount;
        this.foods.replace(food, number);
    }

    public void removeFood(String food, double amount) {
        double number = this.foods.get(food) - amount;
        this.foods.replace(food, number);
    }

    public int getTaxRate() {
        return this.taxRate;
    }

    public int getFoodRate() {
        return this.foodRate;
    }

    public void addWorker(int amount) {
        this.workers += amount;
    }

    public void reduceWorker(int amount) {
        this.workers -= amount;
    }

    public void addPeople(int amount) {
        this.people += amount;
    }

    public void reducePeople(int amount) {
        this.people -= amount;
    }

    public int getPopularity() {
        return this.popularity;
    }

    public int getFearRate() {
        return this.fearRate;
    }

    public void setFoodRate(int rate) {
        this.foodRate = rate;
    }

    public HashMap<String, Double> getFoods() {
        return foods;
    }

    public void changeFoodGivingPeople(double number) {
        foods.replaceAll((k, v) -> v -= number);
    }

    public int checkFoodVariety() {
        int variety = 0;
        double zero = 0.00;
        if (Double.compare(foods.get("Apple"), zero) != 0)
            ++variety;
        if (Double.compare(foods.get("Hop"), zero) != 0)
            ++variety;
        if (Double.compare(foods.get("Bread"), zero) != 0)
            ++variety;
        if (Double.compare(foods.get("Cheese"), zero) != 0)
            ++variety;
        switch (variety) {
            case 4:
                return 3;
            case 3:
                return 2;
            case 2:
                return 1;
            default:
                return 0;
        }
    }

    public int getPeople() {
        return people;
    }

    public int getWorkers() {
        return workers;
    }

    public int getInfantryUnitNumber() {
        return infantryUnit.size();
    }

    public int getLauncherUnitNumber() {
        return launcherUnit.size();
    }

    public int getUnitWallTargetNumber() {
        return unitWallTarget.size();
    }

    public InfantryUnit getInfantryUnit() {
        return infantryUnit.get(0);
    }

    public LauncherUnit getLauncherUnit() {
        return launcherUnit.get(0);
    }

    public UnitWallTarget getUnitWallTarget() {
        return unitWallTarget.get(0);
    }

    public void addInfantryUnit(InfantryUnit infantryUnit) {
        this.infantryUnit.add(infantryUnit);
    }

    public void addLauncherUnit(LauncherUnit launcherUnit) {
        this.launcherUnit.add(launcherUnit);
    }

    public void addUnitWallTarget(UnitWallTarget unitWallTarget) {
        this.unitWallTarget.add(unitWallTarget);
    }

    public List<Trade> getTradeSendList() {
        return tradeSendList;
    }

    public List<Trade> getTradeReqList() {
        return tradeReqList;
    }

    public static List<Trade> getTradeHistoryList() {
        return tradeHistoryList;
    }

    public boolean isStoreBuilt() {
        return this.storeBuilt;
    }

    public void addPopularity(int amount) {
        this.popularity += amount;
    }
}
