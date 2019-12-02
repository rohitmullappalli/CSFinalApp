package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText eName = findViewById(R.id.name);
        final EditText eEmail = findViewById(R.id.email);
        final EditText ePassword = findViewById(R.id.password);
        Button register = findViewById(R.id.register);
        Button loginInstead = findViewById(R.id.logininstead);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = eEmail.getText().toString().trim();
                String name = eName.getText().toString().trim();
                String password = ePassword.getText().toString().trim();
            }
        });


    }
}
