package org.example.controller;

import org.example.model.Tile;
import org.example.model.building.*;
import org.example.model.enums.Products;
import org.example.model.enums.StoreProducts;
import org.example.Server.gameData.GameInformation;
import org.example.Server.gameData.Government;
import org.example.view.enums.outputs.BuildingStatusOutput;
import org.example.view.enums.outputs.GameInformationOutput;


public class BuildingController {
    private final Government government;
    private Building selectedBuilding;
    private String type;
    private String coordinateX;
    private String coordinateY;

    public BuildingController(String playerName) {
        this.government = Government.findGovernmentWithUsername(playerName);
        this.type = null;
        this.selectedBuilding = null;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean checkTheLand(int x, int y) {
        Tile currentTile = GameInformation.getCurrentPlayer().getMap()[x][y];
        if (currentTile.isRock())
            return false;
        return GameInformation.getCurrentPlayerMap()[x][y].getBuilding() == null;
    }

    public boolean selectBuilding(int x, int y) {
        if (GameInformation.getCurrentPlayerMap()[x][y].getBuilding() != null) {
            this.selectedBuilding = GameInformation.getCurrentPlayerMap()[x][y].getBuilding();
            return true;
        }
        return false;
    }

    public void dropProductiveBuilding(int x, int y, String name) {
        for (BuildingName building : BuildingName.values()) {
            if (String.valueOf(building).equals(name)) {
                if (checkForWorkers(building).equals(BuildingStatusOutput.CHECKED_SUCCESSFULLY.getOutput())) {
                    Building newBuilding = new ProductiveBuilding(name, 100, x, y, building.getMaterial1Name()
                            , building.getMaterial2Name(), building.getNumberOfMaterial1(), building.getNumberOfMaterial2(),
                            building.getNumberOfWorkers(), building.getRate(), building.getGood1(), building.getGood2());
                    GameInformation.getCurrentPlayer().getMap()[x][y].setBuilding(newBuilding);
                    GameInformation.getAllBuildings().add(newBuilding);
                    government.addBuiltBuilding(newBuilding);
                }
            }
        }
    }

   /* public void dropStorageBuilding(int x, int y, String name) {
        for (BuildingName building : BuildingName.values())
            if (String.valueOf(building).equals(name)) {
                Building newBuilding = new Storage(name, 100, x, y, building.getMaterial1Name(), building.getMaterial2Name()
                        , building.getNumberOfMaterial1(), building.getNumberOfMaterial2(), building.getCapacity());
                GameInformation.getCurrentPlayer().getMap()[x][y].setBuilding(newBuilding);
                GameInformation.getAllBuildings().add(newBuilding);
                government.addBuiltBuilding(newBuilding);
            }
    }*/

    public void dropCityBuilding(int x, int y, String name) {
        for (BuildingName building : BuildingName.values())
            if (String.valueOf(building).equals(name)) {
                Building newBuilding = new CityBuilding(name, 100, x, y, building.getMaterial1Name(), building.getMaterial2Name()
                        , building.getNumberOfMaterial1(), building.getNumberOfMaterial2());
                GameInformation.getCurrentPlayer().getMap()[x][y].setBuilding(newBuilding);
                GameInformation.getAllBuildings().add(newBuilding);
                if (newBuilding.getName().equals("HOUSE"))
                    government.addPeople(9);
                government.addBuiltBuilding(newBuilding);
            }

    }

    public void dropWarBuilding(int x, int y, String name) {
        for (BuildingName building : BuildingName.values())
            if (String.valueOf(building).equals(name)) {
                Building newBuilding = new WarBuilding(name, building.getHp(), x, y, building.getMaterial1Name(), building.getMaterial2Name(),
                        building.getNumberOfMaterial1(), building.getNumberOfMaterial2(), building.getFireRange(), building.getDefendRange());
                GameInformation.getCurrentPlayer().getMap()[x][y].setBuilding(newBuilding);
                GameInformation.getAllBuildings().add(newBuilding);
                government.addBuiltBuilding(newBuilding);
            }
    }

    public void dropPopularityBuilding(int x, int y, String name) {
        for (BuildingName building : BuildingName.values()) {
            if (String.valueOf(building).equals(name)) {
                Building newBuilding = new PopularityBuilding(name, building.getHp(), x, y, building.getMaterial1Name(),
                        building.getMaterial2Name(), building.getNumberOfMaterial1(), building.getNumberOfMaterial(), building.getRate());
                GameInformation.getCurrentPlayer().getMap()[x][y].setBuilding(newBuilding);
                GameInformation.getAllBuildings().add(newBuilding);
                government.addBuiltBuilding(newBuilding);
                government.addPopularity(10);
            }
        }
    }

    public void dropMarket(int x, int y, String name) {
        for (BuildingName building : BuildingName.values()) {
            Building market = new Marketplace(name, building.getHp(), x, y, building.getMaterial1Name(), building.getMaterial2Name(),
                    building.getNumberOfMaterial1(), building.getNumberOfMaterial2(), building.getNumberOfWorkers());
            GameInformation.getCurrentPlayer().getMap()[x][y].setBuilding(market);
            GameInformation.getAllBuildings().add(market);
            government.addBuiltBuilding(market);
            government.setPlayerMarket((Marketplace) market);
        }
    }

    public boolean checkForBuildingMaterial(String name) {
        String status;
        for (BuildingName building : BuildingName.values()) {
            if (String.valueOf(building).equals(name)) {
            if(building.getMaterial1Name().equals(Products.GOLD_COIN))
                if (this.government.getCoins() < building.getNumberOfMaterial1())
                    return false;

               if(!building.getMaterial1Name().equals(Products.GOLD_COIN)) {
                    status = checkForSources(building.getMaterial1Name(), building.getNumberOfMaterial1());
                    if (!status.equals(GameInformationOutput.SUCCESS.getOutput()))
                        return false;
                }
                if (building.getMaterial2Name() != null) {
                    status = checkForSources(building.getMaterial2Name(), building.getNumberOfMaterial2());
                    if (!status.equals(GameInformationOutput.SUCCESS.getOutput()))
                        return false;
                    else {
                        reduceResources(building.getMaterial2Name(), building.getNumberOfMaterial2());
                    }
                }
                if(building.getMaterial1Name().equals(Products.GOLD_COIN)) {
                    double current = this.government.getCoins();
                    this.government.setCoins(current - building.getNumberOfMaterial1());
                }
                else
                    reduceResources(building.getMaterial1Name() , building.getNumberOfMaterial1());
                return true;
            }
            }

        return false;
    }
    public static String checkForSources(Products product, int amount) {
        int current;
        Storage store = null;
        for (StoreProducts storeProduct : StoreProducts.values()) {
            if (String.valueOf(product).equalsIgnoreCase(String.valueOf(storeProduct))) {
                store = (Storage) GameInformation.findBuilding(String.valueOf(storeProduct.getStoreType()), GameInformation.getCurrentPlayer());
            }
        }
        if (store.getGoods().containsKey(product) && store.getGoods().get(product) >= amount) {
            return GameInformationOutput.SUCCESS.getOutput();
        }
        return GameInformationOutput.NOT_ENOUGH.getOutput();
    }
    public static void reduceResources(Products product , int amount)
    {
        Storage storage = null;
        for (StoreProducts storeProduct : StoreProducts.values()) {
            if (String.valueOf(product).equalsIgnoreCase(String.valueOf(storeProduct))) {
                storage = (Storage) GameInformation.findBuilding(String.valueOf(storeProduct.getStoreType()), GameInformation.getCurrentPlayer());
            }
        }
        int current = storage.getGoods().get(product);
        storage.getGoods().remove(product);
        storage.getGoods().put(product, current - amount);

    }

    public String checkParameters(int x, int y, String name) {
        if (GameInformation.getCurrentPlayerMap()[x][y].getBuilding().getName().equals(name))
            return BuildingStatusOutput.INVALID_COORDINATE.getOutput();
        return BuildingStatusOutput.CHECKED_SUCCESSFULLY.getOutput();
    }

    public void buildingTypeFinder(int x, int y, String name) {
        String type = BuildingName.getBuildingType(name);
        if (type.equals("productive"))
            dropProductiveBuilding(x, y, name);
        else if (type.equals("city"))
            dropCityBuilding(x, y, name);
        else if (type.equals("war"))
            dropWarBuilding(x, y, name);
        else if (type.equals("popularity"))
            dropPopularityBuilding(x, y, name);
        else if (type.equals("market"))
            dropMarket(x, y, name);
       /* else if (type.equals("store"))
            dropStorageBuilding(x, y, name);*/
    }

    public String repair() {
        if (selectedBuilding == null)
            return BuildingStatusOutput.NOT_SELECTED.getOutput();
        String name = selectedBuilding.getName();
        String status1 = null, status2 = null;
        int completeHp = BuildingName.getBuildingName(name).getHp();
        if (selectedBuilding.getHp() < completeHp) {
            if (selectedBuilding.getMaterial1() != null)
                status1 = checkForSources(selectedBuilding.getMaterial1(), selectedBuilding.getNumberOfMaterial1());
            if (selectedBuilding.getMaterial2() != null)
                status2 = checkForSources(selectedBuilding.getMaterial2(), selectedBuilding.getNumberOfMaterial2());
        }
        if (status1.equals(GameInformationOutput.NOT_ENOUGH.getOutput()) || status2.equals(GameInformationOutput.NOT_ENOUGH.getOutput()))
            return BuildingStatusOutput.REPAIR_FORBID.getOutput();
        else
            return BuildingStatusOutput.CHECKED_SUCCESSFULLY.getOutput();

    }

    public boolean isPlayerHaveStore() {
        return government.isStoreBuilt();
    }

    public String checkForWorkers(BuildingName buildingName) {
        if (government.getPeople() >= buildingName.getNumberOfWorkers()) {
            government.reducePeople(buildingName.getNumberOfWorkers());
            government.addWorker(buildingName.getNumberOfWorkers());
            return BuildingStatusOutput.CHECKED_SUCCESSFULLY.getOutput();

        }
        return BuildingStatusOutput.DROP_FORBID.getOutput();
    }

    public boolean isBuildingSelected() {
        return this.selectedBuilding != null;
    }
}


