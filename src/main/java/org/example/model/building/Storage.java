package org.example.model.building;

import org.example.model.enums.Source;
import org.example.model.enums.products;

public class Storage extends Building{
    private int capacity;
    private final products good;

    public Storage(String name, int hp, int xCoordiante, int yCoordiante, products material1, products material2,
                   int numberOfMaterial1, int numberOfMaterial2, int numberOfWorkers, int capacity, products good) {
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

    public products getGood() {
        return good;
    }
}
