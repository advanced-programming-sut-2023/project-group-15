package org.example.model.building;

import org.example.model.MBC.Soldier;
import org.example.model.enums.Products;
import org.example.model.enums.UnitName;
import org.example.model.gameData.GameInformation;

public class Education extends Building {
    private Soldier soldiers;
    private int numberOfSoldiers;

    Education(String name, int hp, int xCoordinate, int yCoordinate, Products material1,
              Products material2, int numberOfMaterial1, int numberOfMaterial2) {
        super(name, hp, xCoordinate, yCoordinate, material1,
                material2, numberOfMaterial1, numberOfMaterial2);
        ;
    }

    //TODO decrease people and coins
    private void Educate(UnitName unitName, int count) {
        int currentPopularity;
        String typeToEducate = String.valueOf(unitName);
        for (UnitName unit : UnitName.values()) {
            if (unit.equals(unitName)) {

                if (GameInformation.getCurrentPlayerGovernment().getCoins() <= count * unit.getCost())
                    return;
                else if (GameInformation.getCurrentPlayerGovernment().getPopularity() <= count)
                    return;
                else {
                    GameInformation.getCurrentPlayerGovernment().deCoin(unit.getCost());
                    currentPopularity = GameInformation.getCurrentPlayerGovernment().getPopularity();
                    GameInformation.getCurrentPlayerGovernment().setPopularity(currentPopularity - count);
                    //GameInformation.getAllSoldiers().add();


                }
            }
        }
    }
}


