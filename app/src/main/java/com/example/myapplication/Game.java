package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Game extends AppCompatActivity {
    private int xPosition;
    private int yPosition;
    private int boardSize;
    private int[] currentPosition = new int[2];
    private int[] visitedPositions;
    Game() {

    }
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }
}
