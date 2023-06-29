package org.example.model.enums;

import org.example.model.building.BuildingName;

import static org.example.model.building.BuildingName.*;

public enum LandType {
    DEFAULT(null, "D", true,1),
    PEBBLE(null, "PB", true,1),
    BOWLDER(null, "B", true,2),
    ROCK(QUARRY, "R", true,3),
    IRON(IRON_MINE, "I", true,4),
    GRASS(null, "G", true,5),
    MEADOW(null, "M", true,6),
    PETROLEUM(null, " P", true,7),
    PLAIN(null, "PL", false,8),
    SHALLOW_WATER(null, "SW", false,9),
    RIVER(null, "RI", false,10),
    SMALL_POND(null, "SP", false,11),
    BIG_POND(null, "BP", false,12),
    BEACH(null, "B", true,13),
    SEA(null, "S", false,14),
    DENSE_GRASSLAND(OAT_FARM, WEAT_FARM, "DG", true,15),
    ;
    private final BuildingName buildingName;
    private BuildingName buildingName2;

    public BuildingName getBuildingName() {
        return buildingName;
    }

    public BuildingName getBuildingName2() {
        return buildingName2;
    }


    private boolean buildingStatus;
    private final String mapId;
    private int tileNumber;


    LandType(BuildingName name1, BuildingName name2, String mapId, boolean buildingStatus,int tileNumber) {
        this.buildingName = name1;
        this.buildingName2 = name2;
        this.mapId = mapId;
        this.buildingStatus = buildingStatus;
        this.tileNumber = tileNumber;
    }

    LandType(BuildingName buildingName, String mapId, boolean buildingStatus,int tileNumber) {
        this.buildingName = buildingName;
        this.mapId = mapId;
        this.buildingStatus = buildingStatus;
        this.tileNumber = tileNumber;
    }

    public boolean isBuildingStatus() {
        return buildingStatus;
    }

    public static LandType getLandType(String type) {
        for (LandType landType : LandType.values())
            if (String.valueOf(landType).equals(type))
                return landType;
        return null;
    }

    public String getMapId() {
        return mapId;
    }

    public int getTileNumber() {
        return tileNumber;
    }
}
