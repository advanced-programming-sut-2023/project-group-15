package org.example.model;

import java.util.ArrayList;

public class map {
    int height;
    int weight;
    tiles [][] currentMap = new tiles[200][200];

    public tiles[][] getCurrentMap() {
        return currentMap;
    }
}
