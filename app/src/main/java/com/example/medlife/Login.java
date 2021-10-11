package com.example.medlife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
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
    private EditText email,password;
    private TextView  errorM;
//    private String User = "Aritra";
//    private String Pass = "12345";
    Boolean isValid = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // click event listener for Login button
        logind = findViewById(R.id.logindashboard);
         email =  findViewById(R.id.editTextTextEmailAddress);
         password =  findViewById((R.id.editTextTextPassword));
         errorM = findViewById(R.id.errorMessage);
//        String name = email.getText().toString();
//        String pass = password.getText().toString();
        back = findViewById(R.id.imageButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);

            }
        });
//
        // click event listener for back button, that leads back to the welcome screen

        logind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = email.getText().toString();
                String pass = password.getText().toString();

                if(name.isEmpty() || pass.isEmpty())
                {
                    errorM.setText("");
                    Toast.makeText(Login.this, "All Fields Required", Toast.LENGTH_SHORT).show();
                    errorM.setText("All Fields are required");
                }
                else{
                    isValid = validate(name,pass);
                    if(!isValid)
                    {
                        errorM.setText("");
                        Toast.makeText(Login.this, "Wrong UserName or Password", Toast.LENGTH_SHORT).show();
                        errorM.setText("Wrong Username or Password");

                    }
                    else
                    {
                        Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent in  = new Intent(Login.this, DashBoard.class);
                        startActivity(in);
                    }
                }

            }
        });
    }

    private boolean validate(String name1, String password)
    {
        /*if(name1.equals(User) && password.equals(Pass))
        {
            return true;
        }*/
        if(name1.equals("Aritra") && password.equals("1234"))
        {
            return true;
        }
        return false;
    }
}

