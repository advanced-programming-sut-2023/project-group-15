package org.example.controller;

import org.example.model.MBC.LauncherUnit;
import org.example.model.MBC.Soldier;
import org.example.model.building.Building;
import org.example.model.enums.*;
import org.example.model.gameData.GameInformation;
import org.example.view.enums.outputs.GameInformationOutput;
import org.example.view.enums.outputs.UnitMenuOutput;


import java.util.ArrayList;


public class UnitMenuController {

    public Building building;
    Soldier soldier;
    public int x1, y1;
    public UnitName name;
    public int patX1, patX2, patY1, patY2;
    public int maxRage;
    public boolean stopPatrolling = true;
    public LauncherUnit launcherUnit;

    public UnitMenuOutput selectUnit(int x, int y) {
        if (GameInformation.getCurrentPlayer().getMap()[x][y].getSoldier() != null) {
            soldier = GameInformation.getCurrentPlayer().getMap()[x][y].getSoldier();
            return UnitMenuOutput.UNIT_FOUND;
        } else
            return UnitMenuOutput.UNIT_NOT_FOUND;
    }

    public UnitMenuOutput moveUnit(int x, int y) {
        if (soldier.getState().equals("STANDING"))
            return UnitMenuOutput.NOT_IN_A_STATE;
        int deltaX = Math.abs(x - soldier.getX());
        int deltaY = Math.abs(y - soldier.getY());
        if (GameInformation.getCurrentPlayer().getMap()[x][y].getLandType() != null) {
            LandType landType = GameInformation.getCurrentPlayer().getMap()[x][y].getLandType();
            if (landType.equals(LandType.SHALLOW_WATER) || landType.equals(LandType.RIVER) || landType.equals(LandType.BIG_POND) ||
                    landType.equals(LandType.SEA) || landType.equals(LandType.SMALL_POND) || landType.equals(LandType.ROCK) || landType.equals(LandType.PEBBLE))
                return UnitMenuOutput.UNIT_DO_NOT_ALLOWED_PLACE_THERE;
        }

        int maxMove = soldier.getMaxMove();
        if (deltaX > maxMove || deltaY > maxMove) {
            return UnitMenuOutput.OUT_OF_BOUNDS;
        } else {
            soldier.setX(soldier.getX() + x);
            soldier.setY(soldier.getY() + y);
            return UnitMenuOutput.SUCCESSFUL_MOVE;
        }


    }

    public UnitMenuOutput digTunnel(int x, int y) {
        if (!soldier.getName().equalsIgnoreCase("TUNNELER"))
            return UnitMenuOutput.WRONG_UNIT;
        String checkMove = moveUnit(x, y).getOutput();
        if (checkMove.equals("Your destination is beyond the soldier's power\ntry again"))
            return UnitMenuOutput.OUT_OF_BOUNDS;
        else if (checkMove.equals("unit do not allowed to place there"))
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
        soldier.setState(state);
        switch (state) {
            case "offensive":
                soldier.setMaxMove(soldier.getMaxMove() + 30);
                soldier.setAttackingPower(soldier.getAttackingPower() + 10);
                break;
            default:
                break;
        }
        return UnitMenuOutput.SET_STATE;
    }

    public UnitMenuOutput airAttack(int x, int y) {

        if (!soldier.getType().equals("launcher"))
            return UnitMenuOutput.WRONG_UNIT_FOR_AIR_ATTACK;
        else {
            int deltaX = x - soldier.getX();
            int deltaY = y - soldier.getY();

            maxRage = launcherUnit.getThrowRageForChanging();

            if (deltaX <= maxRage && deltaY <= maxRage) {
                if (GameInformation.getCurrentPlayer().getMap()[x][y].getBuilding() != null) {
                    Building building = GameInformation.getCurrentPlayer().getMap()[x][y].getBuilding();


                    if (building.getHp() > soldier.getAttackingPower())

                        building.setHp(building.getHp() - soldier.getAttackingPower());
                    else
                        GameInformation.getCurrentPlayer().getMap()[x][y].setBuilding(null);
                } else if (GameInformation.getCurrentPlayer().getMap()[x][y].getSoldier() != null) {
                    Soldier unit = GameInformation.getCurrentPlayer().getMap()[x][y].getSoldier();
                    if ((unit.getUnitHp() + unit.getDefense()) > soldier.getAttackingPower())
                        unit.setUnitHp(unit.getUnitHp() + unit.getDefense() - soldier.getAttackingPower());
                    else
                        GameInformation.getCurrentPlayer().getMap()[x][y].setSoldier(null);
                }

                return UnitMenuOutput.SUCCESSFUL_AIR_ATTACK;
            } else return UnitMenuOutput.OUT_OF_BOUNDS;
        }

    }

