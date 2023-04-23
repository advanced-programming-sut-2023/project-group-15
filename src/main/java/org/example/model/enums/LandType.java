package org.example.model.enums;
import org.example.model.building.buildingName;

import static org.example.model.building.buildingName.*;

public enum LandType {
    DEFAULT(null , "D"),
    PEBBEL(null , "PB"),
    BOWLDER(null , "B"),
    ROCK(QUARRY , "R"),
    IRON(IRON_MINE , "I"),
    GRASS(null , "G"),
    MEADOW(null , "M"),
    PETROLEUM(null , " P"),
    PLALIN(null ,"PL"),
    SHALLOW_WATER(null ,"SW"),
    RIVER(null , "RI"),
    SMALL_POND(null , "SP"),
    BIG_POND(null , "BP"),
    BEACH(null , "B"),
    SEA(null,  "S"),
    DENSE_GRASSLAND(HOP_FARM , WEAT_FARM , "DG"),
    ;
    private buildingName buildingName;
    private buildingName buildingName2;
    private String mapId;

    LandType(buildingName name , String mapId)
    {
        this.buildingName = name;
        this.mapId = mapId ;
    }
    LandType(buildingName name1 , buildingName name2 , String mapId)
    {
        this.buildingName = name1 ;
        this.buildingName2 = name2 ;
        this.mapId = mapId ;
    }

    public String getMapId() {
        return mapId;
    }
}
