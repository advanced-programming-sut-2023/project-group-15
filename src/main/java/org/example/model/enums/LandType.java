package org.example.model.enums;
import org.example.model.building.buildingName;

import static org.example.model.building.buildingName.*;

public enum LandType {
    DEFAULT(null),
    GRAVEL(null),
    BOWLDER(null),
    ROCK(QUARRY),
    IRON(IRON_MINE),
    GRASS(null),
    MEADOW(null),
    PETROLEUM(null),
    PLALIN(null),
    SHALLOW_WATER(null),
    RIVER(null),
    SMALL_POND(null),
    BIG_POND(null),
    BEACH(null),
    SEA(null),
    DENSE_GRASSLAND(HOP_FARM , WEAT_FARM),
    ;
    private buildingName buildingName;
    private buildingName buildingName2;
    LandType(buildingName name)
    {
        this.buildingName = name;
    }
    LandType(buildingName name1 , buildingName name2)
    {
        this.buildingName = name1 ;
        this.buildingName2 = name2 ;
    }

}
