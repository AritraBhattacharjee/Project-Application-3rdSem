package com.example.medlife;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
/*
public class Login extends AppCompatActivity {
    Button logind;
    ImageButton back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // click event listener for Login button
        logind = findViewById(R.id.logindashboard);
        EditText email = findViewById(R.id.editTextTextEmailAddress);
        EditText password = findViewById((R.id.editTextTextPassword));
        EditText errorM = findViewById(R.id.errorMessage);
        String name = email.getText().toString();
        String pass = password.getText().toString();

        logind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Intent intent = new Intent(Login.this, DashBoard.class);
                    startActivity(intent);

            }
        });

        // click event listener for back button, that leads back to the welcome screen
        back = findViewById(R.id.imageButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);


            }
        });
    }
}*/

// new edit code experimentation
public class Login extends AppCompatActivity {
    private Button logind;
    private ImageButton back;
    private EditText email, password;
    private TextView errorM;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        logind = findViewById(R.id.logindashboard);
        email = findViewById(R.id.editTextTextEmailAddress);
        password = findViewById((R.id.editTextTextPassword));
        errorM = findViewById(R.id.errorMessage);

        back = findViewById(R.id.imageButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);

            }
        });
        mAuth = FirebaseAuth.getInstance();
        logind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailN = email.getText().toString().trim();
                String passwords = password.getText().toString().trim();

                if (TextUtils.isEmpty(emailN)) {
                    email.setError("Email is required");
                } else if (TextUtils.isEmpty(passwords)) {
                    password.setError("Password is required");
                }

                mAuth.signInWithEmailAndPassword(emailN, passwords).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            Intent inte = new Intent(getApplicationContext(), DashBoard.class);
                            startActivity(inte);
                        } else {
                            Toast.makeText(Login.this, "Login UnSuccessful", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


            }
        });
    }
}





