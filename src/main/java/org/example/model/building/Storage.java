package org.example.model.building;

import org.example.model.enums.Source;
public class Storage extends Building{
    private int capacity;
    private final Source sourceType;

    public Storage(int hp, int width, int height, int buildingCost, int capacity, Source sourceType) {
        super(hp, width, height, buildingCost);
        this.capacity = capacity;
        this.sourceType = sourceType;
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

    public Source getSourceType() {
        return sourceType;
    }
}
