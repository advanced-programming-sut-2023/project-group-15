package model.building;


public class CityBuilding extends Building{
    private final int capacity;

    public CityBuilding(int hp, int width, int height, int buildingCost, int capacity) {
        super(hp, width, height, buildingCost);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}
