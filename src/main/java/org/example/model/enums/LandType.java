package org.example.model.enums;
import org.example.model.building.BuildingName;

import static org.example.model.building.BuildingName.*;

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
    private BuildingName buildingName;
    private BuildingName buildingName2;
    private String mapId;

    LandType(BuildingName name , String mapId)
    {
        this.buildingName = name;
        this.mapId = mapId ;
    }
    LandType(BuildingName name1 , BuildingName name2 , String mapId)
    {
        this.buildingName = name1 ;
        this.buildingName2 = name2 ;
        this.mapId = mapId ;
    }
    public static LandType getLandType(String type)
    {
        for(LandType landType : LandType.values())
            if(landType.equals(type))
                return landType;
        return null;
    }


    public String getMapId() {
        return mapId;
    }
}
