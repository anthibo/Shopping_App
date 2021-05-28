package com.example.shopping_app


import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shopping_app.adapters.CartItemAdapter
import com.example.shopping_app.data.entities.Item


class CartActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        val selectedItems: List<Item> = getSelectedItems()
        Log.d("CHECK", selectedItems.toString())
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val rvCart = findViewById<RecyclerView>(R.id.rv_Cart)
        val adapter = CartItemAdapter(selectedItems)
        rvCart.adapter = adapter
        rvCart.layoutManager = LinearLayoutManager(this)
        val shareBtn: Button = findViewById(R.id.share_btn)
        shareBtn.setOnClickListener {
            Toast.makeText(this, "${selectedItems[0].amount}", Toast.LENGTH_SHORT).show()
        }


    }



    private fun getSelectedItems(): List<Item> {
        val intent = intent
        val selectedItemListSerialized = intent.getSerializableExtra("SelectedItemList")
        return selectedItemListSerialized as List<Item>
    }
}