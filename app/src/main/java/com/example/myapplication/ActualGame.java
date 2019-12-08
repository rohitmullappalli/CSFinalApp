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
    private static int level = 0;
    private List<RectF> rects = new ArrayList<RectF>();
    private int sizeX;
    private int sizeY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(new GamePanel(this));
        sizeX = getIntent().getIntExtra("sizeX", 0);
        sizeY = getIntent().getIntExtra("sizeY", 0);
    }
    public void generateGrid(Canvas canvas) {
        int gridSize = level / 5;
        gridSize = 3 + gridSize * 2;
        float rectX = sizeX / gridSize;
        float rectY = sizeY / gridSize;
        for (int i = 0; i < gridSize + 1; i++) {
            for (int j = 0; i < gridSize + 1; i++) {
                RectF rect = new RectF(j * rectX + 2, i * rectY + 2, (j + 1) * rectX - 2, (i + 1) * rectY - 2);
                rects.add(rect);
            }
        }

        Paint defaultPaint = new Paint();
        defaultPaint.setColor(Color.rgb(255,0,255));

        for (RectF a : rects) {
            canvas.drawRect(a, defaultPaint);
        }
    }
}
