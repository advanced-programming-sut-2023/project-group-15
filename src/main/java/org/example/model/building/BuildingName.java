package org.example.model.building;

import org.example.model.enums.Products;

import static org.example.model.enums.Products.*;

public enum BuildingName {
    //TODO the rate & capacity & cost should be specified for each building
    MILL(20, WOOD, 0, null, 1,  FLOUR, null , 100 , "productive"),
    IRON_MINE(20, WOOD, 0, null, 2, IRON, null, 100 , "productive"),
    QUARRY(20, WOOD, 0, null, 3, ROCK, null, 100 , "productive"),
    WOODCUTTER(3, WOOD, 0, null, 1, WOOD, null, 100 , "productive"),
    APPLE_GARDEN(5, WOOD, 0, null, 1, APPLE, null, 100 , "productive"),
    PITCH_RIG(20 , WOOD , 0 , null , 1 , PITCH , null , 100 , "productive"),
    OAT_FARM(5, WOOD, 0, null, 1, HOP, null, 100 , "productive"),
    STABLE(20, WOOD, 400, GOLD_COIN, 0, HORSE, null, 100 , "productive"),
    HUNTING_BUILDING(5, WOOD, 0, null, 1, MEAT, null, 100 , "productive"),
    WEAT_FARM(15, WOOD, 0, null, 1, WEAT, null, 100 , "productive"),
    BAKERY(10, WOOD, 0, null, 1, BREAD, null, 100 , "productive"),
    BEER_MAKING(10, WOOD, 0, null, 1, BEER, null, 100 , "productive"),
    ARMOURER(100, GOLD_COIN, 20, WOOD, 1, ARMOUR, null, 100 , "productive"),
    BLACKSMITH(100, GOLD_COIN, 20, WOOD, 1, SWORD, MACE, 100, "productive"),
    POLETURNER(100, GOLD_COIN, 20, WOOD, 1, SPEAR, null, 100 , "productive"),
    FLETCHER(100, GOLD_COIN, 20, WOOD, 1, ARCHE, null, 100, "productive"),
    OIL_SMELTLER(10, IRON, 100, GOLD_COIN, 1, OIL_POT, null, 100, "productive"),
    ARMOURY(5 , WOOD , 100  , "war"),
    OX_TETHER( 5 , WOOD , 0 , null , 1  ,"transfration" ),
    BARRAK(10 , 0 , 15 , ROCK  , 0 , null , "educative"),
    ENGINEER_GUILD(10 , 20 , 10 , WOOD , 100 , GOLD_COIN , "educative"  ),
    MERCENARY_POST(10 , 0 , 10 , WOOD , 0 , null  ,"educative"),
    STORE( 5, WOOD , 100 , "store" ),
    FOODSTORE( 5 , WOOD , 100 , "store"),
    LOOKOUT_TOWER(100 , 100 , "war"),
    PERMETER_TOWER(100 , 100 , "war"),
    DEFEND_TURRET(100 , 100 , "war"),
    SQUARE_TOWER(100 , 100 ,"war" ),
    CIRCLE_TOWER(100 , 100 ,"war"),
    SMALL_STONE_GATEHOUSE(0 , null , 8 , "city"),
    BIG_STONE_GATEHOUSE(20 , ROCK , 10 , "city" ),
    HOUSE(6 , WOOD , 0 , null , 0 , "city"),
    INN( 5 , 20 , WOOD , 100 , GOLD_COIN, "city"),
    CHURCH(2 , 250 , GOLD_COIN , 0 , null, "city" ),
    CATHERDAL(2 , 100 , GOLD_COIN , 0 , null , "city"),
    KILLINGPIT( 10 ,6 , WOOD , "war"),
    CAGED_WAR_DOGS(10 , WOOD , 100 , GOLD_COIN , 0  , "war"),
    SIEGE_TENT(0, null , 0 , null , 1 , "city"),
    PITCH_DITCH( 2 , PITCH , 0 , null , 0 , "city"),
    DRAWBRIDGE(10 , WOOD , 0 , null , 0 , "city"),



