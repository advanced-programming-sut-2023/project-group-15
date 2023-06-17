package org.example.gameMap.Ui;

public class Spacing {
    private int up;
    private int down;
    private int right;
    private int left;
    public Spacing(int spacing) {
        this(spacing,spacing);
    }
    public Spacing(int vertical, int horizontal) {
        this(vertical,horizontal,vertical,horizontal);
    }
    public Spacing(int up, int down, int right, int left) {
        this.up = up;
        this.down = down;
        this.right = right;
        this.left = left;
    }

    public int getUp() {
        return up;
    }

    public int getDown() {
        return down;
    }

    public int getRight() {
        return right;
    }

    public int getLeft() {
        return left;
    }

    public int getVertical() {
        return up + down;
    }
    public int getHorizontal() {
        return left + right;
    }
}
