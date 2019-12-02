package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

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
        final FirebaseAuth fAuth = FirebaseAuth.getInstance();

        if (fAuth.getCurrentUser() != null) {
            startActivity (new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }
        loginInstead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = eEmail.getText().toString().trim();
                String name = eName.getText().toString().trim();
                String password = ePassword.getText().toString().trim();
                if(TextUtils.isEmpty(email)) {
                    eEmail.setError("Must have an Email");
                }
                if(TextUtils.isEmpty(password)) {
                    ePassword.setError("Must have a password");
                }
                if(TextUtils.isEmpty(name)) {
                    eName.setError("At least one character is required in Name");
                }
                if(password.length() < 5) {
                    ePassword.setError("Password must be at least 5 characters");
                }
                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(Register.this, "New User Made", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        } else {
                            Toast.makeText(Register.this, "Something went wrong...", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });


    }
}
