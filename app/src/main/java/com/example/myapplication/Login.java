package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    EditText lEmail, lPassword;
    Button login, registerInstead;
    FirebaseAuth lAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        lEmail = findViewById(R.id.email2);
        lPassword = findViewById(R.id.password2);
        login = findViewById(R.id.loginbutton);
        registerInstead = findViewById(R.id.registerinstead);
        lAuth = FirebaseAuth.getInstance();

        registerInstead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Register.class));
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = lEmail.getText().toString().trim();
                String password = lPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)) {
                    lEmail.setError("Must have an Email");
                    return;
                }
                if(TextUtils.isEmpty(password)) {
                    lPassword.setError("Must have a password");
                    return;
                }
                if(password.length() < 5) {
                    lPassword.setError("Password must be at least 5 characters");
                    return;
                }
                lAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(Login.this, "Login failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}
