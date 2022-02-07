package com.example.lesson4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.lesson4.activities.Task4_FirstActivity;
import com.example.lesson4.activities.Task5_FirstActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void task4(View view) {
        Intent intent = new Intent(getApplicationContext(), Task4_FirstActivity.class);
        startActivity(intent);
    }

    public void task5(View view) {
        Intent intent = new Intent(getApplicationContext(), Task5_FirstActivity.class);
        startActivity(intent);
    }
}