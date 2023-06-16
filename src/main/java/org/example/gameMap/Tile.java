package org.example.gameMap;

import java.awt.image.BufferedImage;

public class Tile {
    private BufferedImage image;
    private boolean collision = false;
    public Tile(BufferedImage image) {
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

    public boolean getCollision() {
        return collision;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }
}