    public UnitMenuOutput disbandUnit() {
        ArrayList building = GameInformation.getAllBuildings();
        for (int i = 0; i != building.size(); i++) {
            Building building1 = (Building) building.get(i);
            if (building1.getName().equals("Hovel")) {
                int x = building1.getxCoordinate();
                int y = building1.getyCoordinate();
                moveUnit(x, y);
                return UnitMenuOutput.UNIT_DISBANDED;
            }
        }
        return UnitMenuOutput.ERROR_DISBAND;
    }

    public UnitMenuOutput buildEquipment(String equipment) {
        if (soldier.getName().equalsIgnoreCase("ENGINEER")) {
            if (equipment.equalsIgnoreCase("TREBUCHET")) {
                if ((GameInformation.checkForSources(Products.WOOD, 10).equals(
                        GameInformationOutput.SUCCESS.getOutput())) && (GameInformation.checkForSources(Products.ROCK, 5).equals(
                        GameInformationOutput.SUCCESS.getOutput())))
                    return UnitMenuOutput.SUCCESSFUL_BUILD_TREBUCHET;

                else return UnitMenuOutput.NOT_ENOUGH_RESOURCES;
            }
            if (equipment.equalsIgnoreCase("CATAPULTS")) {
                if ((GameInformation.checkForSources(Products.WOOD, 5).equals(
                        GameInformationOutput.SUCCESS.getOutput())) && (GameInformation.checkForSources(Products.ROCK, 5).equals(
                        GameInformationOutput.SUCCESS.getOutput())))
                    return UnitMenuOutput.SUCCESSFUL_BUILD_CATAPULTS;

                return UnitMenuOutput.NOT_ENOUGH_RESOURCES;
            }
            if (equipment.equalsIgnoreCase("PORTABLE SHIELD")) {
                if (GameInformation.checkForSources(Products.IRON, 10).equals(
                        GameInformationOutput.SUCCESS.getOutput()))
                    return UnitMenuOutput.SUCCESSFUL_BUILD_SHIELD;

                return UnitMenuOutput.NOT_ENOUGH_RESOURCES;
            }
            if (equipment.equalsIgnoreCase("BATTERING RAM")) {
                if (GameInformation.checkForSources(Products.WOOD, 20).equals(
                        GameInformationOutput.SUCCESS.getOutput()))
                    return UnitMenuOutput.SUCCESSFUL_BUILD_BATTERING_RAM;

                return UnitMenuOutput.NOT_ENOUGH_RESOURCES;
            }

            return UnitMenuOutput.WRONG_BUILDING_EQ;
        }
        return UnitMenuOutput.WRONG_UNIT_ENGINEER;
    }

