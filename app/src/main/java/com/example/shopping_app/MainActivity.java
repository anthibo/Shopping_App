package com.example.shopping_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private boolean userInitialized ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Initiate the shared preference obj to check if the user is already registered or not
        // if user is already registered => layout:activity_main_registered
        // else => layout:activity_main_unregistered
        SharedPreferences userData = getSharedPreferences(getString(R.string.sharedPreference), MODE_PRIVATE);
        userInitialized = userData.getBoolean(getString(R.string.userInitialized),false);

        if(userInitialized){
            setContentView(R.layout.activity_main_registered);
            // to be handled when applying the todo
            Button home_btn = findViewById(R.id.home_btn);
            home_btn.setOnClickListener(    view -> moveToItemsActivity());
        }
        else{
            setContentView(R.layout.activity_main_unregistered);
            // to be handled when applying the todo
            Button home_btn = findViewById(R.id.home_btn);
            home_btn.setOnClickListener(    view -> moveToRegisterActivity());

        }





    }
    //methods to make an intent to move to an activity
    public void moveToRegisterActivity() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
        public void moveToItemsActivity(){
        Intent intent = new Intent(this, ItemsActivity.class);
        startActivity(intent);
    }
}