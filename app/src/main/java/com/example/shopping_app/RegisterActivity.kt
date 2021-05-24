package com.example.shopping_app

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class RegisterActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val button:Button = findViewById<Button>(R.id.register_btn)
        button.setOnClickListener {
            val username:EditText = findViewById(R.id.username_textInput)
            val password:EditText = findViewById(R.id.password_textInput)
            register(username, password)
        }
    }
    private fun validate(username:String, password: String): Boolean {
        var flag = true
        if (username.isEmpty()||password.isEmpty()){
            flag = false
        }
        return  flag
    }


    //save the user date from the editTexts to a shared preferences key:value and set the user is registered
    private fun saveUserData(username:String, password: String) {
        val userData:SharedPreferences = getSharedPreferences(getString(R.string.sharedPreference), MODE_PRIVATE)
        with(userData.edit()) {
            putString(getString(R.string.username_text), username)
            putString(getString(R.string.password_text), password)
            putBoolean(getString(R.string.userInitialized), true)
            apply()
        }
    }


    private fun moveToItemsActivity(){
        val intent = Intent(this, ItemsActivity::class.java)
        startActivity(intent)
    }
    //validate the user input and take an action based on the output
    private fun register(username:EditText, password:EditText){
        val usernameStr:String = username.text.toString()
        val passwordStr:String = password.text.toString()
        if(!validate(usernameStr,passwordStr)){
            Toast.makeText(this, "Please Enter your username and password", Toast.LENGTH_SHORT).show()
        }
        else{
            saveUserData(usernameStr, passwordStr)
            Toast.makeText(this, "Thank you $usernameStr for registering to our app", Toast.LENGTH_SHORT).show()
            moveToItemsActivity()
        }
    }
}






