package org.example.controller;

import org.example.model.MBC.LauncherUnit;
import org.example.model.MBC.Soldier;
import org.example.model.MBC.UnitWallTarget;
import org.example.model.building.Building;
import org.example.model.building.CityBuilding;
import org.example.model.enums.*;
import org.example.model.gameData.GameInformation;
import org.example.view.enums.outputs.GameInformationOutput;
import org.example.view.enums.outputs.UnitMenuOutput;
import org.example.model.building.BuildingName;
import org.example.model.enums.State;

import java.util.ArrayList;


public class UnitMenuController {
    public LauncherUnit launcherUnit;
    public UnitWallTarget unitWallTarget;
    public BuildingName buildingName;
    public Building building;
    Soldier soldier;
    public String type;
    public int x1, y1;
    public UnitName name;
    public int patX1, patX2, patY1, patY2;
    public int bounds;
    public int maxRage;
    public boolean checkSelect = false;
    public boolean stopPatrolling = true;

    public UnitMenuOutput selectUnit(int x, int y) {
        if (GameInformation.getCurrentPlayer().getMap()[x][y].getSoldier() != null) {
            soldier = GameInformation.getCurrentPlayer().getMap()[x][y].getSoldier();
            x1 = x;
            y1 = y;
            return UnitMenuOutput.UNIT_FOUND;
        } else
            return UnitMenuOutput.UNIT_NOT_FOUND;
    }

    public UnitMenuOutput moveUnit(int x, int y) {

        int indexOfType = UnitName.valueOf(type).ordinal();
        int deltaX = Math.abs(x - x1);
        int deltaY = Math.abs(y - y1);
        if (GameInformation.getCurrentPlayer().getMap()[x][y].getLandType() != null) {
            LandType landType = GameInformation.getCurrentPlayer().getMap()[x][y].getLandType();
            if (landType.equals(LandType.SHALLOW_WATER) || landType.equals(LandType.RIVER) || landType.equals(LandType.BIG_POND) ||
                    landType.equals(LandType.SEA) || landType.equals(LandType.SMALL_POND) || landType.equals(LandType.ROCK) || landType.equals(LandType.PEBBLE))
                return UnitMenuOutput.UNIT_DO_NOT_ALLOWED_PLACE_THERE;
        }

            int maxMove = soldier.getMaxMove();
            if (deltaX > maxMove || deltaY > maxMove) {
                bounds++;
                return UnitMenuOutput.OUT_OF_BOUNDS;
            } else {
                x1 += deltaX;
                y1 += deltaY;
                soldier.setX(x1);
                soldier.setY(y1);
                return UnitMenuOutput.SUCCESSFUL_MOVE;
            }


    }

    public UnitMenuOutput digTunnel(int x, int y) {
        if (!type.equals("TUNNELER"))
            return UnitMenuOutput.WRONG_UNIT;
        String checkMove = moveUnit(x, y).getOutput();
        if (checkMove.equals("Your destination is beyond the soldier's power\ntry again"))
            return UnitMenuOutput.OUT_OF_BOUNDS;
        else if (checkMove.equals("unit do not allowed to place there"))
            return UnitMenuOutput.UNIT_DO_NOT_ALLOWED_PLACE_THERE;
        if (GameInformation.getCurrentPlayer().getMap()[x][y].getBuilding() != null) {
            Building building = GameInformation.getCurrentPlayer().getMap()[x][y].getBuilding();
            switch (building.getName()) {
                case "permeter tower", "lookout tower", "defend turret", "square tower", "circle tower":
                    GameInformation.getCurrentPlayer().getMap()[x][y].setBuilding(null);
                    return UnitMenuOutput.SUCCESSFUL_DIG;
                default:
                    return UnitMenuOutput.WRONG_BUILDING;
            }
        } else
            return UnitMenuOutput.WRONG_PLACE_FOR_DOG_TUNNEL;


    }


    private void setState(int x, int y, String state) {
        soldier.setState(state);
    }

