package org.example.controller;

import org.example.model.MBC.InfantryUnit;
import org.example.model.MBC.LauncherUnit;
import org.example.model.MBC.Soldier;
import org.example.model.MBC.UnitWallTarget;
import org.example.model.building.Building;
import org.example.model.enums.*;
import org.example.Server.gameData.GameInformation;
import org.example.Server.gameData.Government;
import org.example.view.enums.outputs.GameInformationOutput;
import org.example.view.enums.outputs.UnitMenuOutput;


import java.util.ArrayList;


public class UnitMenuController {
    private final Government government;
    private Soldier selectedUnit = null;
    private LauncherUnit launcherUnit;
    private UnitWallTarget unitWallTarget;
    private InfantryUnit infantryUnit;

    public UnitMenuController(String playerName) {
        this.government = Government.findGovernmentWithUsername(playerName);
    }

    public int x1, y1;
    public int patX1, patX2, patY1, patY2;

    public UnitMenuOutput selectUnit(int x, int y) {
        if (GameInformation.getCurrentPlayer().getMap()[x][y].getSoldier() != null) {
            this.selectedUnit = GameInformation.getCurrentPlayer().getMap()[x][y].getSoldier();
            if (this.selectedUnit.getType().equals("wallTarget"))
                this.unitWallTarget = (UnitWallTarget) this.selectedUnit;
            else if (this.selectedUnit.getType().equals("launcher"))
                this.launcherUnit = (LauncherUnit) this.selectedUnit;
            else if (this.selectedUnit.getType().equals("infantry"))
                this.infantryUnit = (InfantryUnit) this.selectedUnit;
            return UnitMenuOutput.UNIT_FOUND;
        } else
            return UnitMenuOutput.UNIT_NOT_FOUND;
    }

    public UnitMenuOutput moveUnit(int x, int y) {
        if (this.selectedUnit.getState().equals("STANDING"))
            return UnitMenuOutput.NOT_IN_A_STATE;
        int deltaX = Math.abs(x - this.selectedUnit.getX());
        int deltaY = Math.abs(y - this.selectedUnit.getY());
        if (GameInformation.getCurrentPlayer().getMap()[x][y].getLandType() != null) {
            LandType landType = GameInformation.getCurrentPlayer().getMap()[x][y].getLandType();
            if (landType.equals(LandType.SHALLOW_WATER) || landType.equals(LandType.RIVER) || landType.equals(LandType.BIG_POND) ||
                    landType.equals(LandType.SEA) || landType.equals(LandType.SMALL_POND) || landType.equals(LandType.ROCK) || landType.equals(LandType.PEBBLE))
                return UnitMenuOutput.UNIT_DO_NOT_ALLOWED_PLACE_THERE;
        }
        int maxMove = this.selectedUnit.getMaxMove();
        if (deltaX > maxMove || deltaY > maxMove) {
            return UnitMenuOutput.BEYOND_SOLDIER_POWER;
        } else {
            this.selectedUnit.setX(this.selectedUnit.getX() + x);
            this.selectedUnit.setY(this.selectedUnit.getY() + y);
            return UnitMenuOutput.SUCCESSFUL_MOVE;
        }
    }

    public UnitMenuOutput digTunnel(int x, int y) {
        if (!this.selectedUnit.getName().equalsIgnoreCase("TUNNELER"))
            return UnitMenuOutput.WRONG_UNIT;
        String checkMove = moveUnit(x, y).getOutput();
        if (checkMove.equals(UnitMenuOutput.BEYOND_SOLDIER_POWER.getOutput()))
            return UnitMenuOutput.BEYOND_SOLDIER_POWER;
        else if (checkMove.equals(UnitMenuOutput.UNIT_DO_NOT_ALLOWED_PLACE_THERE.getOutput()))
            return UnitMenuOutput.UNIT_DO_NOT_ALLOWED_PLACE_THERE;
        if (GameInformation.getCurrentPlayer().getMap()[x][y].getBuilding() != null) {
            Building building = GameInformation.getCurrentPlayer().getMap()[x][y].getBuilding();
            switch (building.getName()) {
                case "perimeter tower", "lookout tower", "defend turret", "square tower", "circle tower":
                    GameInformation.getCurrentPlayer().getMap()[x][y].setBuilding(null);
                    return UnitMenuOutput.SUCCESSFUL_DIG;
                default:
                    return UnitMenuOutput.WRONG_BUILDING;
            }
        } else
            return UnitMenuOutput.WRONG_PLACE_FOR_DOG_TUNNEL;
    }


    public UnitMenuOutput setState(int x, int y, String state) {
        this.selectedUnit.setState(state);
        if (state.equals("offensive")) {
            this.selectedUnit.setMaxMove(this.selectedUnit.getMaxMove() + 30);
            this.selectedUnit.setAttackingPower(this.selectedUnit.getAttackingPower() + 10);
        }
        return UnitMenuOutput.SET_STATE;
    }

