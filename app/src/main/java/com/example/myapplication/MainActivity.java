package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button startGame = findViewById(R.id.start);
        Button leaderBoard = findViewById(R.id.leaderboard);
        TextView welcome = findViewById(R.id.Welcome);
        TextView rules = findViewById(R.id.rules);
        FirebaseAuth fAuth = FirebaseAuth.getInstance();
        fAuth.getCurrentUser().getDisplayName();

        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Display display = getWindowManager().getDefaultDisplay();
                Point size = new Point();
                display.getSize(size);
                Intent a = new Intent(getApplicationContext(), ActualGame.class);
                a.putExtra("sizeX", size.x);
                a.putExtra("sizeY", size.y);
                startActivity(a);
            }
        });
        leaderBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Leaderboard.class));
            }
        });
    }
    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), Login.class));
        finish();
    }
}
