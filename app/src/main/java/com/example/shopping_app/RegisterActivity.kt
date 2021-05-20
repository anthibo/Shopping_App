package com.example.shopping_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


//todo Activity functionality to be implemented
class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val button:Button = findViewById<Button>(R.id.register_btn)
        button.setOnClickListener {
            moveToItemsActivity()
        }
    }
    private fun moveToItemsActivity(){
        val intent = Intent(this, ItemsActivity::class.java)
        startActivity(intent)
    }
}