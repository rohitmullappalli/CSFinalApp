package com.example.myapplication;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.MotionEvent;

public class GameRectangle {
    private RectF rect;
    private Boolean isVisible;
    private float left1, top1, right1, bottom1, padding;
    private int xCoord, yCoord;
    GameRectangle(float left, float top, float right, float bottom, int x, int y) {
        isVisible = true;
        this.padding = 2;
        rect = new RectF(left, top, right, bottom);
        xCoord = x;
        yCoord = y;
        left1 = left;
        right1 = right;
        top1 = top;
        bottom1 = bottom;
    }
    public RectF getRect() {
        return this.rect;
    }
    public int getxCoord() {
        return this.xCoord;
    }
    public int getyCoord() {
        return this.yCoord;
    }
    public float getLeft() { return this.left1; }
    public float getRight() { return this.right1; }
    public float getTop() { return this.top1; }
    public float getBottom() { return this.bottom1; }

}
