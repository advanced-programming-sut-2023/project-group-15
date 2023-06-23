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
    }

    public void drawStatusState() {
        int frameX = gamePanel.getTileSize()*2;
        int frameY = gamePanel.getTileSize();
        final int frameWidth = gamePanel.getTileSize()*7;
        final int frameHeight = gamePanel.getTileSize()*11;
        drawSubWindow(frameX,frameY,frameWidth,frameHeight);
        frameX += gamePanel.getTileSize();
        frameY += gamePanel.getTileSize() + 10;
        g2.setFont(arial_80B);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,40F));
        printString("Status: ",frameX,frameY);
        frameY += gamePanel.getTileSize()+ 10;
        String stringToPrint = "Level: "+String.valueOf(gamePanel.getPlayerStatus().getLevel());
        printString(stringToPrint,frameX,frameY);
        frameY += gamePanel.getTileSize()+ 10;
        stringToPrint = "Coin: "+String.valueOf(gamePanel.getPlayerStatus().getCoin());
        printString(stringToPrint,frameX,frameY);
        frameY += gamePanel.getTileSize()+ 10;
        stringToPrint = "Tax Rate: "+String.valueOf(gamePanel.getPlayerStatus().getTaxRate());
        printString(stringToPrint,frameX,frameY);
        frameY += gamePanel.getTileSize()+ 10;
        stringToPrint = "Fear Rate: "+String.valueOf(gamePanel.getPlayerStatus().getFearRate());
        printString(stringToPrint,frameX,frameY);
        frameY += gamePanel.getTileSize()+ 10;
        stringToPrint = "Food Rate: "+String.valueOf(gamePanel.getPlayerStatus().getFoodRate());
        printString(stringToPrint,frameX,frameY);
        frameY += gamePanel.getTileSize()+ 10;
        stringToPrint = "Religion: "+String.valueOf(gamePanel.getPlayerStatus().getReligion());
        printString(stringToPrint,frameX,frameY);
        frameY += gamePanel.getTileSize()+ 10;
        stringToPrint = "Popularity: "+String.valueOf(gamePanel.getPlayerStatus().getPopularity());
        printString(stringToPrint,frameX,frameY);
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

}
