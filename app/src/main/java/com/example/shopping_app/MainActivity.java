package com.example.shopping_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //todo first check if user is already registered or not
        //if user is not registered => load activity_main_unregistered layout
        //else load activity_main_registered //
        setContentView(R.layout.activity_main_unregistered);
        // to be handled when applying the todo
        Button home_btn = findViewById(R.id.home_btn);
        home_btn.setOnClickListener(view -> moveToRegisterActivity());

    }
    public void moveToRegisterActivity() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
    //todo to be implemented.
    public void moveToItemsActivity(){

    }
}