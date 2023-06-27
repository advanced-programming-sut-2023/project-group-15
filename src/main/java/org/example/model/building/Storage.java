package org.example.model.building;

import org.example.model.enums.Products;

import java.util.HashMap;

public class Storage extends Building {
    private final int capacity;
    private int freePlace = 100;
    private  HashMap<Products, Integer> goods = new HashMap<>();

    public Storage(String name, int hp, int xCoordinate, int yCoordinate, Products material1, Products material2,
                   int numberOfMaterial1, int numberOfMaterial2, int capacity , HashMap<Products , Integer> hashMap) {
        super(name, hp, xCoordinate, yCoordinate, material1, material2, numberOfMaterial1, numberOfMaterial2);
        this.capacity = capacity;
        this.goods = hashMap;

    }

    public int showCapacity() {
        return capacity;
    }

    public int getFreePlace() {
        return freePlace;
    }

    public void setFreePlace(int freePlace) {
        this.freePlace = freePlace;
    }

    public void addToStorage(Products newProduct) {
        int currentAmount = 0;
        if(freePlace != 0) {
            if (goods.containsKey(newProduct))
                currentAmount = goods.get(newProduct);
            goods.remove(newProduct);
            goods.put(newProduct, currentAmount + 1);
            int currentFreePlace = getFreePlace();
            setFreePlace(currentFreePlace - 1);
        }
    }

    public void addonStorageWithAmount(Products newProduct, int amount) {
        if(this.freePlace >= amount) {
            if (goods.containsKey((newProduct)))
                goods.remove(newProduct);
            goods.put(newProduct, amount);
            int currentFreePlace = this.getFreePlace();
            setFreePlace(currentFreePlace - amount);
        }
    }

    public HashMap<Products, Integer> getGoods() {
        return goods;
    }
}
