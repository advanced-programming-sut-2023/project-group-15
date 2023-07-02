package org.example.gameMap.objectSetter;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class SuperObject {
    private BufferedImage bufferedImage;
    private boolean collision = false;
    private Rectangle solidArea ;
    private String name;
    private int worldX;
    private int worldY;
    private static final ArrayList<SuperObject> setObjects = new ArrayList<>();
//    public SuperObject(String name) {
//        this.bufferedImage = findObjectWithName(name).getImage();
//        this.name = name;
//    }
    public SuperObject(BufferedImage bufferedImage,String name) {
        this.bufferedImage = bufferedImage;
        this.name = name;
    }

//    public static SuperObject findObjectWithName(String tenet) {
//        for (SuperObject tempObject : SuperObject.getAllObjects()) {
//            if (tempObject.getName().equals(tenet))
//                return tempObject;
//        }
//        return null;
//    }



    public BufferedImage getImage() {
        return bufferedImage;
    }

    public String getName() {
        return name;
    }

    public int getWorldX() {
        return worldX;
    }

    public int getWorldY() {
        return worldY;
    }

    public void setWorldX(int worldX) {
        this.worldX = worldX;
    }

    public void setWorldY(int worldY) {
        this.worldY = worldY;
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    public void setRectangle(int worldX, int worldY) {
        this.solidArea = new Rectangle(worldX,worldY,48,48);
    }

    public void addToSettedObjects() {
        setObjects.add(this);
    }

    public static ArrayList<SuperObject> getAllSetObjects() {
        return setObjects;
    }

    public void selectSolidArea() {
//        this.getSolidArea().
        Rectangle rectangle = new Rectangle();
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public boolean isCollision() {
        return collision;
    }

    public Rectangle getSolidArea() {
        return solidArea;
    }

    public static ArrayList<SuperObject> getSetObjects() {
        return setObjects;
    }
}
