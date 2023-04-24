package org.example.model.building;


import org.example.model.enums.products;

public class CityBuilding extends Building{
    private final int peopleCapacity;

    public CityBuilding(String name, int hp, int xCoordiante, int yCoordiante, products material1,
                        products material2, int numberOfMaterial1, int numberOfMaterial2, int numberOfWorkers, int peopleCapacity) {
        super(name, hp, xCoordiante, yCoordiante, material1, material2, numberOfMaterial1, numberOfMaterial2, numberOfWorkers);
        this.peopleCapacity = peopleCapacity;
    }

    public int getCapacity() {
        return peopleCapacity;
    }
}
