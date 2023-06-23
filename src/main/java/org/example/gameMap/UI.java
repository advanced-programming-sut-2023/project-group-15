package org.example.gameMap;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class UI extends JPanel {
    Font arial_40, arial_80B;
//    BufferedImage image;
    GamePanel gamePanel;
    Graphics2D g2;
    public boolean messageOn = false;
    public String message = null;
    int messageCounter  = 0;
    public boolean gameFinished = false;
    double playTime ;
    DecimalFormat dFormat = new DecimalFormat("#0.00");
    private int slotCol;
    private int slotRow;

    public UI(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        arial_40 = new Font("Arial" , Font.PLAIN, 40);
        arial_80B = new Font("Arial" , Font.BOLD,80);
        // object key ????
        // inserting an object image here but what ????? !

    }
    public void paint(Graphics g) {
        this.g2 = (Graphics2D) g;
    }
    public void showMessage (String text) {
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D graphics2D) {
        this.g2 = graphics2D;
        g2.setFont(arial_40);
        g2.setColor(Color.WHITE);
        if (gamePanel.getGameState() == GameState.playState) {

        }
        if (gamePanel.getGameState() == GameState.pauseState) {
            drawPauseScreen();
        }
        if (gamePanel.getGameState() == GameState.statusState) {
            drawStatusState();
        }
        if (gamePanel.getGameState() == GameState.InventoryMenu) {
            drawInventoryMenu();
        }
        if (gamePanel.getGameState() == GameState.buildingMenu) {
            drawBuildingMenu();
        }
        if (gamePanel.getGameState() == GameState.gameMenu) {
            //todo:game pause menu ...
        }
    }

    private void drawBuildingMenu() {
        final int frameX = gamePanel.getScreenWidth() / 2 - 800;
        final int frameY = gamePanel.getScreenHeight() / 4 ;
        final int frameWidth = gamePanel.getScreenWidth() - 200;
        final int frameHeight = gamePanel.getScreenHeight() ;
        drawSubWindow(frameX,frameY,frameWidth,frameHeight);
    }

    private void drawInventoryMenu() {
        final int frameX = gamePanel.getTileSize()*9;
        final int frameY = gamePanel.getTileSize();
        final int frameWidth = gamePanel.getTileSize()*6;
        final int frameHeight = gamePanel.getTileSize()*5;
        drawSubWindow(frameX,frameY,frameWidth,frameHeight);
        //cursor
        int cursorX = frameX + (gamePanel.getTileSize() + slotCol);
        int cursorY = frameY + (gamePanel.getTileSize() + slotRow);
        int cursorWidth = gamePanel.getTileSize();
        int cursorHeight = gamePanel.getTileSize();
        //drawing
        g2.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(3));
        g2.drawRoundRect(cursorX,cursorY,cursorWidth,cursorHeight,10,10);
    }

    public void drawStatusState() {
        int frameX = gamePanel.getTileSize()*2;
        int frameY = gamePanel.getTileSize();
        final int frameWidth = gamePanel.getTileSize()*7;
        final int frameHeight = gamePanel.getTileSize()*11;
        drawSubWindow(frameX,frameY,frameWidth,frameHeight);
        printStatus();
    }

    private void printStatus() {
        int x = gamePanel.getTileSize()*3;
        int y = gamePanel.getTileSize()*2 + 10;
        g2.setFont(arial_80B);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,40F));
        printString("Status: ",x,y);
        y += gamePanel.getTileSize()+ 10;
        String stringToPrint = "Level: "+String.valueOf(gamePanel.getPlayerStatus().getLevel());
        printString(stringToPrint,x,y);
        y += gamePanel.getTileSize()+ 10;
        stringToPrint = "Coin: "+String.valueOf(gamePanel.getPlayerStatus().getCoin());
        printString(stringToPrint,x,y);
        y += gamePanel.getTileSize()+ 10;
        stringToPrint = "Tax Rate: "+String.valueOf(gamePanel.getPlayerStatus().getTaxRate());
        printString(stringToPrint,x,y);
        y += gamePanel.getTileSize()+ 10;
        stringToPrint = "Fear Rate: "+String.valueOf(gamePanel.getPlayerStatus().getFearRate());
        printString(stringToPrint,x,y);
        y += gamePanel.getTileSize()+ 10;
        stringToPrint = "Food Rate: "+String.valueOf(gamePanel.getPlayerStatus().getFoodRate());
        printString(stringToPrint,x,y);
        y += gamePanel.getTileSize()+ 10;
        stringToPrint = "Religion: "+String.valueOf(gamePanel.getPlayerStatus().getReligion());
        printString(stringToPrint,x,y);
        y += gamePanel.getTileSize()+ 10;
        stringToPrint = "Popularity: "+String.valueOf(gamePanel.getPlayerStatus().getPopularity());
        printString(stringToPrint,x,y);
    }

    private void printString(String stringToPrint, int frameX, int frameY) {
        g2.drawString(stringToPrint,frameX,frameY);
    }

    private void drawSubWindow(int x, int y, int width, int height) {
        Color c1 = new Color(0,0,0,100);
        g2.setColor(c1);
        g2.fillRoundRect(x,y,width,height,35,35);
        c1 = new Color(255,255,255);
        g2.setStroke(new BasicStroke(5));
        g2.setColor(c1);
        g2.drawRoundRect(x+5,y+5,width-10,height-10,25,25);
        g2.setFont(arial_40);
    }

    public void drawPauseScreen() {
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,80F));
        String text = "PAUSED!";
        int length = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        int x = gamePanel.getScreenWidth()/2 - length/2;
        int y = gamePanel.getScreenHeight()/2;
        g2.drawString(text,x,y);
    }

    public int getSlotCol() {
        return slotCol;
    }

    public int getSlotRow() {
        return slotRow;
    }

    public void setSlotCol(int slotCol) {
        this.slotCol = slotCol;
    }

    public void setSlotRow(int slotRow) {
        this.slotRow = slotRow;
    }
    public void reduceSlotCol() {
        this.slotCol--;
    }
    public void reduceSlotRow() {
        this.slotRow--;
    }
    
}