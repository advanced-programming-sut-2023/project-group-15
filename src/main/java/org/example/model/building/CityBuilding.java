package org.example.model.building;


public class CityBuilding extends Building{
    private final int peopleCapacity;

    public CityBuilding(int hp, int width, int height, int buildingCost, int capacity) {
        super(hp, width, height, buildingCost);
        this.peopleCapacity = capacity;
    }

    public int getCapacity() {
        return peopleCapacity;
    }
}
