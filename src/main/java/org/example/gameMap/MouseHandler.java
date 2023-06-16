package org.example.gameMap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseHandler implements MouseListener, MouseMotionListener {

    private int mouseX;
    private int mouseY;

    private Position mousePosition;
    private boolean mouseClicked = false;
    private boolean mousePressed = false;
    private boolean mouseReleased = false;
    private boolean mouseEntered = false;
    private boolean mouseExited = false;
    private boolean mouseDragged = false;
    private boolean mouseMoved = false;

    public MouseHandler(Component... jPanels) {
        for (Component jPanel:jPanels) {
            jPanel.addMouseListener(this);
            jPanel.addMouseMotionListener(this);
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
        mousePosition = new Position(e.getPoint().getX(),e.getPoint().getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mousePosition = new Position(e.getPoint().getX(),e.getPoint().getY());
    }

    public void clearMouseClicked() {
        mouseClicked = false;
    }

    public Position getMousePosition() {
        return mousePosition;
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
