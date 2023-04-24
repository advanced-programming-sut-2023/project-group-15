package org.example.controller;
import org.example.model.enums.*;
import org.example.model.building.*;
import org.example.model.gameData.*;

public class dropBuildingController {
    public void dropProductiveBuilding(int x , int y , buildingName name)
    {
        for(buildingName building : buildingName.values()) {
            if (building.equals(name)) {
                Building newBuilding = new ProductiveBuilding(name.toString(), 100, x, y, building.getMaterial1Name()
                        , building.getMaterial2Name(), building.getNumberOfMaterial1(), building.getNumberOfMaterial2(),
                        building.getNumberOfWorkers(), building.getRate(), building.getGood1(), building.getGood2());
                map.getCurrentMap()[x][y].setBuilding(newBuilding);
                return;

            }
        }

        }
    }


