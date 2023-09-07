package com.example.exercise03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class LastActivity extends AppCompatActivity {
    EditText name ,city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);

        name = (EditText) findViewById(R.id.nameText);
        city = (EditText) findViewById(R.id.cityText);

        SharedPreferences data3 = getSharedPreferences("data",MODE_PRIVATE);
        String Name = data3.getString("NAME","Name not stored");
        String City = data3.getString("CITY","City not stored");

        name.setText(Name);
        city.setText(City);

    }
}