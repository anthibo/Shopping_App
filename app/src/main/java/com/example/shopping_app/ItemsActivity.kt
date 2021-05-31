package com.example.shopping_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shopping_app.adapters.ItemAdapter
import com.example.shopping_app.data.entities.Item
import java.io.Serializable

class ItemsActivity : AppCompatActivity() {

    //todo: Insert real data
    private val items:List<Item> = listOf(
            Item("Iphone 12", "The newest iphone ever", 11000.0,R.mipmap.iphone12),
            Item("Iphone 11", "Released before iphone 12", 12000.0,R.mipmap.iphone11),
            Item("Iphone 12", "The newest iphone ever", 13000.0,R.mipmap.iphone12),
            Item("Iphone 12", "The newest iphone ever", 14000.0,R.mipmap.iphone12),
            Item("Iphone 12", "The newest iphone ever", 15000.0,R.mipmap.iphone12),
            Item("Iphone 12", "The newest iphone ever", 15000.0,R.mipmap.iphone12),
            Item("Iphone 12", "The newest iphone ever", 15000.0,R.mipmap.iphone12),
            Item("Iphone 12", "The newest iphone ever", 15000.0,R.mipmap.iphone12),
            Item("Iphone 12", "The newest iphone ever", 15000.0,R.mipmap.iphone12),
            Item("Iphone 12", "best iphone ever", 15000.0,R.mipmap.iphone12)

    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)

    //setting the recyclerview with the items data
        val adapter = ItemAdapter(items = items)
        val rvItem = findViewById<RecyclerView>(R.id.rv_Items)
        rvItem.adapter = adapter
        rvItem.layoutManager = LinearLayoutManager(this)
        val btn:Button = findViewById(R.id.goToCart_btn)
        btn.setOnClickListener { goToCart() }
    }
    //return only the items that are selected by the user
    private fun selectedItems():List<Item>{
        return items.filter { it.isAdded }
    }
    private fun goToCart(){
        val selectedItems = selectedItems()
        if(selectedItems.isEmpty()){
            return Toast.makeText(this, "The Cart is Empty", Toast.LENGTH_SHORT).show()
        }
        val intent: Intent = Intent(this, CartActivity::class.java).apply {
            putExtra("SelectedItemList",selectedItems as Serializable)
        }
        startActivity(intent)
    }

}


