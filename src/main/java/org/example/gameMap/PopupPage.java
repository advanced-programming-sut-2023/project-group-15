package org.example.gameMap;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

public class PopupPage {
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
    public PopupPage(GamePanel gamePanel,Graphics2D graphic) {
        this.gamePanel = gamePanel;
        this.g2 = graphic;
        arial_40 = new Font("Arial" , Font.PLAIN, 40);
        arial_80B = new Font("Arial" , Font.BOLD,80);
        // object key ????
        // inserting an object image here but what ????? !

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
    }
    public void drawStatusState() {
        final int frameX = gamePanel.getTileSize()*2;
        final int frameY = gamePanel.getTileSize();
        final int frameWidth = gamePanel.getTileSize()*5;
        final int frameHeight = gamePanel.getTileSize()*10;
        drawSubWindow(frameX,frameY,frameWidth,frameHeight);
    }

    private void drawSubWindow(int x, int y, int width, int height) {
        this.g2 = gamePanel.getGraphics2D();
        g2.setFont(arial_40);
        g2.setColor(Color.WHITE);
        Color c = new Color(0,0,0,210);
        g2.setColor(c);
        g2.fillRoundRect(x,y,width,height,35,35);
        c = new Color(255,255,255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.fillRoundRect(x+5,y+5,width-10,height-10,25,25);

    }

    public void drawPauseScreen() {
        this.g2 = gamePanel.getGraphics2D();
        g2.setFont(arial_40);
        g2.setColor(Color.WHITE);
        String text = "PAUSED!";
        int length = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        int x = gamePanel.getScreenWidth()/2 - length/2;
        int y = gamePanel.getScreenHeight()/2;
        g2.drawString(text,x,y);
    }

}
