package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solutions {
    private List<int[]> list = new ArrayList<>();
    private int gridSize;
    private int[] currentPosition = new int[2];
    public void move(int[] current) {
        current = currentPosition;
        if (current[0]  + 1 > gridSize || current[0] - 1 < 0) {
            return;
        }
        if (current[1]  + 1 > gridSize || current[1] - 1< 0) {
            return;
        }
        if (list.contains(current)) {
            return;
        }

    }
}
