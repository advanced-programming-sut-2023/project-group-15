package org.example.model.building;


import org.example.model.enums.Products;

public class CityBuilding extends Building{
    private boolean selected;
    public CityBuilding(String name, int hp, int xCoordinate, int yCoordinate, Products material1,
                        Products material2, int numberOfMaterial1, int numberOfMaterial2) {
        super(name, hp, xCoordinate, yCoordinate, material1, material2, numberOfMaterial1, numberOfMaterial2);
    }

}
