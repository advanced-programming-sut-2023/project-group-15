package org.example.gameMap;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class TileManager {
    private GamePanel gamePanel;
    private int[][] mapTileNumber;
    private Tile[] tile = new Tile[20];

    public TileManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.mapTileNumber = new int[gamePanel.getMaxWorldCol()][gamePanel.getMaxWorldRow()];
        getTileImage();
        loadMap();
    }

    public void loadMap() {
        try {
            InputStream inputStream = getClass().getResourceAsStream("/map/world01.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            int col = 0;
            int row = 0;

            while (col < gamePanel.getMaxWorldCol() && row < gamePanel.getMaxWorldRow()) {
                String line = bufferedReader.readLine();
                while (col < gamePanel.getMaxWorldCol()) {
                    String numners[] = line.split(" ");
                    int number = Integer.parseInt(numners[col]);
                    mapTileNumber[col][row] = number;
                    col++;
                }
                if (col == gamePanel.getMaxWorldCol()) {
                    col = 0;
                    row++;

                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void getTileImage() {
        try {
            tile[0] = new Tile(ImageIO.read(getClass().getResourceAsStream("/Images/landType/default.jpg")));
            tile[1] = new Tile(ImageIO.read(getClass().getResourceAsStream("/Images/landType/pebble.jpg")));
            tile[2] = new Tile(ImageIO.read(getClass().getResourceAsStream("/Images/landType/bowlder.png")));
            tile[3] = new Tile(ImageIO.read(getClass().getResourceAsStream("/Images/landType/rock.png")));
            tile[4] = new Tile(ImageIO.read(getClass().getResourceAsStream("/Images/landType/iron.jpg")));
            tile[5] = new Tile(ImageIO.read(getClass().getResourceAsStream("/Images/landType/grass.png")));
            tile[6] = new Tile(ImageIO.read(getClass().getResourceAsStream("/Images/landType/meadow.jpg")));
            tile[7] = new Tile(ImageIO.read(getClass().getResourceAsStream("/Images/landType/oil.jpg")));
            tile[8] = new Tile(ImageIO.read(getClass().getResourceAsStream("/Images/landType/plain.png")));
            tile[9] = new Tile(ImageIO.read(getClass().getResourceAsStream("/Images/landType/shallowWater.png")));
            tile[10] = new Tile(ImageIO.read(getClass().getResourceAsStream("/Images/landType/river.png")));
            tile[11] = new Tile(ImageIO.read(getClass().getResourceAsStream("/Images/landType/smallPond.png")));
            tile[12] = new Tile(ImageIO.read(getClass().getResourceAsStream("/Images/landType/bigPond.jpg")));
            tile[13] = new Tile(ImageIO.read(getClass().getResourceAsStream("/Images/landType/beach.jpg")));
            tile[14] = new Tile(ImageIO.read(getClass().getResourceAsStream("/Images/landType/sea.jpg")));
            tile[15] = new Tile(ImageIO.read(getClass().getResourceAsStream("/Images/landType/grassLand.jpg")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void draw(Graphics2D graphics2D) {
        int worldCol = 0;
        int worldRow = 0;

        while (worldCol < gamePanel.getMaxWorldCol() && worldRow < gamePanel.getMaxWorldRow()) {
            int tileNumber = mapTileNumber[worldCol][worldRow];

            int worldX = worldCol * gamePanel.getTileSize();
            int worldY = worldRow * gamePanel.getTileSize();
            int screenX = worldX - gamePanel.getMouse().getWorldX() + gamePanel.getMouse().getScreenX();
            int screenY = worldY - gamePanel.getMouse().getWorldY() + gamePanel.getMouse().getScreenY();
            if (worldX + gamePanel.getTileSize() > gamePanel.getMouse().getWorldX() - gamePanel.getMouse().getScreenX() &&
                    worldX - gamePanel.getTileSize() < gamePanel.getMouse().getWorldX() + gamePanel.getMouse().getScreenX() &&
                    worldY + gamePanel.getTileSize() > gamePanel.getMouse().getWorldY() - gamePanel.getMouse().getScreenY() &&
                    worldY - gamePanel.getTileSize() < gamePanel.getMouse().getWorldY() + gamePanel.getMouse().getScreenY()) {
                graphics2D.drawImage(tile[tileNumber].getImage(), screenX, screenY, gamePanel.getTileSize(), gamePanel.getTileSize(), null);
            }
            worldCol++;

            if (worldCol == gamePanel.getMaxWorldCol()) {
                worldCol = 0;
                worldRow++;
            }
        }
//            for (int i=0;i<10;i++) {
//                graphics2D.drawImage(tile[i].getImage(),i*gamePanel.getOriginalTileSize()*gamePanel.getScale(),i*gamePanel.getOriginalTileSize()*gamePanel.getScale(),gamePanel.getTileSize(),gamePanel.getTileSize(),null);
//            }
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public Tile[] getTile() {
        return tile;
    }
}
