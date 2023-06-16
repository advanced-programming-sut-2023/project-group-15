package org.example.gameMap;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements Runnable {
    private final int originalTileSize = 16;
    private final int scale = 3;
    private final int tileSize = originalTileSize * scale;
    private final int maxScreenCol = 16;
    private final int maxScreenRow = 12;
    private final int screenWidth = tileSize * maxScreenCol;
    private final int screenHeight = tileSize * maxScreenRow;
    private final int FPS = 60;

    private final int maxWorldCol = 50;
    private final int maxWorldRow = 50;
    private final int worldWidth = tileSize * maxWorldCol ;
    private final int worldHeight = tileSize * maxWorldRow;

    private GameState gameState;
    private KeyHandler keyHandler = new KeyHandler(this);
    private MouseHandler mouseHandler = new MouseHandler(getComponents());
    private AssetSetter assetSetter;
    private MousePointer mouse = new MousePointer(this,keyHandler,mouseHandler);
    private TileManager tileManager;
    private Thread gameThread;
    //for FullScreen
    private final int fullScreenWidth = screenWidth;
    private final int fullScreenHeight = screenHeight;
    private BufferedImage screenImage;
    private Graphics2D graphics2D;
    public GamePanel() {
        this.gameState = GameState.playState;
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.tileManager = new TileManager(this);
        this.assetSetter = new AssetSetter(this);
        this.addKeyListener(keyHandler);
        this.addMouseListener(mouseHandler);
        this.addMouseMotionListener(mouseHandler);
        this.setFocusable(true);
//        setUpFullScreen();
        startGameThread();
    }
    public void setUpFullScreen() {
        screenImage = new BufferedImage(screenWidth,screenHeight,BufferedImage.TYPE_INT_ARGB);
        graphics2D = (Graphics2D) screenImage.getGraphics();
    }
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime ;

        while (gameThread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;
            if (delta >= 1) {
                update();
                repaint();
//                painComponentForFullScreenMode();
//                drawToFullScreen();
                delta --;
            }
        }
    }

    public void update() {
        mouse.update();
        mouse.updateMouse(graphics2D);
    }

    public void painComponentForFullScreenMode() {
        tileManager.draw(graphics2D);
        mouse.draw(graphics2D);
    }

    public void drawToFullScreen() {
        Graphics graphics = getGraphics();
        graphics.drawImage(screenImage,0,0,fullScreenWidth,fullScreenHeight,null);
        graphics.dispose();
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics2D = (Graphics2D) graphics;
        //loading tiles
        tileManager.draw(graphics2D);
        //loading objects
        assetSetter.draw(graphics2D,23*tileSize,7*tileSize);
        //loading mouse
        mouse.draw(graphics2D);
        graphics2D.dispose();
    }

    public int getTileSize() {
        return tileSize;
    }

    public int getOriginalTileSize() {
        return originalTileSize;
    }

    public int getScale() {
        return scale;
    }

    public int getMaxScreenCol() {
        return maxScreenCol;
    }

    public int getMaxScreenRow() {
        return maxScreenRow;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public int getFPS() {
        return FPS;
    }

    public int getMaxWorldCol() {
        return maxWorldCol;
    }

    public int getMaxWorldRow() {
        return maxWorldRow;
    }

    public int getWorldWidth() {
        return worldWidth;
    }

    public int getWorldHeight() {
        return worldHeight;
    }

    public KeyHandler getKeyHandler() {
        return keyHandler;
    }

    public MousePointer getMouse() {
        return mouse;
    }

    public TileManager getTileManager() {
        return tileManager;
    }

    public Thread getGameThread() {
        return gameThread;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
}
