package org.example.gameMap.keyHandling;

import org.example.gameMap.GamePanel;
import org.example.gameMap.GameState;
import org.example.view.TradeMenu;
import org.example.view.userView.GovernmentMenu;
import org.example.view.userView.StartingMenu;
import org.example.view.userView.GovermentMenu;
import org.example.view.userView.StartingMenu;

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
        if (gamePanel.getGameState() == GameState.inventoryMenu && keyCode != KeyEvent.VK_I) {
            moveOnInventoryMenu(keyCode);
        } else if (gamePanel.getGameState() == GameState.buildingMenu && keyCode != KeyEvent.VK_B) {
            moveOnInventoryMenu(keyCode);
        }
        if (keyCode == KeyEvent.VK_UP) {
            if (gamePanel.getTileSize() > 20)
                gamePanel.zoomInOut(1);
        }
        if (keyCode == KeyEvent.VK_DOWN)
            if (gamePanel.getTileSize() < 64)
                gamePanel.zoomInOut(-1);
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
//                gamePanel.getPopupPage().drawPauseScreen();
                gamePanel.setGameState(GameState.playState);
            }
        }
        if (keyCode == KeyEvent.VK_1) { // pressing key 1 will show status
            this.gamePanel.setGameState(GameState.statusState);
//            gamePanel.getPopupPage().drawStatusState();
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
        if (keyCode == KeyEvent.VK_1) {
            this.gamePanel.setGameState(GameState.playState);
        }
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
