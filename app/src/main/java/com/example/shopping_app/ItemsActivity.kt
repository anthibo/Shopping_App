package com.example.shopping_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shopping_app.adapters.ItemAdapter
import com.example.shopping_app.data.entities.Item

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)

        val items:List<Item> = listOf(
                Item("Iphone 12", "The newest iphone ever", 11000.0,R.mipmap.iphone12),
                Item("Iphone 12", "The newest iphone ever", 12000.0,R.mipmap.iphone12),
                Item("Iphone 12", "The newest iphone ever", 13000.0,R.mipmap.iphone12),
                Item("Iphone 12", "The newest iphone ever", 14000.0,R.mipmap.iphone12),
                Item("Iphone 12", "The newest iphone ever", 15000.0,R.mipmap.iphone12)

        )
        val adapter = ItemAdapter(items = items)
        val rvItem = findViewById<RecyclerView>(R.id.rv_Items)
        rvItem.adapter = adapter
        rvItem.layoutManager = LinearLayoutManager(this)


    }
}


