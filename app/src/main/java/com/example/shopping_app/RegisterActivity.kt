package com.example.shopping_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


//todo fix error: installation error on physical device
class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val button:Button = findViewById<Button>(R.id.register_btn)
        button.setOnClickListener {
            val username:EditText = findViewById(R.id.username_textInput)
            val password:EditText = findViewById(R.id.password_textInput)
            Log.d("onClick", "values are ${username.toString()} , ${password.toString()}")
            if(validateRegistration(username.toString(), password.toString())){
                saveUserData(username.toString(), password.toString())
                moveToItemsActivity()
            }
            else{
                Toast.makeText(this,"Please Enter your username and password", Toast.LENGTH_SHORT).show()
            }

        }
    }
    //todo fix bug: moving to the cart item withou validating the registration

    private  fun validateRegistration(username:String,password:String): Boolean {
        if(username.isEmpty()||password.isEmpty()){
            return false
            Log.d("the output is","false")
        }
        Log.d("the output is","$username : $password")
        return  true
    }



    private fun saveUserData(username: String, password: String) {
        val sharedPreference = getSharedPreferences(getString(R.string.sharedPreference), MODE_PRIVATE)
        with(sharedPreference.edit()) {
            putString(getString(R.string.username_text), username.toString())
            putString(getString(R.string.password_text), password.toString())
            putBoolean(getString(R.string.userInitialized), true)
            apply()
        }
    }


    private fun moveToItemsActivity(){
        val intent = Intent(this, ItemsActivity::class.java)
        startActivity(intent)
    }


    }


