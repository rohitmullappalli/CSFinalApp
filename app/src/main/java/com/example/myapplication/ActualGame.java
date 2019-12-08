package com.example.myapplication;

import androidx.annotation.Dimension;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ActualGame extends AppCompatActivity {
    private static int level = 5;
    private List<GameRectangle> rects = new ArrayList<GameRectangle>();
    private int sizeX;
    private int sizeY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        sizeX = getIntent().getIntExtra("sizeX", 0);
        sizeY = getIntent().getIntExtra("sizeY", 0);
        level++;
        setContentView(new GamePanel(this, sizeX, sizeY, level));
    }
}
