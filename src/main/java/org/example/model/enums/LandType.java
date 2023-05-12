package org.example.model.enums;

import org.example.model.building.BuildingName;

import static org.example.model.building.BuildingName.*;

public enum LandType {
    DEFAULT(null, "D", true),
    PEBBLE(null, "PB", true),
    BOWLDER(null, "B", true),
    ROCK(QUARRY, "R", true),
    IRON(IRON_MINE, "I", true),
    GRASS(null, "G", true),
    MEADOW(null, "M", true),
    PETROLEUM(null, " P", true),
    PLAIN(null, "PL", false),
    SHALLOW_WATER(null, "SW", false),
    RIVER(null, "RI", false),
    SMALL_POND(null, "SP", false),
    BIG_POND(null, "BP", false),
    BEACH(null, "B", true),
    SEA(null, "S", false),
    DENSE_GRASSLAND(OAT_FARM, WEAT_FARM, "DG", true),
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

    LandType(BuildingName name, String mapId) {
        this.buildingName = name;
        this.mapId = mapId;
    }

    LandType(BuildingName name1, BuildingName name2, String mapId, boolean buildingStatus) {
        this.buildingName = name1;
        this.buildingName2 = name2;
        this.mapId = mapId;
        this.buildingStatus = buildingStatus;
    }

    LandType(BuildingName buildingName, String mapId, boolean buildingStatus) {
        this.buildingName = buildingName;
        this.mapId = mapId;
        this.buildingStatus = buildingStatus;
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
}
