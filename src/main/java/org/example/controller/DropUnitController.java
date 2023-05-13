package org.example.controller;

import org.example.model.MBC.InfantryUnit;
import org.example.model.MBC.LauncherUnit;
import org.example.model.MBC.Soldier;
import org.example.model.MBC.UnitWallTarget;
import org.example.model.enums.LandType;
import org.example.model.enums.UnitName;
import org.example.model.gameData.GameInformation;
import org.example.view.enums.outputs.UnitMenuOutput;

public class DropUnitController {

    public static UnitMenuOutput dropUnit(String name, int x, int y) {
        UnitName type = UnitName.getUnitType(name);
        if (checkLand(x, y)) {
            unitType(type, x, y);
            return UnitMenuOutput.SUCCESSFUL_DROP_UNIT;
        } else return UnitMenuOutput.CAN_NOT_DROP_UNIT;
    }

    public static void unitType(UnitName unit, int x, int y) {
        switch (unit.getType()) {
            case "launcher":
                Soldier soldier = new LauncherUnit(unit.getSpeed(), unit.getAttackingPower(), unit.getDefense(), x, y,
                        unit.getUnitHp(), unit.getMaxMove(), unit.getName(), unit.getType(), "STANDING", unit.getThrowRange());
                GameInformation.getCurrentPlayer().getMap()[x][y].setSoldier(soldier);
                break;
            case "infantry":
                Soldier soldier1 = new InfantryUnit(unit.getSpeed(), unit.getAttackingPower(), unit.getDefense(), x, y,
                        unit.getUnitHp(), unit.getMaxMove(), unit.getName(), unit.getType(), "STANDING");
                GameInformation.getCurrentPlayer().getMap()[x][y].setSoldier(soldier1);
                break;
            case "wallTarget":
                Soldier soldier2 = new UnitWallTarget(unit.getSpeed(), unit.getAttackingPower(), unit.getDefense(), x, y,
                        unit.getUnitHp(), unit.getMaxMove(), unit.getName(), unit.getType(), "STANDING");
                GameInformation.getCurrentPlayer().getMap()[x][y].setSoldier(soldier2);
                break;
        }
    }

    public static boolean checkLand(int x, int y) {
        LandType landType = GameInformation.getCurrentPlayer().getMap()[x][y].getLandType();
        if (landType == null) return false;
        else {
            switch (landType) {
                case SEA, ROCK, RIVER, SMALL_POND, BIG_POND:
                    return false;
                default:
                    return true;
            }
        }
    }


}
