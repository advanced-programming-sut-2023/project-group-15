package org.example.gameMap.objectSetter;

import org.example.gameMap.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class AssetSetter {
    private final GamePanel gamePanel;
    private final SuperObject[] allObjects = new SuperObject[8];

    public AssetSetter(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        getObjectTiles();
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }


    public void getObjectTiles() {
        try {
            allObjects[0] = new SuperObject(ImageIO.read(getClass().getResourceAsStream("/images1/buildings/castle.gif")), "castle");
            allObjects[1] = new SuperObject(ImageIO.read(getClass().getResourceAsStream("/images1/buildings/church.png")), "church");
            allObjects[2] = new SuperObject(ImageIO.read(getClass().getResourceAsStream("/images1/buildings/grave.gif")), "grave");
            allObjects[3] = new SuperObject(ImageIO.read(getClass().getResourceAsStream("/images1/buildings/storage.png")), "storage");
            allObjects[4] = new SuperObject(ImageIO.read(getClass().getResourceAsStream("/images1/buildings/store.png")), "store");
            allObjects[5] = new SuperObject(ImageIO.read(getClass().getResourceAsStream("/images1/buildings/tallTower.png")), "tallTower");
            allObjects[6] = new SuperObject(ImageIO.read(getClass().getResourceAsStream("/images1/buildings/tenet.png")), "tenet");
            allObjects[7] = new SuperObject(ImageIO.read(getClass().getResourceAsStream("/images1/buildings/tower.png")), "tower");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void draw(Graphics2D graphics2D, int worldX, int worldY) {
        double screenX = worldX - gamePanel.getMouse().getWorldX() + gamePanel.getMouse().getScreenX();
        double screenY = worldY - gamePanel.getMouse().getWorldY() + gamePanel.getMouse().getScreenY();
        graphics2D.drawImage(allObjects[0].getImage(), (int) screenX, (int) screenY, gamePanel.getTileSize(), gamePanel.getTileSize(), null);
        worldY += gamePanel.getTileSize();
        screenY = worldY - gamePanel.getMouse().getWorldY() + gamePanel.getMouse().getScreenY();
        graphics2D.drawImage(allObjects[4].getImage(), (int) screenX, (int) screenY, gamePanel.getTileSize(), gamePanel.getTileSize(), null);
        System.out.println(worldX + "world" + worldY);
        System.out.println(gamePanel.getMouse().getMouseX() + "mouse" + gamePanel.getMouse().getMouseY());
        System.out.println(screenX + "e" + screenY);
        allObjects[0].setRectangle(worldX, worldY);
    }

    public SuperObject[] getAllObjects() {
        return allObjects;
    }

    public SuperObject[] getAllObjects() {
        return allObjects;
    }
}
