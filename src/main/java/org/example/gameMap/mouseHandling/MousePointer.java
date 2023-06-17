package org.example.gameMap.mouseHandling;

import org.example.gameMap.GamePanel;
import org.example.gameMap.keyHandling.KeyHandler;
import org.example.gameMap.objectSetter.SuperObject;

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
    private final BufferedImage image;
    private int worldX = 100;
    private int worldY = 100;
    private final int screenX;
    private final int screenY;
    private int mouseSpeed = 15;
    private int mouseX;
    private int mouseY;
    //    private Position mousePosition;
    private boolean mouseClicked = false;
    private boolean mousePressed = false;
    private boolean mouseReleased = false;
    private boolean mouseEntered = false;
    private boolean mouseExited = false;
    private boolean mouseDragged = false;
    private boolean mouseMoved = false;

    public MousePointer(GamePanel gamePanel, KeyHandler keyHandler,Component... jPanels) {
        for (Component jPanel:jPanels) {
            jPanel.addMouseListener(this);
            jPanel.addMouseMotionListener(this);
        }
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;
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
//        if (mouseHandler.isMouseEntered()) {
//            worldX = (int) mouseHandler.getMousePosition().getX();
//            worldY = (int) mouseHandler.getMousePosition().getY();
//            mouseSpeed += 15;
//        }
//        mouseSpeed -= 15;
        if (keyHandler.getSprint()) {
            mouseSpeed += 15;
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
            mouseSpeed -= 15;
    }



    public void updateMouse(Graphics2D graphics2D) {
//        if (mouseHandler.isMouseEntered()) {
//            graphics2D.drawImage(image, (int) mouseHandler.getMousePosition().getX(), (int) mouseHandler.getMousePosition().getY(), gamePanel.getTileSize(), gamePanel.getTileSize(), null);
//        }
        if (isMouseClicked()) {
//            System.out.printf("Mouse Clicked at position : x:%f y:%f", mouseHandler.getMousePosition().getX(), mouseHandler.getMousePosition().getY());
            System.out.println();
        }
        if (isMouseExited()) {
            System.out.println("mouse exited from the game screen!");
        }
        if (isMouseDragged()) {
//            System.out.println("mouse is dragging from position : x:"+mouseHandler.getMousePosition().getX()+" y:" + mouseHandler.getMousePosition().getY());
        }
        if (isMousePressed()) {
            System.out.println("mouse pressed!");
        }
        if (isMouseReleased()) {
            System.out.println("mouse released!");
        }
        if (isMouseEntered()) {
            System.out.println("mouse entered to the game screen!");
        }
        clearMouseClicked();
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(image, screenX, screenY, gamePanel.getTileSize(), gamePanel.getTileSize(), null);
    }
    private void checkSolidAreas() {
        for (SuperObject object : SuperObject.getAllSetObjects()) {
            if (Math.abs(worldX - object.getWorldX()) <= 48 || Math.abs(worldY - object.getWorldY()) <= 48) {
                object.selectSolidArea();
            }
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        mouseClicked = true;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        mousePressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseReleased = true;
        mousePressed = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        mouseEntered = true;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        mouseExited = true;
        mouseEntered = false;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        e.getComponent().setLocation(e.getX()+e.getComponent().getX()+mouseX,e.getY()+e.getComponent().getY()-mouseY);
//        mousePosition = new Position(e.getPoint().getX(),e.getPoint().getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
//        mousePosition = new Position(e.getPoint().getX(),e.getPoint().getY());
    }
    public void clearMouseClicked() {
        mouseClicked = false;
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
    public boolean isMouseClicked() {
        return mouseClicked;
    }

    public boolean isMousePressed() {
        return mousePressed;
    }

    public boolean isMouseReleased() {
        return mouseReleased;
    }

    public boolean isMouseEntered() {
        return mouseEntered;
    }

    public boolean isMouseExited() {
        return mouseExited;
    }

    public boolean isMouseDragged() {
        return mouseDragged;
    }

    public boolean isMouseMoved() {
        return mouseMoved;
    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }
}
