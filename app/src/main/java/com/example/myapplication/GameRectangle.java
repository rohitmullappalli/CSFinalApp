package com.example.myapplication;

import android.graphics.RectF;

public class GameRectangle {
    private RectF rect;
    private boolean isTaken;
    private int row, col, width, height, padding;
    GameRectangle(int row, int col, int width, int height) {
        isTaken = false;
        this.padding = 2;
    }

}
