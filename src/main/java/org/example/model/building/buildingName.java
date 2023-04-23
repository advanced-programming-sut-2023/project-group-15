package org.example.model.building;

import org.example.model.enums.Source;
import org.example.model.enums.products;

import static org.example.model.enums.products.*;

public enum buildingName {
    //TODO the rate & capacity & cost should be specified for each building
    MILL(20, WOOD, 0, null, 1, null, FLOUR, 100),
    IRON_MINE(20, WOOD, 0, null, 2, IRON, null, 100),
    QUARRY(20, WOOD, 0, null, 3, ROCK, null, 100),
    WOODCUTTER(3, WOOD, 0, null, 1, WOOD, null, 100),
    APPLE_GARDEN(5, WOOD, 0, null, 1, APPLE, null, 100),
    PITCH_RIG(20 , WOOD , 0 , null , 1 , PITCH , null , 100),
    HOP_FARM(5, WOOD, 0, null, 1, HOP, null, 100),
    HUNTING_BUILDING(5, WOOD, 0, null, 1, MEAT, null, 100),
    WEAT_FARM(15, WOOD, 0, null, 1, WEAT, null, 100),
    BAKERY(10, WOOD, 0, null, 1, BREAD, null, 100),
    BEER_MAKING(10, WOOD, 0, null, 1, BEER, null, 100),
    ARMOURER(100, GOLD_COIN, 20, WOOD, 1, ARMOUR, null, 100),
    BLACKSMITH(100, GOLD_COIN, 20, WOOD, 1, SWORD, MACE, 100),
    POLETURNER(100, GOLD_COIN, 20, WOOD, 1, SPEAR, null, 100),
    FLETCHER(100, GOLD_COIN, 20, WOOD, 1, ARCHE, null, 100),
    OIL_SMELTLER(10, IRON, 100, GOLD_COIN, 1, OILPOT, null, 100),
    STABLE(20, WOOD, 400, GOLD_COIN, 0, HORSE, null, 100),
    ARMOURY(5 , WOOD , 100 ),
    OX_TETHER( 5 , WOOD , 0 , null ,  1 ),
    BARRAK(10 , 0 , 15 , ROCK  , 0 , null),
    ENGINEER_GUILD(10 , 20 , 10 , WOOD , 100 , GOLD_COIN  ),
    MERCENARY_POST(10 , 0 , 10 , WOOD , 0 , null ),
    STORE( 5, WOOD , 100 ),
    FOODSTORE( 5 , WOOD , 100),
    LOOKOUT_TOWER(100 , 100),
    PERMETER_TOWER(100 , 100),
    DEFEND_TURRET(100 , 100),
    SQUARE_TOWER(100 , 100),
    CIRCLE_TOWER(100 , 100),
    SMALL_STONE_GATEHOUSE(0 , null , 8),
    BIG_STONE_GATEHOUSE(20 , ROCK , 10),
    HOUSE(6 , WOOD , 0 , null , 0),
    INN( 5 , 20 , WOOD , 100 , GOLD_COIN ),
    CHURCH(2 , 250 , GOLD_COIN , 0 , null ),
    CATHERDAL(2 , 100 , GOLD_COIN , 0 , null),
    KILLINGPIT( 10 ,6 , WOOD ),
    CAGED_WAR_DOGS(10 , WOOD , 100 , GOLD_COIN , 0),
    SIEGE_TENT(0, null , 0 , null , 1),
    PITCH_DITCH( 2 , PITCH , 0 , null , 0),
    DRAWBRIDGE(10 , WOOD , 0 , null , 0),



    ;
    private int numberOfMaterial1;
    private int numberOfMaterial2;
    private products material1Name;
    private products material2Name;
    private int numberOfMaterial;
    private products materialName;
    private int numberOfWorkers;
    private products good1;
    private products good2;
    private int rate;
    private int capacity;
    private int fireRange;
    private int defendRange;
    private int popularityRate;
    private int damage;
    private int costForEachPerson;
    private int costForEachPerson2;



    //productive building
    buildingName(int numberOfMaterial1, products material1Name, int numberOfMaterial2, products material2Name,
                 int numberOfWorkers, products good1, products good2, int rate) {
        this.numberOfMaterial1 = numberOfMaterial1;
        this.material1Name = material1Name;
        this.numberOfMaterial2 = numberOfMaterial2;
        this.material2Name = material2Name;
        this.numberOfWorkers = numberOfWorkers;
        this.good1 = good1;
        this.good2 = good2;
        this.rate = rate;
    }
    //storage building
    buildingName(int numberOfMaterial , products materialName , int capacity)
    {
        this.numberOfMaterial = numberOfMaterial ;
        this.materialName = materialName ;
        this.capacity = capacity ;

    }
    // war buildings
    buildingName(int fireRange , int defendRange)
    {
        this.fireRange =  fireRange;
        this.defendRange = defendRange;
    }
    //city buildings
    buildingName(int popularityRate,int numberOfMaterial1, products material1Name , int numberOfMaterial2, products material2Name)
    {
        this.numberOfMaterial = numberOfMaterial1;
        this.materialName = material1Name ;
        this.popularityRate = popularityRate ;
        this.numberOfMaterial2 = numberOfMaterial2 ;
        this.material2Name = material2Name ;
    }
    buildingName(int damage , int numberOfMaterial , products materialName)
    {
        this.damage = damage;
        this.numberOfMaterial = numberOfMaterial ;
        this.materialName = materialName ;
    }
    buildingName(int numberOfMaterial1 , products material1Name , int numberOfMaterial2 , products material2Name, int numberOfWorkers)
    {
        this.numberOfMaterial1 = numberOfMaterial1 ;
        this.material1Name = material1Name ;
        this.numberOfMaterial2 = numberOfMaterial2 ;
        this.material2Name = material2Name ;
        this.numberOfMaterial2 = numberOfMaterial2 ;

    }
    //educations
    buildingName(int costForEachPerson , int costForEachPerson2 , int numberOfMaterial1 , products material1Name,int numberOfMaterial2, products material2Name)
    {
        this.costForEachPerson = costForEachPerson;
        this.costForEachPerson2 = costForEachPerson2 ;
        this.numberOfMaterial1 = numberOfMaterial1;
        this.material1Name = material1Name ;
        this.numberOfMaterial2 = numberOfMaterial2 ;
        this.material2Name = material2Name ;
    }



    }


