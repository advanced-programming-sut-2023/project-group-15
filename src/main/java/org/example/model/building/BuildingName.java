package org.example.model.building;

import org.example.model.enums.Products;

import static org.example.model.enums.Products.*;

public enum BuildingName {
    MARKET(5 , WOOD , 0 , "market" , 10),
    MILL(20, WOOD, 0, null, 1,  FLOUR, null , 2 , "productive" , 10),
    IRON_MINE(20, WOOD, 0, null, 2, IRON, null, 3 , "productive" , 20),
    QUARRY(20, WOOD, 0, null, 3, ROCK, null, 3 , "productive" , 20),
    WOODCUTTER(3, WOOD, 0, null, 1, WOOD, null, 2 , "productive" , 10),
    APPLE_GARDEN(5, WOOD, 0, null, 1, APPLE, null, 4 , "productive" , 15),
    PITCH_RIG(20 , WOOD , 0 , null , 1 , PITCH , null , 2 , "productive" , 20),
    OAT_FARM(5, WOOD, 0, null, 1, OAT, null, 3 , "productive" , 10 ),
    STABLE(20, WOOD, 400, GOLD_COIN, 0, HORSE, null, 2 , "productive" , 10),
    HUNTING_BUILDING(5, WOOD, 0, null, 1, MEAT, null, 2 , "productive" , 20),
    WEAT_FARM(15, WOOD, 0, null, 1, WEAT, null, 3 , "productive" , 10),
    BAKERY(10, WOOD, 0, null, 1, BREAD, null, 2 , "productive" , 10),
    BEER_MAKING(10, WOOD, 0, null, 1, BEER, null, 1 , "productive" , 15),
    ARMOURER(100, GOLD_COIN, 20, WOOD, 1, ARMOUR, null, 2 , "productive" , 20),
    BLACKSMITH(100, GOLD_COIN, 20, WOOD, 1, SWORD, MACE, 2, "productive" , 15),
    POLETURNER(100, GOLD_COIN, 20, WOOD, 1, SPEAR, null, 2 , "productive" , 15),
    FLETCHER(100, GOLD_COIN, 20, WOOD, 1, BOW, null, 2, "productive" , 15 ),
    DIARY( 10 , WOOD , 0 , null , 1 , CHEESE , VEST , 2 , "productive" , 10 ),
    OIL_SMELTLER(10, IRON, 100, GOLD_COIN, 1, OIL_POT, null, 2, "productive" , 15),
    OX_TETHER( 5 , WOOD , 0 , null , 1  ,"productive" , 10 ),

    ARMOURY(5 , WOOD , 100  , "store" , 20),
    SOURCE_STORE( 5, WOOD , 500 , "store" , 15),
    FOODSTORE( 5 , WOOD , 500 , "store" , 15),
    LOOKOUT_TOWER(10 , 0 , ROCK , null , 30 , 30 , "war" , 30),
    PERMETER_TOWER(10 , 0 , ROCK , null , 30 , 30 , "war" , 30),
    DEFEND_TURRET(15 , 0 , ROCK , null , 40 , 40 , "war" , 40),
    SQUARE_TOWER(35 , 0 , ROCK , null , 50 , 50 ,"war" , 40),
    CIRCLE_TOWER(40 , 0 , ROCK , null ,50 , 50 ,"war" , 50),
    BARRAK(10 , 0 , 15 , ROCK  , 0 , null , "city" , 15),
    ENGINEER_GUILD(10 , 20 , 10 , WOOD , 100 , GOLD_COIN , "city" , 15 ),
    MERCENARY_POST(10 , 0 , 10 , WOOD , 0 , null  ,"city" , 15),
    SMALL_STONE_GATEHOUSE(0 , null , 8 , "city" , 15),
    BIG_STONE_GATEHOUSE(20 , ROCK , 10 , "city" , 15 ),
    HOUSE(6 , WOOD , 0 , null , 0 , "city" , 10),
    CAGED_WAR_DOGS(10 , WOOD , 100 , GOLD_COIN , 0  , "city" , 30 ),
    SIEGE_TENT(0, null , 0 , null , 1 , "city" , 30),
    KILLINGPIT( 6 ,  WOOD , 0 , null,0 , "war" , 30),
    PITCH_DITCH( 2 , PITCH , 0 , null , 0 , "city" , 30),
    DRAWBRIDGE(10 , WOOD , 0 , null , 0 , "city" , 30),
    INN( 5 , 20 , WOOD , 100 , GOLD_COIN, "city" , 10),
    CHURCH(2 , 250 , GOLD_COIN , 0 , null, "city" , 15),
    CATHEDRAL(2 , 100 , GOLD_COIN , 0 , null , "city" , 15),





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
    private int hp;

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

