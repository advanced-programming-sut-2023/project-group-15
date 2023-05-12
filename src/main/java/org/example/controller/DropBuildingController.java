package org.example.controller;
import org.example.model.building.*;
import org.example.model.gameData.*;
import org.example.view.enums.outputs.BuildingStatusOutput;

public class DropBuildingController {

    private String type;
    private String coordinateX;
    private String coordinateY;

    public DropBuildingController() {
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

    public void dropProductiveBuilding(int x , int y , BuildingName name)
    {
        for(BuildingName building : BuildingName.values()) {
            if (building.equals(name)) {
                Building newBuilding = new ProductiveBuilding(name.toString(), 100, x, y, building.getMaterial1Name()
                        , building.getMaterial2Name(), building.getNumberOfMaterial1(), building.getNumberOfMaterial2(),
                        building.getNumberOfWorkers(), building.getRate(), building.getGood1(), building.getGood2());
                //Map.getCurrentMap()[x][y].setBuilding(newBuilding);
                return;

            }
            //TODO each group of buildings should be made in a method
        }

        }

    public BuildingStatusOutput checkParameters() {
        if (this.getCoordinateX().matches("\\s*\\d+\\s*")) {
            if (this.getCoordinateY().matches("\\s*\\d+\\s*")) {
                //TODO: searching on type of buildings
            }
            return BuildingStatusOutput.INVALID_Y_COORDINATE;
        }
        return BuildingStatusOutput.INVALID_X_COORDINATE;
    }

    public BuildingStatusOutput checkTheLand() {
        return null;
    }

    public BuildingStatusOutput SettingTheBuilding() {
        return null;
    }
}


