package org.example.model.building;


import org.example.model.enums.Products;

public class CityBuilding extends Building{
    private boolean selected;

    public CityBuilding(String name, int hp, int xCoordiante, int yCoordiante, Products material1,
                        Products material2, int numberOfMaterial1, int numberOfMaterial2) {
        super(name, hp, xCoordiante, yCoordiante, material1, material2, numberOfMaterial1, numberOfMaterial2);
    }

}
