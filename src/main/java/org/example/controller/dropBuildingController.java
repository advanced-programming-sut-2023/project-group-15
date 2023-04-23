package org.example.controller;
import org.example.model.enums.*;
import org.example.model.building.*;
import org.example.model.gameData.*;

public class dropBuildingController {
    private void dropProductiveBuilding(int x , int y , String type)
    {
        for(buildingName building : buildingName.values())
        {
            if(building.equals(type))
            {
                Building newBuilding = new ProductiveBuilding(100 , x , y , building.getMaterial1Name()
                        , building.getMaterial2Name() , building.getNumberOfMaterial1() , building.getNumberOfMaterial2() ,
                        building.getNumberOfWorkers() , type , building.getRate() , building.getGood1() , building.getGood2());
                        map.getCurrentMap()[x][y].setBuilding(newBuilding);

            }
            else
                System.out.println("Building type is invalid");
        }
    }

}
