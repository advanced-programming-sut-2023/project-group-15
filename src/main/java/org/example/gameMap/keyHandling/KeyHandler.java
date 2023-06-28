package org.example.gameMap.keyHandling;

import org.example.gameMap.GamePanel;
import org.example.gameMap.GameState;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    private final GamePanel gamePanel;
    private boolean upPressed = false;
    private boolean leftPressed = false;
    private boolean downPressed = false;
    private boolean rightPressed = false;
    private boolean sprint = false;

    public KeyHandler(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_W)
            upPressed = true;
        if (keyCode == KeyEvent.VK_A)
            leftPressed = true;
        if (keyCode == KeyEvent.VK_S)
            downPressed = true;
        if (keyCode == KeyEvent.VK_D)
            rightPressed = true;
        if (keyCode == KeyEvent.VK_SHIFT)
            sprint = true;
        if (keyCode == KeyEvent.VK_P) {
            if (gamePanel.getGameState().equals(GameState.playState)) {
                gamePanel.setGameState(GameState.pauseState);
            } else if (gamePanel.getGameState().equals(GameState.pauseState)) {
                gamePanel.setGameState(GameState.playState);
            }
        }
        if (keyCode == KeyEvent.VK_1) { // pressing key 1 will show status
            if (gamePanel.getGameState() == GameState.statusState)
                gamePanel.setGameState(GameState.playState);
            else
                gamePanel.setGameState(GameState.statusState);
        }
        if (keyCode == KeyEvent.VK_I) {
            if (gamePanel.getGameState() == GameState.InventoryMenu)
                gamePanel.setGameState(GameState.playState);
            else
                gamePanel.setGameState(GameState.InventoryMenu);
        }
        if (keyCode == KeyEvent.VK_B) {
            if (gamePanel.getGameState() == GameState.buildingMenu)
                gamePanel.setGameState(GameState.playState);
            else
                gamePanel.setGameState(GameState.buildingMenu);
        }
        if (keyCode == KeyEvent.VK_ESCAPE) {
            if (gamePanel.getGameState() == GameState.gameMenu)
                gamePanel.setGameState(GameState.playState);
            else
                gamePanel.setGameState(GameState.gameMenu);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_W)
            upPressed = false;
        if (keyCode == KeyEvent.VK_A)
            leftPressed = false;
        if (keyCode == KeyEvent.VK_S)
            downPressed = false;
        if (keyCode == KeyEvent.VK_D)
            rightPressed = false;
        if (keyCode == KeyEvent.VK_SHIFT)
            sprint = false;
    }

    public boolean isUpPressed() {
        return upPressed;
    }

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public boolean isDownPressed() {
        return downPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }

    public boolean getSprint() {
        return sprint;
    }
}
