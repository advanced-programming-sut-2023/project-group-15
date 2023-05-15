package org.example.model.building;

import org.example.model.MBC.*;
import org.example.model.enums.*;
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
    public void Educate(String name, int count) {
        int currentPopularity;
        int x = this.getxCoordinate();
        int y = this.getyCoordinate();
        UnitName unit = UnitName.getUnitType(name);
        String type = unit.getType();
        switch (unit.getType()) {
            case "launcher":
                Soldier soldier = new LauncherUnit(unit.getSpeed(), unit.getAttackingPower(), unit.getDefense(),
                        x, y, unit.getUnitHp(), unit.getMaxMove(), unit.getName(),unit.getType(), State.STANDING.getState(), unit.getThrowRange());
                GameInformation.getCurrentPlayer().getMap()[x][y].setSoldier(soldier);
                break;
            case "infantry":
                Soldier soldier1 = new InfantryUnit(unit.getSpeed(), unit.getAttackingPower(), unit.getDefense(),
                        x, y, unit.getUnitHp(), unit.getMaxMove(), unit.getName(), unit.getType(),State.STANDING.getState());
                GameInformation.getCurrentPlayer().getMap()[x][y].setSoldier(soldier1);
                break;
            case "wallTarget":
                Soldier soldier2 = new UnitWallTarget(unit.getSpeed(), unit.getAttackingPower(), unit.getDefense(),
                        x, y, unit.getUnitHp(), unit.getMaxMove(), unit.getName(),unit.getType() ,State.STANDING.getState());
                GameInformation.getCurrentPlayer().getMap()[x][y].setSoldier(soldier2);
                break;
        }
    }
}


