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
    }

    private void drawBuildingMenu() {
        final int frameX = gamePanel.getScreenWidth() / 2 - 800;
        final int frameY = gamePanel.getScreenHeight() / 4 - 50;
        final int frameWidth = gamePanel.getScreenWidth() - 320;
        final int frameHeight = gamePanel.getScreenHeight() + 100;
        drawSubWindow(frameX, frameY, frameWidth, frameHeight);
        //cursor
        int cursorX = frameX + 20 + (gamePanel.getTileSize() * slotCol * 4);
        int cursorY = frameY + 20 + (gamePanel.getTileSize() * slotRow * 4);
        int cursorWidth = gamePanel.getTileSize() * 4;
        int cursorHeight = gamePanel.getTileSize() * 4;
        int slotX = frameX + 20 * 4;
        int slotY = frameY + 20 * 4;
        gamePanel.getAssetSetter().getObjectTiles();
        ImageIcon image = new ImageIcon(UI.class.getResource("/images1/buildings/store.png"));
        jLabel = new JLabel(image);
        jLabel.addMouseListener(gamePanel.getMouse());
        jLabel.addMouseMotionListener(gamePanel.getMouse());
        jLabel.setVisible(true);
        gamePanel.add(jLabel);
        gamePanel.revalidate();


//        int count = 1;
//        for (SuperObject object:gamePanel.getAssetSetter().getAllObjects()) {
//            g2.drawImage(object.getBufferedImage(),slotX,slotY,null);
//            count++;
//            if (count>7) {
//                slotY+=20*4;
//                count=1;
//            }
//            slotX+=20*4;
//        }
        //drawing
        g2.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(3));
        g2.drawRoundRect(cursorX, cursorY, cursorWidth, cursorHeight, 30, 30);
    }

    private void drawInventoryMenu() {
        final int frameX = gamePanel.getTileSize() * 9;
        final int frameY = gamePanel.getTileSize();
        final int frameWidth = gamePanel.getTileSize() * 6;
        final int frameHeight = gamePanel.getTileSize() * 5;
        drawSubWindow(frameX, frameY, frameWidth, frameHeight);
        //cursor
        int cursorX = frameX + 20 + (gamePanel.getTileSize() * slotCol);
        int cursorY = frameY + 20 + (gamePanel.getTileSize() * slotRow);
        int cursorWidth = gamePanel.getTileSize();
        int cursorHeight = gamePanel.getTileSize();
        //drawing
        g2.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(3));
        g2.drawRoundRect(cursorX, cursorY, cursorWidth, cursorHeight, 10, 10);
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
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,80F));
        String text = "PAUSED!";
        int length = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        int x = gamePanel.getScreenWidth()/2 - length/2;
        int y = gamePanel.getScreenHeight()/2;
        g2.drawString(text,x,y);
    }

}
