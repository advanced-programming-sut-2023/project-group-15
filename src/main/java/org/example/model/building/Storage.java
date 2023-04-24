package org.example.model.building;

import org.example.model.enums.Products;

public class Storage extends Building{
    private int capacity;
    private final Products good;

    public Storage(int hp, int width, int height, int buildingCost, int capacity, Products good) {
        super(hp, width, height, buildingCost);
        this.capacity = capacity;
        this.good = good;
    }

    public int showCapacity() {
        return capacity;
    }

    public void changingCapacity(int capacity,int flag) {
        if (flag==1) {
            this.capacity+=capacity;
            return;
        }
        this.capacity-=capacity;
    }

    public Products getGood() {
        return good;
    }
}