    public int getCapacity() {
        return capacity;
    }

    public int getHp() {
        return hp;
    }

    public int getFireRange() {
        return fireRange;
    }

    public int getDefendRange() {
        return defendRange;
    }

    //productive building
    BuildingName(int numberOfMaterial1, Products material1Name, int numberOfMaterial2, Products material2Name,
                 int numberOfWorkers, Products good1, Products good2, int rate,String type , int hp) {
        this.numberOfMaterial1 = numberOfMaterial1;
        this.material1Name = material1Name;
        this.numberOfMaterial2 = numberOfMaterial2;
        this.material2Name = material2Name;
        this.numberOfWorkers = numberOfWorkers;
        this.good1 = good1;
        this.good2 = good2;
        this.rate = rate;
        this.type = type;
        this.hp = hp;
    }
    //storage building
    BuildingName(int numberOfMaterial , Products materialName , int capacity , String type , int hp)
    {
        this.numberOfMaterial = numberOfMaterial ;
        this.materialName = materialName ;
        this.capacity = capacity ;
        this.type = type;
        this.hp = hp;

    }
    // war buildings
    BuildingName(int numberOfMaterial1 , int numberOfMaterial2, Products material1Name , Products material2Name,int fireRange , int defendRange , String type , int hp)
    {
        this.numberOfMaterial1 = numberOfMaterial1;
        this.numberOfMaterial2 = numberOfMaterial2;
        this.material1Name = material1Name;
        this.material2Name = material2Name;
        this.fireRange =  fireRange;
        this.defendRange = defendRange;
        this.type = type;
        this.hp = hp ;
    }
    //city buildings
    BuildingName(int popularityRate, int numberOfMaterial1, Products material1Name , int numberOfMaterial2, Products material2Name , String type , int hp)
    {
        this.numberOfMaterial = numberOfMaterial1;
        this.materialName = material1Name ;
        this.popularityRate = popularityRate ;
        this.numberOfMaterial2 = numberOfMaterial2 ;
        this.material2Name = material2Name ;
        this.type = type ;
        this.hp = hp ;
    }
    BuildingName(int damage , int numberOfMaterial , Products materialName , String type) {
        this.damage = damage;
        this.numberOfMaterial = numberOfMaterial;
        this.materialName = materialName;
        this.type = type;
        this.hp = hp ;
    }

    BuildingName(int numberOfMaterial1 , Products material1Name , int numberOfMaterial2 , Products material2Name, int numberOfWorkers , String type , int hp)
    {
        this.numberOfMaterial1 = numberOfMaterial1 ;
        this.material1Name = material1Name ;
        this.numberOfMaterial2 = numberOfMaterial2 ;
        this.material2Name = material2Name ;
        this.numberOfMaterial2 = numberOfMaterial2 ;
        this.hp = hp ;

    }
    //educations
    BuildingName(int costForEachPerson , int costForEachPerson2 , int numberOfMaterial1 , Products material1Name,
                 int numberOfMaterial2, Products material2Name , String type , int hp)
    {
        this.costForEachPerson = costForEachPerson;
        this.costForEachPerson2 = costForEachPerson2 ;
        this.numberOfMaterial1 = numberOfMaterial1;
        this.material1Name = material1Name ;
        this.numberOfMaterial2 = numberOfMaterial2 ;
        this.material2Name = material2Name ;
        this.type = type ;
        this.hp = hp ;

    }

   /* public static BuildingName getBuildingByName(String name)
    {
        for(BuildingName buildingName : BuildingName.values())
        {
            if(buildingName.equals(name))
                return buildingName;

        }
        return null;

    }*/
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