    public UnitMenuOutput airAttack(int x, int y) {
        if (!this.selectedUnit.getType().equals("launcher"))
            return UnitMenuOutput.WRONG_UNIT_FOR_AIR_ATTACK;
        else {
            int deltaX = x - this.selectedUnit.getX();
            int deltaY = y - this.selectedUnit.getY();
            if (deltaX <= this.launcherUnit.getThrowRageForCharging() && deltaY <= this.launcherUnit.getThrowRageForCharging()) {
                if (GameInformation.getCurrentPlayer().getMap()[x][y].getBuilding() != null) {
                    Building building = GameInformation.getCurrentPlayer().getMap()[x][y].getBuilding();


                    if (building.getHp() > this.selectedUnit.getAttackingPower())

                        building.setHp(building.getHp() - this.selectedUnit.getAttackingPower());
                    else
                        GameInformation.getCurrentPlayer().getMap()[x][y].setBuilding(null);
                } else if (GameInformation.getCurrentPlayer().getMap()[x][y].getSoldier() != null) {
                    Soldier unit = GameInformation.getCurrentPlayer().getMap()[x][y].getSoldier();
                    if ((unit.getUnitHp() + unit.getDefense()) > this.selectedUnit.getAttackingPower())
                        unit.setUnitHp(unit.getUnitHp() + unit.getDefense() - this.selectedUnit.getAttackingPower());
                    else
                        GameInformation.getCurrentPlayer().getMap()[x][y].setSoldier(null);
                }

                return UnitMenuOutput.SUCCESSFUL_AIR_ATTACK;
            } else return UnitMenuOutput.BEYOND_SOLDIER_POWER;
        }

    }

    public UnitMenuOutput disbandUnit() {
        ArrayList<Building> building = GameInformation.getAllBuildings();
        for (int i = 0; i != building.size(); i++) {
            Building building1 = building.get(i);
            if (building1.getName().equals("Hovel")) {
                int x = building1.getxCoordinate();
                int y = building1.getyCoordinate();
                moveUnit(x, y);
                this.launcherUnit = null;
                return UnitMenuOutput.UNIT_DISBANDED;
            }
        }
        return UnitMenuOutput.ERROR_DISBAND;
    }

    public UnitMenuOutput buildEquipment(String equipment) {
        if (this.selectedUnit.getName().equalsIgnoreCase("ENGINEER")) {
            if (equipment.equalsIgnoreCase("TREBUCHET")) {
                if ((BuildingController.checkForSources(Products.WOOD, 10).equals(
                        GameInformationOutput.SUCCESS.getOutput())) && (BuildingController.checkForSources(Products.ROCK, 5).equals(
                        GameInformationOutput.SUCCESS.getOutput())))
                    return UnitMenuOutput.SUCCESSFUL_BUILD_TREBUCHET;

                else return UnitMenuOutput.NOT_ENOUGH_RESOURCES;
            }
            if (equipment.equalsIgnoreCase("CATAPULTS")) {
                if ((BuildingController.checkForSources(Products.WOOD, 5).equals(
                        GameInformationOutput.SUCCESS.getOutput())) && (BuildingController.checkForSources(Products.ROCK, 5).equals(
                        GameInformationOutput.SUCCESS.getOutput())))
                    return UnitMenuOutput.SUCCESSFUL_BUILD_CATAPULTS;

                return UnitMenuOutput.NOT_ENOUGH_RESOURCES;
            }
            if (equipment.equalsIgnoreCase("PORTABLE SHIELD")) {
                if (BuildingController.checkForSources(Products.IRON, 10).equals(
                        GameInformationOutput.SUCCESS.getOutput()))
                    return UnitMenuOutput.SUCCESSFUL_BUILD_SHIELD;

                return UnitMenuOutput.NOT_ENOUGH_RESOURCES;
            }
            if (equipment.equalsIgnoreCase("BATTERING RAM")) {
                if (BuildingController.checkForSources(Products.WOOD, 20).equals(
                        GameInformationOutput.SUCCESS.getOutput()))
                    return UnitMenuOutput.SUCCESSFUL_BUILD_BATTERING_RAM;

                return UnitMenuOutput.NOT_ENOUGH_RESOURCES;
            }

            return UnitMenuOutput.WRONG_BUILDING_EQ;
        }
        return UnitMenuOutput.WRONG_UNIT_ENGINEER;
    }

