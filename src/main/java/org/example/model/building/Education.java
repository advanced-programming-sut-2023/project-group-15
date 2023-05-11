package org.example.model.building;

import org.example.model.MBC.Soldier;
import org.example.model.User;
import org.example.model.enums.Products;
import org.example.model.enums.UnitName;
import org.example.model.enums.Unitcosts;
import org.example.model.gameData.GameInformation;

public class Education extends Building{
    private Soldier soldiers;
    private int numberOfSoldiers;
    Education(String name, int hp, int xCoordiante, int yCoordiante, Products material1,
              Products material2, int numberOfMaterial1, int numberOfMaterial2)
    {
         super(name, hp, xCoordiante, yCoordiante, material1,
                material2, numberOfMaterial1, numberOfMaterial2);;
    }
    //TODO decrease people and coins
    private void Educate(UnitName unitName)
    {
        String typeToEducate = String.valueOf(unitName);
        for(Unitcosts unitcosts : Unitcosts.values()) {
            if (unitcosts.equals(unitName)) {
                GameInformation.getCurrentPlayer();
                GameInformation.getCurrentPlayerGovernment().deCoin(unitcosts.getCost());

            }
        }
        }
    }


