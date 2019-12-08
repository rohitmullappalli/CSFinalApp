package com.example.myapplication;

import android.graphics.Canvas;

public class GenerateGRd {
    public void generateGrid(Canvas canvas, int sizeX, int sizeY, int level) {
        int gridSize = level / 5;
        gridSize = 3 + gridSize * 2;
        float rectX = sizeX / gridSize;
        float rectY = sizeY / gridSize;
        for (int i = 0; i < gridSize + 1; i++) {

        }

    }

}
