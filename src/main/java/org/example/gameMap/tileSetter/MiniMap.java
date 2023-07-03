package org.example.gameMap.tileSetter;

import org.example.gameMap.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MiniMap extends TileManager {
    private final GamePanel gamePanel;
    private BufferedImage worldMap;
    private boolean miniMapOn;

    public MiniMap(GamePanel gamePanel) {
        super(gamePanel);
        this.gamePanel = gamePanel;
        createWorldMap();
    }

    public void createWorldMap() {
        int worldMapWidth = gamePanel.getTileSize() * 50;
        int worldMapHeight = gamePanel.getTileSize() * 50;
        worldMap = new BufferedImage(worldMapWidth, worldMapHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = (Graphics2D) worldMap.getGraphics();
        int col = 0;
        int row = 0;
        while (col < 50 && row < 50) {
            int tileNum = mapTileNumber[col][row];
            int x = gamePanel.getTileSize() * col;
            int y = gamePanel.getTileSize() * row;
            g2.drawImage(tile[tileNum].getImage(), x, y, null);
            col++;
            if (col == 50) {
                col = 0;
                row++;
            }
        }
    }


    public void drawMiniMap(Graphics2D g2) {
        if (miniMapOn) {
            //map:
            int width = 200;
            int height = 200;
            int x = gamePanel.getScreenWidth() - width - 50;
            int y = 50;
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
            g2.drawImage(worldMap,x, y, width, height, null);
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        }
    }


    public boolean isMiniMapOn() {
        return miniMapOn;
    }

    public void setMiniMapOn(boolean miniMapOn) {
        this.miniMapOn = miniMapOn;
    }
}
