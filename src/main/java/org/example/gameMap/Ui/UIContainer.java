package org.example.gameMap.Ui;

import org.example.gameMap.Position;
import org.example.gameMap.notReadedClasses.ImageUtils;
import org.example.gameMap.notReadedClasses.State;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UIContainer extends UIComponent{
    private Color backgroundColor;
    public UIContainer() {
        super();
        backgroundColor = Color.RED;
    }
    private void calculateSize() {
        size = new Size(padding.getHorizontal(),padding.getVertical());
    }
    private void calculatePosition() {
        position = new Position(margin.getLeft(),margin.getUp());
    }

    @Override
    public BufferedImage getSprite() {
        BufferedImage image = (BufferedImage) ImageUtils.createCompatibleImage(size,ImageUtils.ALPHA_BIT_MASKED);
        Graphics2D graphics2D =image.createGraphics();
        graphics2D.setColor(backgroundColor);
        graphics2D.fillRect(0,0, size.getWidth(), size.getHeight());
        graphics2D.dispose();
        return image;
    }

    @Override
    public void update(State state) {
        calculateSize();
        calculatePosition();
    }
}