    public UnitMenuOutput pourOil(String direction) {
        if (this.selectedUnit.getName().equalsIgnoreCase("ENGINEER")) {
            ArrayList<Building> building = GameInformation.getAllBuildings();
            for (int i = 0; i != building.size(); i++) {
                Building building1 = building.get(i);
                if (building1.getName().equals("oil smelter")) {
                    int x = building1.getxCoordinate();
                    int y = building1.getyCoordinate();
                    moveUnit(x, y);
                    moveUnit(this.selectedUnit.getX() - x, this.selectedUnit.getY() - y);
                }
            }
            switch (Direction.valueOf(direction.toUpperCase())) {
                case UP:
                    y1++;
                    break;
                case DOWN:
                    y1--;
                    break;
                case LEFT:
                    x1--;
                    break;
                case RIGHT:
                    x1++;
            }
            return UnitMenuOutput.SUCCESSFUL_POUR_OIL;
        } else return UnitMenuOutput.WRONG_UNIT_ENGINEER;
    }

    public UnitMenuOutput digDitch(int x, int y) {
        if (this.selectedUnit.getName().equalsIgnoreCase("SPEARMEN")) {
            String checkMove = moveUnit(x, y).getOutput();
            if (checkMove.equals("Your destination is beyond the soldier's power\ntry again"))
                return UnitMenuOutput.BEYOND_SOLDIER_POWER;
            else {
                //create ditch
                //GameInformation.getCurrentPlayer().getMap()[x][y].setBuilding();
                return UnitMenuOutput.SUCCESSFUL_DIG_DITCH;
            }
        } else return UnitMenuOutput.WRONG_UNIT_TO_DIG_DITCH;
    }

    public UnitMenuOutput patrolUnit(int x, int y, int x2, int y2) {
        String checkMove = moveUnit(x, y).getOutput();
        if (checkMove.equals(UnitMenuOutput.BEYOND_SOLDIER_POWER.getOutput())) {
            x1 -= x;
            y1 -= y;
            return UnitMenuOutput.BEYOND_SOLDIER_POWER;
        }
        String doubleCheck = moveUnit(x2, y2).getOutput();
        if (doubleCheck.equals(UnitMenuOutput.BEYOND_SOLDIER_POWER.getOutput())) {
            x1 = x1 - (x + x2);
            y1 = y1 - (y + y2);
            return UnitMenuOutput.BEYOND_SOLDIER_POWER;
        }
        System.out.println(UnitMenuOutput.UNIT_START_PATROLLING.getOutput());
        patX1 = x;
        patY1 = y;
        patX2 = x2;
        patY2 = y2;
//        String c = patrolStop(stopPatrolling, x, y, x2, y2).getOutput();
        System.out.println(UnitMenuOutput.UNIT_STOP_PATROLLING.getOutput());
        return UnitMenuOutput.PATROL_UNIT;
    }

    public UnitMenuOutput patrolStop(boolean stopPatrolling, int x, int y, int x2, int y2) {
        // naghese
        while (stopPatrolling) {
            String checkMove = moveUnit(x, y).getOutput();
            String doubleCheck = moveUnit(x2, y2).getOutput();
        }
        return UnitMenuOutput.PATROL_UNIT;
    }

    public UnitMenuOutput attackUnit(int x, int y) {
        String checkMove = moveUnit(x, y).toString();
        if (checkMove.equals("Your destination is beyond the soldier's power\ntry again")) {
            return UnitMenuOutput.BEYOND_SOLDIER_POWER;
        } else {
            if (GameInformation.getCurrentPlayer().getMap()[x][y].getSoldier() != null) {
                Soldier unit = GameInformation.getCurrentPlayer().getMap()[x][y].getSoldier();
                if (unit.getUnitHp() + unit.getDefense() > this.selectedUnit.getAttackingPower())
                    unit.setUnitHp(unit.getUnitHp() + unit.getDefense() - this.selectedUnit.getAttackingPower());
                else
                    GameInformation.getCurrentPlayer().getMap()[x][y].setSoldier(null);
                return UnitMenuOutput.SUCCESSFUL_ATTACK;
            } else return UnitMenuOutput.UNIT_NOT_FOUND;
        }
    }

    public UnitMenuOutput wallTarget(int x, int y) {
        Building building;
        Soldier unit;
        if ((GameInformation.getCurrentPlayer().getMap()[x][y].getSoldier() != null) && (this.selectedUnit.getName().equalsIgnoreCase("SPEARMEN") || (this.selectedUnit.getName().equalsIgnoreCase("MACEMEN")))) {
            attackUnit(x, y);
        }
        if ((GameInformation.getCurrentPlayer().getMap()[x][y].getBuilding() != null) && (this.selectedUnit.getName().equalsIgnoreCase("SPEARMEN") || this.selectedUnit.getName().equalsIgnoreCase("MACEMEN") ||
                this.selectedUnit.getName().equalsIgnoreCase("LADDERMEN") || this.selectedUnit.getName().equalsIgnoreCase("ASSASSINS"))) {
            if (GameInformation.getCurrentPlayer().getMap()[x][y].getBuilding().getName().equals("Small stone gatehouse") ||
                    GameInformation.getCurrentPlayer().getMap()[x][y].getBuilding().getName().equals("big stone gatehouse")) {
                return UnitMenuOutput.CONQUERING_AND_OPENING_THE_GATE;
            } else
                return UnitMenuOutput.CONQUERING;

        }
        return UnitMenuOutput.SUCCESSFUL_ATTACK;
    }

