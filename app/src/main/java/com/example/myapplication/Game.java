package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Game extends AppCompatActivity {
    private int xPosition;
    private int yPosition;
    private int boardSize;
    Game(int x, int y, int b) {
        xPosition = x;
        yPosition = y;
        boardSize = b;
    }
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }
}
