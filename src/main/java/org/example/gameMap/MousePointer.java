package org.example.gameMap;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MousePointer implements MouseListener, MouseMotionListener {
    private final GamePanel gamePanel;
    private final KeyHandler keyHandler;
    private final MouseHandler mouseHandler;
    private final BufferedImage image;
    private int worldX = 100;
    private int worldY = 100;
    private final int screenX;
    private final int screenY;
    private int mouseSpeed = 5;

    public MousePointer(GamePanel gamePanel, KeyHandler keyHandler, MouseHandler mouseHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;
        this.mouseHandler = mouseHandler;
        screenX = (gamePanel.getScreenWidth() - gamePanel.getTileSize()) / 2;
        screenY = (gamePanel.getScreenHeight() - gamePanel.getTileSize()) / 2;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/images/mouse/pointer.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void update() {
        checkSolidAreas();
        boolean flag = false;
        if (keyHandler.getSprint()) {
            mouseSpeed += 10;
            flag = true;
        }
        if (keyHandler.isUpPressed())
            worldY -= mouseSpeed;
        if (keyHandler.isLeftPressed())
            worldX -= mouseSpeed;
        if (keyHandler.isDownPressed())
            worldY += mouseSpeed;
        if (keyHandler.isRightPressed())
            worldX += mouseSpeed;
        if (flag)
            mouseSpeed -= 10;
    }

    private void checkSolidAreas() {
        for (SuperObject object : SuperObject.getAllSetObjects()) {
            if (Math.abs(worldX - object.getWorldX()) <= 48 || Math.abs(worldY - object.getWorldY()) <= 48) {
                object.selectSolidArea();
            }
        }
    }

    public void updateMouse(Graphics2D graphics2D) {
//        if (mouseHandler.isMouseEntered()) {
//            graphics2D.drawImage(image, (int) mouseHandler.getMousePosition().getX(), (int) mouseHandler.getMousePosition().getY(), gamePanel.getTileSize(), gamePanel.getTileSize(), null);
//        }
        if (mouseHandler.isMouseClicked()) {
            System.out.printf("Mouse Clicked at position : x:%f y:%f", mouseHandler.getMousePosition().getX(), mouseHandler.getMousePosition().getY());
            System.out.println();
        }
        if (mouseHandler.isMouseExited()) {
            //TODO:
        }
        if (mouseHandler.isMouseDragged()) {
            //TODO:
        }
        if (mouseHandler.isMousePressed()) {
            //TODO:
        }
        if (mouseHandler.isMouseReleased()) {

        }
        mouseHandler.clearMouseClicked();
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(image, screenX, screenY, gamePanel.getTileSize(), gamePanel.getTileSize(), null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("mouse clicked");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("mouse pressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("mouse released");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("mouse hovered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("mouse exited");
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("mouse dragged");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("mouse moved");
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public KeyHandler getKeyHandler() {
        return keyHandler;
    }

    public BufferedImage getImage() {
        return image;
    }

    public int getWorldX() {
        return worldX;
    }

    public int getWorldY() {
        return worldY;
    }

    public int getScreenX() {
        return screenX;
    }

    public int getScreenY() {
        return screenY;
    }

    public int getMouseSpeed() {
        return mouseSpeed;
    }

}
