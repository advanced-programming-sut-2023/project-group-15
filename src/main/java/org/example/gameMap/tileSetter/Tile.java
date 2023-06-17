package org.example.gameMap.tileSetter;

import java.awt.image.BufferedImage;

public class Tile {
    private final BufferedImage image;
//    private boolean collision = false;
    public Tile(BufferedImage image) {
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

//    public boolean getCollision() {
//        return collision;
//    }

//    public void setCollision(boolean collision) {
//        this.collision = collision;
//    }
}
