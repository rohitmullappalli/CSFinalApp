package com.example.myapplication;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.MotionEvent;

public class GameRectangle {
    private RectF rect;
    private Boolean isVisible;
    private int row, col, width, height, padding;
    private int xCoord, yCoord;
    GameRectangle(float left, float top, float right, float bottom, int x, int y) {
        isVisible = true;
        this.padding = 2;
        rect = new RectF(left, top, right, bottom);
        xCoord = x;
        yCoord = y;
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
}
