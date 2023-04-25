package org.example.controller;
import org.example.model.building.*;
import org.example.model.gameData.*;

public class DropBuildingController {
    public void dropProductiveBuilding(int x , int y , BuildingName name)
    {
        for(BuildingName building : BuildingName.values()) {
            if (building.equals(name)) {
                Building newBuilding = new ProductiveBuilding(name.toString(), 100, x, y, building.getMaterial1Name()
                        , building.getMaterial2Name(), building.getNumberOfMaterial1(), building.getNumberOfMaterial2(),
                        building.getNumberOfWorkers(), building.getRate(), building.getGood1(), building.getGood2());
                Map.getCurrentMap()[x][y].setBuilding(newBuilding);
                return;

            }
        }

        }
    }