    public void figuringNearbyUnits(Soldier unit) {
        ArrayList<Soldier> soldiers = GameInformation.getAllSoldiers();
        int numberOfSoldier = 0;
        if (unit.getType().equals("infantry")) {
            for (int i = 0; i != soldiers.size(); i++) {
                Soldier soldier1 = (Soldier) soldiers.get(i);
                if (soldier1.getX() <= unit.getMaxMove() && soldier1.getY() <= unit.getMaxMove()) {
                    attackUnit(soldier1.getX(), soldier1.getY());
                    if (unit.getState().equals("defensive"))
                        return;
                    ++numberOfSoldier;
                    if (numberOfSoldier == 2) return;
                }
            }
            if (unit.getType().equals("launcher")) {
                for (int i = 0; i != soldiers.size(); i++) {
                    Soldier soldier2 = (Soldier) soldiers.get(i);
                    if (soldier2.getX() <= unit.getMaxMove() && soldier2.getY() <= unit.getMaxMove()) {
                        airAttack(soldier2.getX(), soldier2.getY());
                        return;
                    }
                }
            }
        }
    }

    public void attackEnemy(int x, int y, String name) {
        //Checking what the previous user ordered
        //if !pour oil || build Eq || disband
//        if (soldier.getType().equalsIgnoreCase("wallTarget"))
//            wallTarget(x, y);
    }

    public UnitMenuOutput dropUnit(String name, int x, int y, int count) {
        UnitName type = UnitName.getUnitType(name);
        if (checkLand(x, y)) {
            unitType(type, x, y, count);
            return UnitMenuOutput.SUCCESSFUL_DROP_UNIT;
        } else return UnitMenuOutput.CAN_NOT_DROP_UNIT;
    }

    public void unitType(UnitName unit, int x, int y, int count) {
        switch (unit.getType()) {
            case "launcher":
                createLauncherUnit(unit, x, y, count);
                break;
            case "infantry":
                createInfantryUnit(unit, x, y, count);
                break;
            case "wallTarget":
                createWallTargetUnit(unit, x, y, count);
                break;
        }
    }

    private void createWallTargetUnit(UnitName unit, int x, int y, int count) {
        for (int i = 0; i < count; i++) {
            Soldier soldier2 = new UnitWallTarget(unit.getSpeed(), unit.getAttackingPower(), unit.getDefense(), x, y,
                    unit.getUnitHp(), unit.getMaxMove(), unit.getName(), unit.getType(), "STANDING");
            GameInformation.getCurrentPlayer().getMap()[x][y].setSoldier(soldier2);
            this.government.addUnitWallTarget((UnitWallTarget) soldier2);
            new GameMenuController(this.government.getOwner()).setFearRate(this.government.getFearRate());
        }
    }

    private void createInfantryUnit(UnitName unit, int x, int y, int count) {
        for (int i = 0; i < count; i++) {
            Soldier soldier1 = new InfantryUnit(unit.getSpeed(), unit.getAttackingPower(), unit.getDefense(), x, y,
                    unit.getUnitHp(), unit.getMaxMove(), unit.getName(), unit.getType(), "STANDING");
            GameInformation.getCurrentPlayer().getMap()[x][y].setSoldier(soldier1);
            this.government.addInfantryUnit((InfantryUnit) soldier1);
            new GameMenuController(this.government.getOwner()).setFearRate(this.government.getFearRate());
        }
    }

    private void createLauncherUnit(UnitName unit, int x, int y, int count) {
        for (int i = 0; i < count; i++) {
            Soldier soldier = new LauncherUnit(unit.getSpeed(), unit.getAttackingPower(), unit.getDefense(), x, y,
                    unit.getUnitHp(), unit.getMaxMove(), unit.getName(), unit.getType(), "STANDING", unit.getThrowRange());
            GameInformation.getCurrentPlayer().getMap()[x][y].setSoldier(soldier);
            this.government.addLauncherUnit((LauncherUnit) soldier);
            new GameMenuController(this.government.getOwner()).setFearRate(this.government.getFearRate());
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

    public boolean isUnitSelected() {
        return this.selectedUnit != null;
    }
}
