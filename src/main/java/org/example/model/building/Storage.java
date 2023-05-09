package org.example.model.building;

import org.example.model.enums.Products;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Storage extends Building{
    private int capacity;
    //private final Products good;
    private int freePlace;
    private static HashMap<Products , Integer> goods = new HashMap<>();

    public Storage(String name, int hp, int xCoordiante, int yCoordiante, Products material1, Products material2,
                   int numberOfMaterial1, int numberOfMaterial2, int capacity) {
        super(name, hp, xCoordiante, yCoordiante, material1, material2, numberOfMaterial1, numberOfMaterial2);
        this.capacity = capacity;

    }

    public int showCapacity() {
        return capacity;
    }

    /*public void changingCapacity(int capacity,int flag) {
        if (flag==1) {
            this.capacity+=capacity;
            return;
        }
        this.capacity-=capacity;
    }*/




    public void addToStorage(Products newProduct)
    {
        int currentAmount = 0;
        if(goods.containsKey(newProduct))
     currentAmount = goods.get(newProduct);
    goods.remove(newProduct);
    goods.put(newProduct , currentAmount+1);
    }
    public void addtoStorageWithAmount(Products newProduct , int amount)
    {
        if(goods.containsKey((newProduct)))
            goods.remove(newProduct);
        goods.put(newProduct , amount);

    }
}
