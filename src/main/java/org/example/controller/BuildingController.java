package org.example.controller;
import org.example.model.MBC.People;
import org.example.model.Tile;
import org.example.model.building.*;
import org.example.model.enums.Products;
import org.example.model.enums.StoreProducts;
import org.example.model.gameData.*;
import org.example.view.enums.outputs.BuildingStatusOutput;

import javax.swing.*;
import java.util.regex.Matcher;

public class BuildingController {

    private String type;
    private String coordinateX;
    private String coordinateY;

    public BuildingController() {
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

    public void dropBuilding(Matcher matcher) {
        String type;
        boolean canBuild = false;
        int x , y;
        x = Integer.parseInt(Utility.groupFinder(matcher, "x"));
        y = Integer.parseInt(Utility.groupFinder(matcher, "y"));
        if(checkTheLand(x , y).equals(BuildingStatusOutput.DROP_FORBID)
                || GameInformation.getCurrentPlayerMap()[x][y].getBuilding() != null)
            System.out.println("Cant drop building in this tile");
        else {
            String name;
            name = Utility.groupFinder(matcher, "type");
            canBuild = checkForBuildingMaterial(name);
            if (!canBuild)
                System.out.println("not enough resources to build this building");
            else {
                buildingTypeFinder(x , y , name);
            }
        }
    }
    //public void selectBuilding()



    public void dropProductiveBuilding(int x , int y , String name)
    {
        for(BuildingName building : BuildingName.values()) {
            if (String.valueOf(building).equals(name)) {
                Building newBuilding = new ProductiveBuilding(name, 100, x, y, building.getMaterial1Name()
                        , building.getMaterial2Name(), building.getNumberOfMaterial1(), building.getNumberOfMaterial2(),
                        building.getNumberOfWorkers(), building.getRate(), building.getGood1(), building.getGood2());
                GameInformation.getCurrentPlayer().getMap()[x][y].setBuilding(newBuilding);
                GameInformation.getAllBuildings().add(newBuilding);
                return;

            }
        }
        }
       public void dropStorageBuilding(int x , int y , String name)
        {
         for(BuildingName building : BuildingName.values())
             if(String.valueOf(building).equals(name)) {
                 Building newBuilding = new Storage(name, 100, x, y, building.getMaterial1Name(), building.getMaterial2Name()
                         , building.getNumberOfMaterial1(), building.getNumberOfMaterial2(), building.getCapacity());
                 GameInformation.getCurrentPlayer().getMap()[x][y].setBuilding(newBuilding);
                 GameInformation.getAllBuildings().add(newBuilding);
             }

        }
       public void dropCityBuilding(int x , int y , String name)
        {
            for(BuildingName building : BuildingName.values())
                if(String.valueOf(building).equals(name))
                {
                    Building newBuilding = new CityBuilding(name , 100 , x, y , building.getMaterial1Name() , building.getMaterial2Name()
                    , building.getNumberOfMaterial1() , building.getNumberOfMaterial2());
                    GameInformation.getCurrentPlayer().getMap()[x][y].setBuilding(newBuilding);
                    GameInformation.getAllBuildings().add(newBuilding);
                }
        }
        public void dropWarBuilding(int x , int y , String name)
        {
            for(BuildingName building : BuildingName.values())
                if(String.valueOf(building).equals(name))
                {
                    Building newBuilding = new WarBuilding(name , building.getHp() , x , y , building.getMaterial1Name() , building.getMaterial2Name() ,
                            building.getNumberOfMaterial1() , building.getNumberOfMaterial2(),building.getFireRange() , building.getDefendRange());
                    GameInformation.getCurrentPlayer().getMap()[x][y].setBuilding(newBuilding);
                    GameInformation.getAllBuildings().add(newBuilding);
                }
        }
        public void dropPopularityBuilding(int x , int y , String name)
        {
            for(BuildingName building : BuildingName.values())
            {
                if(String.valueOf(building).equals(name))
                {
                Building newBuilding = new PopularityBuilding(name, building.getHp(), x , y , building.getMaterial1Name() ,
                        building.getMaterial2Name() , building.getNumberOfMaterial1() , building.getNumberOfMaterial(), building.getRate());
                GameInformation.getCurrentPlayer().getMap()[x][y].setBuilding(newBuilding);
                    GameInformation.getAllBuildings().add(newBuilding);
                }
            }
        }
        public void dropMarket(int x ,int y , String name) {
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
                    status = GameInformation.checkForSources(building.getMaterial1Name(), building.getNumberOfMaterial1());
                    if (!status.equals("success"))
                        return false;
                    else if (building.getMaterial2Name() != null)
                        status = GameInformation.checkForSources(building.getMaterial2Name(), building.getNumberOfMaterial2());
                    if (status.equals("success"))
                        return true;

                }
            }
            return false;
        }
       /* public void buildingSearcher(int x , int y , String name)
        {
            GameInformation.getCurrentPlayerMap()[x][y].getBuilding().getName()
        }*/

    public BuildingStatusOutput checkParameters() {
        if (this.getCoordinateX().matches("\\s*\\d+\\s*")) {
            if (coordinateY.matches("\\s*\\d+\\s*")) {
                //TODO: searching on type of buildings
            }
            return BuildingStatusOutput.INVALID_Y_COORDINATE;
        }
        return BuildingStatusOutput.INVALID_X_COORDINATE;
    }

  /*  public BuildingStatusOutput checkTheLand(int x , int y) {
        Tile currentTile = GameInformation.getCurrentPlayer().getMap()[x][y];
        if(!currentTile.isRock())
            return BuildingStatusOutput.DROP_FORBID;
        else if(!currentTile.getLandType().isBuildingStatus())
            return BuildingStatusOutput.DROP_FORBID;

        return null;
    }

    public void buildingTypeFinder(int x , int y , String name)
    {
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

    }