    public UnitMenuOutput pourOil(String direction) {

        if (soldier.getName().equalsIgnoreCase("ENGINEER")) {
            ArrayList building = GameInformation.getAllBuildings();
            for (int i = 0; i != building.size(); i++) {
                Building building1 = (Building) building.get(i);
                if (building1.getName().equals("oil smelter")) {
                    int x = building1.getxCoordinate();
                    int y = building1.getyCoordinate();
                    moveUnit(x, y);
                    moveUnit(soldier.getX() - x, soldier.getY() - y);
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

        if (soldier.getName().equalsIgnoreCase("SPEARMEN")) {
            String checkMove = moveUnit(x, y).getOutput();
            if (checkMove.equals("Your destination is beyond the soldier's power\ntry again"))
                return UnitMenuOutput.OUT_OF_BOUNDS;
            else {
                //create ditch
                //GameInformation.getCurrentPlayer().getMap()[x][y].setBuilding();
                return UnitMenuOutput.SUCCESSFUL_DIG_DITCH;
            }
        } else return UnitMenuOutput.WRONG_UNIT_TO_DIG_DITCH;
    }

    public UnitMenuOutput patrolUnit(int x, int y, int x2, int y2) {
        String checkMove = moveUnit(x, y).getOutput();
        if (checkMove.equals("Your destination is beyond the soldier's power\ntry again")) {
            x1 -= x;
            y1 -= y;
            return UnitMenuOutput.OUT_OF_BOUNDS;
        }

        String doubleCheck = moveUnit(x2, y2).getOutput();
        if (doubleCheck.equals("Your destination is beyond the soldier's power\ntry again")) {
            x1 = x1 - (x + x2);
            y1 = y1 - (y + y2);
            return UnitMenuOutput.OUT_OF_BOUNDS;
        }


        System.out.println("unit started patrolling...");


        patX1 = x;
        patY1 = y;
        patX2 = x2;
        patY2 = y2;
        String c = patrolStop(stopPatrolling, x, y, x2, y2).getOutput();

        System.out.println("stopped");
        return UnitMenuOutput.PATROL_UNIT;

    }

    public UnitMenuOutput patrolStop(boolean stopPatrolling, int x, int y, int x2, int y2) {
        while (stopPatrolling == true) {
            String checkMove = moveUnit(x, y).getOutput();
            String doubleCheck = moveUnit(x2, y2).getOutput();
        }
        return UnitMenuOutput.PATROL_UNIT;
    }

    public UnitMenuOutput attackUnit(int x, int y) {
        String checkMove = moveUnit(x, y).toString();
        if (checkMove.equals("Your destination is beyond the soldier's power\ntry again")) {
            return UnitMenuOutput.OUT_OF_BOUNDS;
        } else {
            if (GameInformation.getCurrentPlayer().getMap()[x][y].getSoldier() != null) {
                Soldier unit = GameInformation.getCurrentPlayer().getMap()[x][y].getSoldier();
                if (unit.getUnitHp() + unit.getDefense() > soldier.getAttackingPower())
                    unit.setUnitHp(unit.getUnitHp() + unit.getDefense() - soldier.getAttackingPower());

                else
                    GameInformation.getCurrentPlayer().getMap()[x][y].setSoldier(null);
                return UnitMenuOutput.SUCCESSFUL_ATTACK;
            } else return UnitMenuOutput.UNIT_NOT_FOUND;
        }
    }

    public UnitMenuOutput wallTarget(int x, int y) {
        Building building;
        Soldier unit;

        if ((GameInformation.getCurrentPlayer().getMap()[x][y].getSoldier() != null) && (soldier.getName().equalsIgnoreCase("SPEARMEN") || (soldier.getName().equalsIgnoreCase("MACEMEN")))) {
            attackUnit(x, y);
        }
        if ((GameInformation.getCurrentPlayer().getMap()[x][y].getBuilding() != null) && (soldier.getName().equalsIgnoreCase("SPEARMEN") || soldier.getName().equalsIgnoreCase("MACEMEN") ||
                soldier.getName().equalsIgnoreCase("LADDERMEN") || soldier.getName().equalsIgnoreCase("ASSASSINS"))) {
            if (GameInformation.getCurrentPlayer().getMap()[x][y].getBuilding().getName().equals("Small stone gatehouse") ||
                    GameInformation.getCurrentPlayer().getMap()[x][y].getBuilding().getName().equals("big stone gatehouse")) {
                return UnitMenuOutput.CONQUERING_AND_OPENING_THE_GATE;
            } else
                return UnitMenuOutput.CONQUERING;

        }
        return UnitMenuOutput.SUCCESSFUL_ATTACK;
    }

    public void figuringNearbyUnits(Soldier unit) {
        ArrayList soldiers = GameInformation.getAllSoldiers();
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
        if(soldier.getType().equalsIgnoreCase("wallTarget"))
            wallTarget(x,y);
    }
}
