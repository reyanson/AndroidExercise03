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

public class SigninActivity extends AppCompatActivity {

    EditText uname,pass;
    Button check;

    Intent intent;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        uname = (EditText) findViewById(R.id.unameEditText);
        pass = (EditText) findViewById(R.id.passEditText);
        check = (Button) findViewById(R.id.checkButton);
        intent = new Intent(this, LastActivity.class);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences data2 = getSharedPreferences("data",MODE_PRIVATE);
                String username = data2.getString("USERNAME","Username not stored");
                String password = data2.getString("PASSWORD","Password not stored");

                if(username.equals(uname.getText().toString()) && password.equals(pass.getText().toString())){
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Username or Password Invalid", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}