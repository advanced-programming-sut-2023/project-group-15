package org.example.gameMap.tileSetter;

import org.example.gameMap.GamePanel;
import org.example.gameMap.SelectedMap;
import org.example.model.Tile;
import org.example.model.gameData.GameInformation;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class TileManager {
    private final GamePanel gamePanel;
    protected final int[][] mapTileNumber;
    protected final TileGraphic[] tile = new TileGraphic[20];
    Graphics2D g2;
    private boolean isSelected;

    public TileManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.mapTileNumber = new int[50][50];
        this.isSelected = false;
        getTileImage();
        loadMap();
    }

    public void loadMap() {
        try {
            InputStream inputStream = getClass().getResourceAsStream("/map/world01.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            int col = 0;
            int row = 0;

            while (col < 50 && row < 50) {
                String line = bufferedReader.readLine();
                while (col < 50) {
                    String numners[] = line.split(" ");
                    int number = Integer.parseInt(numners[col]);
                    mapTileNumber[col][row] = number;
                    col++;
                }
                if (col == 50) {
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
            tile[0] = new TileGraphic(ImageIO.read(getClass().getResourceAsStream("/images1/landType/default.jpg")));
            tile[1] = new TileGraphic(ImageIO.read(getClass().getResourceAsStream("/images1/landType/pebble.jpg")));
            tile[2] = new TileGraphic(ImageIO.read(getClass().getResourceAsStream("/images1/landType/bowlder.png")));
            tile[3] = new TileGraphic(ImageIO.read(getClass().getResourceAsStream("/images1/landType/rock.png")));
            tile[4] = new TileGraphic(ImageIO.read(getClass().getResourceAsStream("/images1/landType/iron.jpg")));
            tile[5] = new TileGraphic(ImageIO.read(getClass().getResourceAsStream("/images1/landType/grass.png")));
            tile[6] = new TileGraphic(ImageIO.read(getClass().getResourceAsStream("/images1/landType/meadow.jpg")));
            tile[7] = new TileGraphic(ImageIO.read(getClass().getResourceAsStream("/images1/landType/oil.jpg")));
            tile[8] = new TileGraphic(ImageIO.read(getClass().getResourceAsStream("/images1/landType/plain.png")));
            tile[9] = new TileGraphic(ImageIO.read(getClass().getResourceAsStream("/images1/landType/shallowWater.png")));
            tile[10] = new TileGraphic(ImageIO.read(getClass().getResourceAsStream("/images1/landType/river.png")));
            tile[11] = new TileGraphic(ImageIO.read(getClass().getResourceAsStream("/images1/landType/smallPond.png")));
            tile[12] = new TileGraphic(ImageIO.read(getClass().getResourceAsStream("/images1/landType/bigPond.jpg")));
            tile[13] = new TileGraphic(ImageIO.read(getClass().getResourceAsStream("/images1/landType/beach.jpg")));
            tile[14] = new TileGraphic(ImageIO.read(getClass().getResourceAsStream("/images1/landType/sea.jpg")));
            tile[15] = new TileGraphic(ImageIO.read(getClass().getResourceAsStream("/images1/landType/grassLand.jpg")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void draw(Graphics2D graphics2D) {
        g2 = graphics2D;
        int worldCol = 0;
        int worldRow = 0;

        while (worldCol < 50 && worldRow < 50) {
            int tileNumber = mapTileNumber[worldCol][worldRow];

            int worldX = worldCol * gamePanel.getTileSize();
            int worldY = worldRow * gamePanel.getTileSize();
            double screenX = worldX - gamePanel.getMouse().getWorldX() + gamePanel.getMouse().getScreenX();
            double screenY = worldY - gamePanel.getMouse().getWorldY() + gamePanel.getMouse().getScreenY();
            if (worldX + gamePanel.getTileSize() > gamePanel.getMouse().getWorldX() - gamePanel.getMouse().getScreenX() &&
                    worldX - gamePanel.getTileSize() < gamePanel.getMouse().getWorldX() + gamePanel.getMouse().getScreenX() &&
                    worldY + gamePanel.getTileSize() > gamePanel.getMouse().getWorldY() - gamePanel.getMouse().getScreenY() &&
                    worldY - gamePanel.getTileSize() < gamePanel.getMouse().getWorldY() + gamePanel.getMouse().getScreenY()) {
                graphics2D.drawImage(tile[tileNumber].getImage(), (int) screenX, (int) screenY, gamePanel.getTileSize(), gamePanel.getTileSize(), null);
            }
            worldCol++;

            if (worldCol == 50) {
                worldCol = 0;
                worldRow++;
            }
        }
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public TileGraphic[] getTile() {
        return tile;
    }

    public void drawFromJson(Graphics2D graphics2D, SelectedMap selectedMap) {
        Tile[][] toDraw = GameInformation.getGameMap();
        int worldCol = 0;
        int worldRow = 0;

//        while (worldCol < selectedMap.getMapSize() && worldRow < selectedMap.getMapSize()) {
//            int tileNumber = toDraw[worldCol][worldRow].getLandType().getTileNumber();
        while (worldCol < 50 && worldRow < 50) {
            int tileNumber = toDraw[worldCol][worldRow].getLandType().getTileNumber();
            int worldX = worldCol * gamePanel.getTileSize();
            int worldY = worldRow * gamePanel.getTileSize();
            double screenX = worldX - gamePanel.getMouse().getWorldX() + gamePanel.getMouse().getScreenX();
            double screenY = worldY - gamePanel.getMouse().getWorldY() + gamePanel.getMouse().getScreenY();
            if (worldX + gamePanel.getTileSize() > gamePanel.getMouse().getWorldX() - gamePanel.getMouse().getScreenX() &&
                    worldX - gamePanel.getTileSize() < gamePanel.getMouse().getWorldX() + gamePanel.getMouse().getScreenX() &&
                    worldY + gamePanel.getTileSize() > gamePanel.getMouse().getWorldY() - gamePanel.getMouse().getScreenY() &&
                    worldY - gamePanel.getTileSize() < gamePanel.getMouse().getWorldY() + gamePanel.getMouse().getScreenY()) {
                graphics2D.drawImage(tile[tileNumber].getImage(), (int) screenX, (int) screenY, gamePanel.getTileSize(), gamePanel.getTileSize(), null);
                screenX = 23 * 48 - gamePanel.getMouse().getWorldX() + gamePanel.getMouse().getScreenX();
                screenY = 7 * 48 - gamePanel.getMouse().getWorldY() + gamePanel.getMouse().getScreenY();
                g2.drawRoundRect((int) screenX, (int) screenY, gamePanel.getTileSize(), gamePanel.getTileSize(), 10, 10);
            }
            worldCol++;

            if (worldCol == 50) {
                worldCol = 0;
                worldRow++;
            }
        }
    }

    public void selectTile(int x, int y) {
        System.out.println("x:"+x+",y:"+y);
        double screenX = x - gamePanel.getMouse().getWorldX() + gamePanel.getMouse().getScreenX();
        double screenY = y - gamePanel.getMouse().getWorldY() + gamePanel.getMouse().getScreenY();
        for (int i = 0; i <= 50; i++) {
            for (int j = 0; j <= 50; j++) {
                int tileX = -115 + i * 48;
                int tileY = -115 + j * 48;
                double xDiff = screenX - tileX;
                double yDiff = screenY - tileY;
                if (xDiff <= gamePanel.getTileSize() && xDiff >= 0 && yDiff <= gamePanel.getTileSize() && yDiff >= 0) {
                    g2.setColor(Color.WHITE);
                    g2.setStroke(new BasicStroke(3));
                    g2.drawRoundRect((int) screenX, (int) screenY, gamePanel.getTileSize(), gamePanel.getTileSize(), 10, 10);
                }
            }
        }
    }
}