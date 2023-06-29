package org.example.gameMap.tileSetter;

import java.awt.image.BufferedImage;

public class TileGraphic {
    private final BufferedImage image;
    public TileGraphic(BufferedImage image) {
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }
    
}
