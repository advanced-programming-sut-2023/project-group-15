package org.example.controller;

import org.example.model.MBC.People;
import org.example.model.MBC.Worker;
import org.example.model.Tile;
import org.example.model.building.*;
import org.example.model.enums.Products;
import org.example.model.enums.StoreProducts;
import org.example.model.gameData.*;
import org.example.view.enums.outputs.BuildingStatusOutput;
import org.example.view.enums.outputs.GameInformationOutput;

import java.util.Objects;
import java.util.regex.Matcher;

public class BuildingController {
    private final Government government;
    private String type;
    private String coordinateX;
    private String coordinateY;
    private Building selectedBuilding;

    public BuildingController(String playerName) {
        this.government = Government.findGovernmentWithUsername(playerName);
        this.type = null;
        this.coordinateX = null;
        this.coordinateY = null;
    }

    public String getType() {
        return type;
    }

    public String getCoordinateX() {
        return coordinateX;
    }

    public String getCoordinateY() {
        return coordinateY;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCoordinateX(String coordinateX) {
        this.coordinateX = coordinateX;
    }

    public void setCoordinateY(String coordinateY) {
        this.coordinateY = coordinateY;
    }

    public boolean checkTheLand(int x, int y) {
        Tile currentTile = GameInformation.getCurrentPlayer().getMap()[x][y];
        if (currentTile.isRock())
            return false;
        if (GameInformation.getCurrentPlayerMap()[x][y].getBuilding() != null)
            return false;
        else return currentTile.getLandType().isBuildingStatus();
    }

    public void selectBuilding(int x, int y) {
        for (int i = 0; i < GameInformation.getCurrentPlayerMap().length; i++) {
            for (int j = 0; j < GameInformation.getCurrentPlayerMap()[0].length; j++) {
                if (GameInformation.getCurrentPlayerMap()[i][j].getBuilding() != null)
                    selectedBuilding = GameInformation.getCurrentPlayerMap()[i][j].getBuilding();
            }
        }
    }

    public void selectForChangingTax(int tax) {
        String name = selectedBuilding.getName();
        if (name.equals("BIG_STONE_GATEHOUSE") || name.equals("SMALL_STONE_GATEHOUSE"))
            GameInformation.getCurrentPlayerGovernment().setTaxRate(tax);

    }

     /*   public void selectForEducate()
        {
            if(selectedBuilding instanceof Education)
                selectedBuilding.Educate();
        }*/
    //TODO add education


    public void dropProductiveBuilding(int x, int y, String name) {
        for (BuildingName building : BuildingName.values()) {
            if (String.valueOf(building).equals(name)) {
                if(checkForWorkers(building).equals(BuildingStatusOutput.CHECKED_SUCCESSFULLY.getOutput())) {
                    Building newBuilding = new ProductiveBuilding(name, 100, x, y, building.getMaterial1Name()
                            , building.getMaterial2Name(), building.getNumberOfMaterial1(), building.getNumberOfMaterial2(),
                            building.getNumberOfWorkers(), building.getRate(), building.getGood1(), building.getGood2());
                    GameInformation.getCurrentPlayer().getMap()[x][y].setBuilding(newBuilding);
                    GameInformation.getAllBuildings().add(newBuilding);
                }
            }
        }
    }

    public void dropStorageBuilding(int x, int y, String name) {
        for (BuildingName building : BuildingName.values())
            if (String.valueOf(building).equals(name)) {
                Building newBuilding = new Storage(name, 100, x, y, building.getMaterial1Name(), building.getMaterial2Name()
                        , building.getNumberOfMaterial1(), building.getNumberOfMaterial2(), building.getCapacity());
                GameInformation.getCurrentPlayer().getMap()[x][y].setBuilding(newBuilding);
                GameInformation.getAllBuildings().add(newBuilding);
            }
    }
    public String checkForWorkers(BuildingName buildingName)
    {
        if(government.getPeople() >= buildingName.getNumberOfWorkers()) {
            government.reducePeople(buildingName.getNumberOfWorkers());
            government.addWorker(buildingName.getNumberOfWorkers());
            return BuildingStatusOutput.CHECKED_SUCCESSFULLY.getOutput();

        }
        return BuildingStatusOutput.DROP_FORBID.getOutput();
    }

    public void dropCityBuilding(int x, int y, String name) {
        for (BuildingName building : BuildingName.values())
            if (String.valueOf(building).equals(name)) {
                Building newBuilding = new CityBuilding(name, 100, x, y, building.getMaterial1Name(), building.getMaterial2Name()
                        , building.getNumberOfMaterial1(), building.getNumberOfMaterial2());
                GameInformation.getCurrentPlayer().getMap()[x][y].setBuilding(newBuilding);
                GameInformation.getAllBuildings().add(newBuilding);
                if(newBuilding.getName().equals("HOUSE"))
                    government.addPeople(9);
            }

    }

    public void dropWarBuilding(int x, int y, String name) {
        for (BuildingName building : BuildingName.values())
            if (String.valueOf(building).equals(name)) {
                Building newBuilding = new WarBuilding(name, building.getHp(), x, y, building.getMaterial1Name(), building.getMaterial2Name(),
                        building.getNumberOfMaterial1(), building.getNumberOfMaterial2(), building.getFireRange(), building.getDefendRange());
                GameInformation.getCurrentPlayer().getMap()[x][y].setBuilding(newBuilding);
                GameInformation.getAllBuildings().add(newBuilding);
            }
    }

    public void dropPopularityBuilding(int x, int y, String name) {
        for (BuildingName building : BuildingName.values()) {
            if (String.valueOf(building).equals(name)) {
                Building newBuilding = new PopularityBuilding(name, building.getHp(), x, y, building.getMaterial1Name(),
                        building.getMaterial2Name(), building.getNumberOfMaterial1(), building.getNumberOfMaterial(), building.getRate());
                GameInformation.getCurrentPlayer().getMap()[x][y].setBuilding(newBuilding);
                GameInformation.getAllBuildings().add(newBuilding);
            }
        }
    }

    public void dropMarket(int x, int y, String name) {
        for (BuildingName building : BuildingName.values()) {
            Building market = new Market(name, building.getHp(), x, y, building.getMaterial1Name(), building.getMaterial2Name(),
                    building.getNumberOfMaterial1(), building.getNumberOfMaterial2(), building.getNumberOfWorkers());
            GameInformation.getCurrentPlayer().getMap()[x][y].setBuilding(market);
            GameInformation.getAllBuildings().add(market);
        }
    }

    public boolean checkForBuildingMaterial(String name) {
        String status;
        for (BuildingName building : BuildingName.values()) {
            if (String.valueOf(building).equals(name)) {
                status = checkForSources(building.getMaterial1Name(), building.getNumberOfMaterial1());
                if (!status.equals("success"))
                    return false;
                else if (building.getMaterial2Name() != null)
                    status = checkForSources(building.getMaterial2Name(), building.getNumberOfMaterial2());
                if (status.equals("success"))
                    return true;
            }
        }
        return false;
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
    }

    public String repair() {
        if(selectedBuilding == null)
            return BuildingStatusOutput.NOT_SELECTED.getOutput();
        String name = selectedBuilding.getName();
        String status1 = null , status2 = null;
        int completeHp = BuildingName.getBuildingName(name).getHp();
        if (selectedBuilding.getHp() < completeHp) {
            if (selectedBuilding.getMaterial1() != null)
                status1 = checkForSources(selectedBuilding.getMaterial1(), selectedBuilding.getNumberOfMaterial1());
            if(selectedBuilding.getMaterial2() != null)
                status2 = checkForSources(selectedBuilding.getMaterial2() , selectedBuilding.getNumberOfMaterial2());
        }
        if(status1 .equals(GameInformationOutput.NOT_ENOUGH) || status2.equals(GameInformationOutput.NOT_ENOUGH))
            return BuildingStatusOutput.REPAIR_FORBID.getOutput();
        else
            return BuildingStatusOutput.CHECKED_SUCCESSFULLY.getOutput();

    }

    public static String checkForSources(Products product, int amount) {
        int current;
        Storage store = null;
        for(StoreProducts storeProduct : StoreProducts.values()) {
            if (String.valueOf(product).equals(String.valueOf(storeProduct))) {
                store = (Storage) GameInformation.findBuilding(String.valueOf(storeProduct.getStoreType()) , GameInformation.getCurrentPlayer());
            }
        }
        if (store.getGoods().containsKey(product) && store.getGoods().get(product) >= amount) {
            current = store.getGoods().get(product);
            store.getGoods().remove(product);
            store.getGoods().put(product, current - amount);
            return GameInformationOutput.SUCCESS.getOutput();
        }
        return GameInformationOutput.NOT_ENOUGH.getOutput();
    }
}


