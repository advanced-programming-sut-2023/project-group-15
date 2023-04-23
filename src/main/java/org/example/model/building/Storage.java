package org.example.model.building;

import org.example.model.enums.Source;
import org.example.model.enums.products;

public class Storage extends Building{
    private int capacity;
    private final products good;

    public Storage(int hp, int width, int height, int buildingCost, int capacity, products good) {
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

    public products getGood() {
        return good;
    }
}
