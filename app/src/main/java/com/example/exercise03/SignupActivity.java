package com.example.exercise03;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
    EditText name,city,username,password;
    Button signup,back;

    Intent intent;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        name = (EditText) findViewById(R.id.nameEditText);
        city =(EditText) findViewById(R.id.cityEditText);
        username = (EditText) findViewById(R.id.usernameEditText);
        password = (EditText) findViewById(R.id.passwordEditText);
        signup = (Button) findViewById(R.id.signUpButton);
        back = (Button) findViewById(R.id.backButton);
        intent = new Intent(this,MainActivity.class);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences data1 = getSharedPreferences("data",MODE_PRIVATE);
                SharedPreferences.Editor editor = data1.edit();
                editor.putString("NAME",name.getText().toString());
                editor.putString("CITY",city.getText().toString());
                editor.putString("USERNAME",username.getText().toString());
                editor.putString("PASSWORD",password.getText().toString());
                editor.commit();
                Toast.makeText(getApplicationContext(), "You have signed up successfully", Toast.LENGTH_SHORT).show();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
    }
}