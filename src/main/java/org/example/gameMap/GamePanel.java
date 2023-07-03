package org.example.gameMap;

import org.example.gameMap.keyHandling.KeyHandler;
import org.example.gameMap.mouseHandling.MousePointer;
import org.example.gameMap.objectSetter.AssetSetter;
import org.example.gameMap.tileSetter.MiniMap;
import org.example.gameMap.tileSetter.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    private final SelectedMap selectedMap;
    private int tileSize = 48;
    private final int screenWidth = tileSize * 20; // 48 * 40 = 1920
    private final int screenHeight = tileSize * 20; // 48 * 22 = 1080
    private final int FPS = 60;
    private final int worldWidth = tileSize * 50; // todo: has to change to user map 200 or 400
    private final int worldHeight = tileSize * 50;
    private GameState gameState;
    private final PlayerGameStatus playerStatus;
    private final UI popupPage = new UI(this);
    private final KeyHandler keyHandler = new KeyHandler(this);
    private final AssetSetter assetSetter;
    private final MousePointer mouse = new MousePointer(this, keyHandler,getComponents());
    private final TileManager tileManager;
    private final MiniMap miniMap;
    private Thread gameThread;
    private Graphics2D graphics2D;

    public GamePanel() {
        this.playerStatus = new PlayerGameStatus(this);
        this.selectedMap = SelectedMap.getSelectedMap();
        this.gameState = GameState.playState;
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.tileManager = new TileManager(this);
        this.miniMap = new MiniMap(this);
        this.assetSetter = new AssetSetter(this);
        this.addKeyListener(keyHandler);
        this.addMouseListener(mouse);
        this.addMouseMotionListener(mouse);
        this.setFocusable(true);
        startGameThread();
    }
    public void zoomInOut(int i) {
        int oldWidth = tileSize * 50;
        tileSize += i;
        int newWidth = tileSize * 50;
        double multiplier = (double) newWidth / oldWidth;
        mouse.setWorldX(mouse.getWorldX() * multiplier);
        mouse.setWorldY(mouse.getWorldY() * multiplier);
    }
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;
            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }

    public void update() {
        if (gameState == GameState.playState) {
            mouse.update();
        }
        if (gameState == GameState.pauseState) {
            //todo:pause state...

        }

    }
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics2D = (Graphics2D) graphics;
        //loading tiles
        tileManager.draw(graphics2D);
        tileManager.selectAllTiles();
//        tileManager.drawFromJson(graphics2D,selectedMap);
        //loading objects
        assetSetter.draw(graphics2D, 23 * tileSize, 7 * tileSize);
        //loading mouse
        popupPage.draw(graphics2D);
        mouse.draw(graphics2D);
        //loading minimap
        miniMap.drawMiniMap(graphics2D);
        graphics2D.dispose();
    }

    public int getTileSize() {
        return tileSize;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
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

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public Graphics2D getGraphics2D() {
        return graphics2D;
    }

    public UI getPopupPage() {
        return popupPage;
    }

    public PlayerGameStatus getPlayerStatus() {
        return playerStatus;
    }

    public AssetSetter getAssetSetter() {
        return assetSetter;
    }

    public MiniMap getMiniMap() {
        return miniMap;
    }
}