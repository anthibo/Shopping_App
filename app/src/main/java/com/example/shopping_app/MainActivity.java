package com.example.shopping_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //first check if user is already registered or not
        //if user is not registered => load activity_main_unregistered layout
        //else load activity_main_registered
        setContentView(R.layout.activity_main_unregistered);

    }
}