    ;
    private int numberOfMaterial1;
    private int numberOfMaterial2;
    private Products material1Name;
    private Products material2Name;
    private int numberOfMaterial;
    private Products materialName;
    private int numberOfWorkers;
    private Products good1;
    private Products good2;
    private int rate;
    private int capacity;
    private int fireRange;
    private int defendRange;
    private int popularityRate;
    private int damage;
    private int costForEachPerson;
    private int costForEachPerson2;
    private String type;

    public int getNumberOfMaterial1() {
        return numberOfMaterial1;
    }

    public int getNumberOfMaterial2() {
        return numberOfMaterial2;
    }

    public Products getMaterial1Name() {
        return material1Name;
    }

    public Products getMaterial2Name() {
        return material2Name;
    }

    public int getNumberOfMaterial() {
        return numberOfMaterial;
    }

    public Products getMaterialName() {
        return materialName;
    }

    public int getNumberOfWorkers() {
        return numberOfWorkers;
    }

    public Products getGood1() {
        return good1;
    }

    public Products getGood2() {
        return good2;
    }

    public int getRate() {
        return rate;
    }

    //productive building
    BuildingName(int numberOfMaterial1, Products material1Name, int numberOfMaterial2, Products material2Name,
                 int numberOfWorkers, Products good1, Products good2, int rate,String type) {
        this.numberOfMaterial1 = numberOfMaterial1;
        this.material1Name = material1Name;
        this.numberOfMaterial2 = numberOfMaterial2;
        this.material2Name = material2Name;
        this.numberOfWorkers = numberOfWorkers;
        this.good1 = good1;
        this.good2 = good2;
        this.rate = rate;
        this.type = type;
    }
    //storage building
    BuildingName(int numberOfMaterial , Products materialName , int capacity , String type)
    {
        this.numberOfMaterial = numberOfMaterial ;
        this.materialName = materialName ;
        this.capacity = capacity ;
        this.type = type;

    }
    // war buildings
    BuildingName(int fireRange , int defendRange , String type)
    {
        this.fireRange =  fireRange;
        this.defendRange = defendRange;
        this.type = type;
    }
    //city buildings
    BuildingName(int popularityRate, int numberOfMaterial1, Products material1Name , int numberOfMaterial2, Products material2Name , String type)
    {
        this.numberOfMaterial = numberOfMaterial1;
        this.materialName = material1Name ;
        this.popularityRate = popularityRate ;
        this.numberOfMaterial2 = numberOfMaterial2 ;
        this.material2Name = material2Name ;
        this.type = type ;
    }
    BuildingName(int damage , int numberOfMaterial , Products materialName , String type) {
        this.damage = damage;
        this.numberOfMaterial = numberOfMaterial;
        this.materialName = materialName;
        this.type = type;
    }

    BuildingName(int numberOfMaterial1 , Products material1Name , int numberOfMaterial2 , Products material2Name, int numberOfWorkers , String type)
    {
        this.numberOfMaterial1 = numberOfMaterial1 ;
        this.material1Name = material1Name ;
        this.numberOfMaterial2 = numberOfMaterial2 ;
        this.material2Name = material2Name ;
        this.numberOfMaterial2 = numberOfMaterial2 ;

    }
    //educations
    BuildingName(int costForEachPerson , int costForEachPerson2 , int numberOfMaterial1 , Products material1Name,
                 int numberOfMaterial2, Products material2Name , String type)
    {
        this.costForEachPerson = costForEachPerson;
        this.costForEachPerson2 = costForEachPerson2 ;
        this.numberOfMaterial1 = numberOfMaterial1;
        this.material1Name = material1Name ;
        this.numberOfMaterial2 = numberOfMaterial2 ;
        this.material2Name = material2Name ;
        this.type = type ;

    }
    public static BuildingName getBuildingByName(String name)
    {
        for(BuildingName buildingName : BuildingName.values())
        {
            if(buildingName.equals(name))
                return buildingName;

        }
        return null;

    }
    public BuildingName getBuildingName(String name)
    {
        for(BuildingName buildingName : BuildingName.values())
        {
            if(buildingName .equals(name))
                return buildingName;

        }
        return null;
    }

    public static String getBuildingType(String name)
    {
        for(BuildingName buildingName : BuildingName.values())
        {
            if(buildingName.equals(name))
                return buildingName.type;
        }
        return null;
    }



}

