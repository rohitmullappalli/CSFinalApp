package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {
    private MainThread thread;
    private static int level = 5;
    private List<GameRectangle> rects = new ArrayList<GameRectangle>();
    private float sizeX;
    private float sizeY;
    private int[] start = {2, 2};
    private int[] end = {3, 3};
    private int[] playerPosition = start;
    private RectF up;
    private RectF down;
    private RectF left;
    private RectF right;
    private Rect bruhmoment;
    //newGame starts an actualGame activity, and gives it an intent to set level to 0.
    private RectF newGame;
    //newGame starts an actualGame activity, and gives it an intent to keep the level the same as well as the start and end points.
    private RectF reset;

    public GamePanel(Context context, float a, float b, int c) {
        super(context);
        sizeX = a;
        sizeY = b;
        up = new RectF(sizeX / 2 - 100,sizeY / 2 + 300,sizeX / 2 + 100,sizeY / 2 + 500);
        down = new RectF(sizeX / 2 - 100, sizeY / 2 + 550, sizeX / 2 + 100, sizeY / 2 + 750);
        left = new RectF(sizeX / 2 - 350, sizeY / 2 + 550, sizeX / 2 - 150, sizeY / 2 + 750);
        right = new RectF(sizeX / 2 + 350, sizeY / 2 + 550, sizeX / 2 + 150, sizeY / 2 + 750);
        level = c;

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
        int eventAction = event.getAction();
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch(eventAction) {
            case MotionEvent.ACTION_DOWN:
                if (x < sizeX / 2 + 100 && x > sizeX / 2 - 100 && y < sizeY / 2 + 500 && y > sizeY / 2 + 300) {
                    bruhmoment = new Rect(500, 500, 700, 700);
                }
                if (x > sizeX / 2 - 100 && y > sizeY / 2 + 550 && x < sizeX / 2 + 100 && y < sizeY / 2 + 750) {
                    bruhmoment = new Rect(300, 500, 500, 700);
                }
                if (x > sizeX / 2 - 350 && y > sizeY / 2 + 550 && x < sizeX / 2 - 150 && y < sizeY / 2 + 750) {
                    bruhmoment = new Rect(100, 500, 300, 700);
                }
                if (x < sizeX / 2 + 350 && y > sizeY / 2 + 550 && x > sizeX / 2 + 150 && y < sizeY / 2 + 750) {
                    bruhmoment = new Rect(700, 500, 900, 700);
                }

        }
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
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                GameRectangle rect = new GameRectangle(j * rectX + 2, i * rectX + 2, (j + 1) * rectX - 2, (i + 1) * rectX - 2, j, i);
                rects.add(rect);
            }
        }
        System.out.println(rects.size());

        Paint defaultPaint = new Paint();
        defaultPaint.setColor(Color.rgb(255,0,255));
        Paint startPaint = new Paint();
        startPaint.setColor(Color.BLUE);
        Paint endPaint = new Paint();
        endPaint.setColor(Color.RED);
        Paint buttonPaint = new Paint();
        buttonPaint.setColor(Color.GREEN);

        for (GameRectangle a : rects) {
            canvas.drawRect(a.getRect(), defaultPaint);
        }
        for (GameRectangle a : rects) {
            if (a.getxCoord() == start[0] && a.getyCoord() == start[1]) {
                canvas.drawRect(a.getRect(), startPaint);
            }
        }
        for (GameRectangle a : rects) {
            if (a.getxCoord() == end[0] && a.getyCoord() == end[1]) {
                canvas.drawRect(a.getRect(), endPaint);
            }
        }
        canvas.drawRect(up, buttonPaint);
        canvas.drawRect(down, buttonPaint);
        canvas.drawRect(right, buttonPaint);
        canvas.drawRect(left, buttonPaint);
        if (bruhmoment != null) {
            canvas.drawRect(bruhmoment, buttonPaint);
        }
    }


}
