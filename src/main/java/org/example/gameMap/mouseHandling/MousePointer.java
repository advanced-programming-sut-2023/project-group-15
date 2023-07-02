package org.example.gameMap.mouseHandling;

import org.example.gameMap.GamePanel;
import org.example.gameMap.UI;
import org.example.gameMap.keyHandling.KeyHandler;
import org.example.gameMap.objectSetter.SuperObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MousePointer implements MouseListener, MouseMotionListener  {
    private int selectionX;
    private int selectionY;
    private final GamePanel gamePanel;
    private final KeyHandler keyHandler;
    private final BufferedImage image;
    private double worldX = 1000;
    private double worldY = 1000;
    private final int screenX;
    private final int screenY;
    private int mouseSpeed = 15;
    private double mouseX;
    private double mouseY;
    //    private Position mousePosition;
    private boolean mouseClicked = false;
    private boolean mousePressed = false;
    private boolean mouseReleased = false;
    private boolean mouseEntered = false;
    private boolean mouseExited = false;
    private boolean mouseDragged = false;
    private boolean mouseMoved = false;
    private MouseEvent event;

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
            image = ImageIO.read(getClass().getResourceAsStream("/images1/mouse/pointer.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void update() {
//        checkSolidAreas();
        boolean flag = false;
        if (isMouseEntered()) {
//            mouseSpeed += 15;
//            worldX = (int) event.getX();
//            worldY = (int) event.getY();
//            mouseSpeed -= 15;
        }
        if (keyHandler.getSprint()) {
            mouseSpeed += 15;
            flag = true;
        }
        if (keyHandler.isUpPressed() && worldY > -100)
            worldY -= mouseSpeed;
        if (keyHandler.isLeftPressed() && worldX > -100)
            worldX -= mouseSpeed;
        if (keyHandler.isDownPressed() && worldY < 2300)
            worldY += mouseSpeed;
        if (keyHandler.isRightPressed() && worldX < 2300)
            worldX += mouseSpeed;
        if (flag)
            mouseSpeed -= 15;
    }



    public void updateMouse(Graphics2D graphics2D) {
//        if (mouseHandler.isMouseEntered()) {
//            graphics2D.drawImage(image, (int) mouseHandler.getMousePosition().getX(), (int) mouseHandler.getMousePosition().getY(), gamePanel.getTileSize(), gamePanel.getTileSize(), null);
//        }
//        if (isMouseClicked()) {
//            System.out.printf("Mouse Clicked at position : x:%f y:%f", mouseHandler.getMousePosition().getX(), mouseHandler.getMousePosition().getY());
//            System.out.println();
//        }
//        if (isMouseExited()) {
//            System.out.println("mouse exited from the game screen!");
//        }
        if (isMouseDragged()) {
//            System.out.println("mouse is dragging from position : x:"+mouseHandler.getMousePosition().getX()+" y:" + mouseHandler.getMousePosition().getY());
        }
//        if (isMousePressed()) {
//            System.out.println("mouse pressed!");
//        }
//        if (isMouseReleased()) {
//            System.out.println("mouse released!");
//        }
//        if (isMouseEntered()) {
//            System.out.println("mouse entered to the game screen!");
//        }
//        clearMouseClicked();
    }
    public void draw(Graphics2D graphics2D) {
        if (isMouseClicked()) {
            int x = (int) worldX;
            int y = (int) worldY;
//            gamePanel.getTileManager().selectTile(x, y);
        }
        graphics2D.drawImage(image, screenX+100, screenY+100, gamePanel.getTileSize(), gamePanel.getTileSize(), null);
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
        int x = (int) worldX;
        int y = (int) worldY;
        while (true) {
            if (isMouseClicked())
                break;
//            gamePanel.getTileManager().selectTile(x, y);
        }
    }
    public Point startPoint;
    @Override
    public void mousePressed(MouseEvent e) {
//        startPoint = SwingUtilities.convertPoint(UI.jLabel,e.getPoint(),UI.jLabel.getParent());
        System.out.println(worldX+"world"+worldY);
        System.out.println(mouseX+"mouse"+mouseY);
        System.out.println(e.getX()+"e"+e.getY());
        selectionX = e.getX();
        selectionY = e.getY();
//        gamePanel.getTileManager().selectTile((int) worldX, (int) worldY);
        mousePressed = true;
    }


    @Override
    public void mouseReleased(MouseEvent e) {
        startPoint = null;
        mouseReleased = true;
        mousePressed = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        mouseEntered = true;
        event = e;

//        while (mouseEntered) {
//            event = e;
//            worldX = (int) event.getX();
//            worldY = (int) event.getY();
//            mouseSpeed += 15;
//        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        mouseExited = true;
        mouseEntered = false;
//        mouseSpeed -= 15;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
//        e.getComponent().setLocation((e.getX()+e.getComponent().getX()) -selectionX, (e.getY()+e.getComponent().getY()) -selectionY);
        Point location = SwingUtilities.convertPoint(UI.jLabel,e.getPoint(),UI.jLabel.getParent());
        if (UI.jLabel.getParent().getBounds().contains(location)) {
            Point newLocation = UI.jLabel.getLocation();
            newLocation.translate(location.x - startPoint.x,location.y - startPoint.y);
            newLocation.x = Math.max(newLocation.x,0);
            newLocation.y = Math.max(newLocation.y,0);
            newLocation.x = Math.min(newLocation.x ,UI.jLabel.getParent().getWidth() - UI.jLabel.getWidth());
            newLocation.y = Math.min(newLocation.y ,UI.jLabel.getParent().getHeight() - UI.jLabel.getHeight());
            UI.jLabel.setLocation(newLocation);
            startPoint = location;
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
//        gamePanel.getTileManager().selectTile((int) worldX, (int) worldY);
        if (isMouseEntered()) {
            mouseSpeed += 80;
            worldY = e.getY();
            worldX = e.getX();
            mouseSpeed -= 80;
        }
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

    public double getWorldX() {
        return worldX;
    }

    public double getWorldY() {
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

    public double getMouseX() {
        return mouseX;
    }

    public double getMouseY() {
        return mouseY;
    }

    public void setMouseX(double mouseX) {
        this.mouseX = mouseX;
    }

    public void setMouseY(double mouseY) {
        this.mouseY = mouseY;
    }

    public void setWorldX(double worldX) {
        this.worldX = worldX;
    }

    public void setWorldY(double worldY) {
        this.worldY = worldY;
    }

    public int getSelectionX() {
        return selectionX;
    }

    public void setSelectionX(int selectionX) {
        this.selectionX = selectionX;
    }

    public int getSelectionY() {
        return selectionY;
    }

    public void setSelectionY(int selectionY) {
        this.selectionY = selectionY;
    }

}