    public UnitMenuOutput airAttack(int x, int y) {

        if (UnitName.valueOf(type).ordinal() < 7 || UnitName.valueOf(type).ordinal() > 12)
            return UnitMenuOutput.WRONG_UNIT_FOR_AIR_ATTACK;
        else {
            int deltaX = x - x1;
            int deltaY = y - y1;

            maxRage = launcherUnit.getThrowRageForChanging();

            if (deltaX <= maxRage && deltaY <= maxRage) {
                if (GameInformation.getCurrentPlayer().getMap()[x][y].getBuilding() != null) {
                    Building building = GameInformation.getCurrentPlayer().getMap()[x][y].getBuilding();
                    building.setHp(building.getHp() - soldier.getAttackingPower());
                } else if (GameInformation.getCurrentPlayer().getMap()[x][y].getSoldier() != null) {
                    Soldier unit = GameInformation.getCurrentPlayer().getMap()[x][y].getSoldier();
                    unit.setUnitHp(unit.getUnitHp() + unit.getDefense() - soldier.getAttackingPower());
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
        if (type.toUpperCase().equals("ENGINEER")) {
            if (equipment.toUpperCase().equals("TREBUCHET")) {
                if ((GameInformation.checkForSources(Products.WOOD, 10).equals(
                        GameInformationOutput.SUCCESS)) && (GameInformation.checkForSources(Products.ROCK, 5).equals(
                        GameInformationOutput.SUCCESS)))
                    return UnitMenuOutput.SUCCESSFUL_BUILD_TREBUCHET;

                else return UnitMenuOutput.NOT_ENOUGH_RESOURCES;
            }
            if (equipment.toUpperCase().equals("CATAPULTS")) {
                if ((GameInformation.checkForSources(Products.WOOD, 5).equals(
                        GameInformationOutput.SUCCESS)) && (GameInformation.checkForSources(Products.ROCK, 5).equals(
                        GameInformationOutput.SUCCESS)))
                    return UnitMenuOutput.SUCCESSFUL_BUILD_CATAPULTS;

                return UnitMenuOutput.NOT_ENOUGH_RESOURCES;
            }
            if (equipment.toUpperCase().equals("PORTABLE SHIELD")) {
                if (GameInformation.checkForSources(Products.IRON, 10).equals(
                        GameInformationOutput.SUCCESS))
                    return UnitMenuOutput.SUCCESSFUL_BUILD_SHIELD;

                return UnitMenuOutput.NOT_ENOUGH_RESOURCES;
            }
            if (equipment.toUpperCase().equals("BATTERING RAM")) {
                if (GameInformation.checkForSources(Products.WOOD, 20).equals(
                        GameInformationOutput.SUCCESS))
                    return UnitMenuOutput.SUCCESSFUL_BUILD_BATTERING_RAM;

                return UnitMenuOutput.NOT_ENOUGH_RESOURCES;
            }

            return UnitMenuOutput.WRONG_BUILDING_EQ;
        }
        return UnitMenuOutput.WRONG_UNIT_ENGINEER;
    }

    public UnitMenuOutput pourOil(String direction) {

        if (soldier.getName().toUpperCase().equals("ENGINEER")) {
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

        if (type.toUpperCase().equals("SPEARMEN")) {
            String checkMove = moveUnit(x, y).getOutput();
            if (checkMove.equals("Your destination is beyond the soldier's power\ntry again"))
                return UnitMenuOutput.OUT_OF_BOUNDS;
            else {
                //create ditch
                        GameInformation.getCurrentPlayer().getMap()[x][y].getBuilding();
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
            x1 -= x;
            y1 -= y;
            return UnitMenuOutput.OUT_OF_BOUNDS;
        } else {
            if (GameInformation.getCurrentPlayer().getMap()[x][y].getSoldier() != null) {
                Soldier unit = GameInformation.getCurrentPlayer().getMap()[x][y].getSoldier();
                soldier.setUnitHp(unit.getUnitHp() + unit.getDefense() - soldier.getAttackingPower());
                return UnitMenuOutput.SUCCESSFUL_ATTACK;
            } else return UnitMenuOutput.UNIT_NOT_FOUND;
        }
    }

    public UnitMenuOutput wallTarget(int x, int y) {
        Building building;
        Soldier unit;

        if ((GameInformation.getCurrentPlayer().getMap()[x][y].getSoldier() != null) && (soldier.getName().equals(UnitName.SPEARMEN) || soldier.getName().equals(UnitName.MACEMEN))) {
            attackUnit(x, y);
        }
        if (GameInformation.getCurrentPlayer().getMap()[x][y].getBuilding() != null && (soldier.getName().equals(UnitName.SPEARMEN) || soldier.getName().equals(UnitName.MACEMEN) ||
                soldier.getName().equals(UnitName.LADDERMEN) || soldier.getName().equals(UnitName.ASSASSINS))) {
            if (GameInformation.getCurrentPlayer().getMap()[x][y].getBuilding().getName().equals("Small stone gatehouse") ||
                    GameInformation.getCurrentPlayer().getMap()[x][y].getBuilding().getName().equals("big stone gatehouse")) {
                return UnitMenuOutput.CONQUERING_AND_OPENING_THE_GATE;
            } else
                return UnitMenuOutput.CONQUERING;

        }
        return UnitMenuOutput.SUCCESSFUL_ATTACK;
    }



}
