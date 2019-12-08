package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {
    private MainThread thread;
    private static int level = 10;
    private List<GameRectangle> rects = new ArrayList<GameRectangle>();
    private float sizeX;
    private float sizeY;

    public GamePanel(Context context, float a, float b) {
        super(context);
        sizeX = a;
        sizeY = b;

        getHolder().addCallback(this);
        thread = new MainThread(getHolder(), this);
        setFocusable(true);

    }
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread = new MainThread(getHolder(), this);

        thread.setRunning(true);
        thread.start();
    }
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while(true) {
            try {
                thread.setRunning(false);
                thread.join();
            } catch(Exception e) {
                e.printStackTrace();
            } retry = false;
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    public void update() {

    }
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawColor(Color.WHITE);
        int gridSize = level / 5;
        gridSize = 3 + gridSize * 2;
        float rectX = sizeX / gridSize;
        float rectY = sizeY / gridSize;
        for (int i = 0; i < gridSize + 1; i++) {
            for (int j = 0; j < gridSize + 1; j++) {
                GameRectangle rect = new GameRectangle(j * rectX + 2, i * rectX + 2, (j + 1) * rectX - 2, (i + 1) * rectX - 2);
                rects.add(rect);
            }
        }
        System.out.println(rects.size());

        Paint defaultPaint = new Paint();
        defaultPaint.setColor(Color.rgb(255,0,255));

        for (GameRectangle a : rects) {
            canvas.drawRect(a.getRect(), defaultPaint);
        }
    }


}
