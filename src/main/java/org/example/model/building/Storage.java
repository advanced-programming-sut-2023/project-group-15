package org.example.model.building;

import org.example.model.enums.Products;

public class Storage extends Building{
    private int capacity;
    private final Products good;

    public Storage(String name, int hp, int xCoordiante, int yCoordiante, Products material1, Products material2,
                   int numberOfMaterial1, int numberOfMaterial2, int numberOfWorkers, int capacity, Products good) {
        super(name, hp, xCoordiante, yCoordiante, material1, material2, numberOfMaterial1, numberOfMaterial2, numberOfWorkers);
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
