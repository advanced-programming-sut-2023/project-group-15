package org.example.model.building;

import org.example.model.enums.Products;
import org.example.model.enums.StoreProducts;
import org.example.Server.gameData.GameInformation;

import java.util.Objects;

public class ProductiveBuilding extends Building {
    private final int rate;
    private final Products product1;
    private final Products product2;
    private final int numberOfWorkers;

    public ProductiveBuilding(String name, int hp, int xCoordinate, int yCoordinate, Products material1, Products material2, int numberOfMaterial1,
                              int numberOfMaterial2, int numberOfWorkers, int rate
            , Products product1, Products product2) {
        super(name, hp, xCoordinate, yCoordinate, material1, material2, numberOfMaterial1, numberOfMaterial2);
        this.rate = rate;
        this.product1 = product1;
        this.product2 = product2;
        this.numberOfWorkers = numberOfWorkers;
    }


    public Products getProduct1() {
        return product1;
    }

    public Products getProduct2() {
        return product2;
    }

    public int getRate() {
        return rate;
    }

    public void production() {
        int currentTurn = GameInformation.getCurrentPlayer().getTurn();
        Products product1 = this.getProduct1();
        Products product2 = this.getProduct2();
        if (currentTurn % this.rate == 0) {
            findStorage(product1);
            findStorage(product2);
        }
    }


    private void findStorage(Products product) {
        String buildingName = null;
        Storage storage;
        if (product != null) {
            for (StoreProducts storeProducts : StoreProducts.values()) {
                if (String.valueOf(storeProducts).equals(String.valueOf(storeProducts))) {
                    buildingName = storeProducts.getStoreType();
                    break;
                }
            }
            storage = (Storage) GameInformation.findBuilding(buildingName, GameInformation.getCurrentPlayer());
            Objects.requireNonNull(storage).addToStorage(product1);
        }
    }
}


