package com.example.shopping_app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shopping_app.R
import com.example.shopping_app.data.entities.Item

class CartItemAdapter(val selectedItems:List<Item>):RecyclerView.Adapter<CartItemAdapter.CartItemViewHolder>() {
    inner  class CartItemViewHolder(cartItemView: View):RecyclerView.ViewHolder(cartItemView){
        val cartItemName: TextView = itemView.findViewById(R.id.cart_item_name)
        val cartItemDescription: TextView = itemView.findViewById(R.id.cart_item_description)
        val itemPrice: TextView = itemView.findViewById(R.id.price)
        val totalPrice: TextView = itemView.findViewById(R.id.total_price)
        val itemImg: ImageView = itemView.findViewById(R.id.cart_item_img)
        val cartItemAmount: EditText = itemView.findViewById(R.id.amount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cart_item, parent, false)

        return CartItemViewHolder(view)
    }
//todo: Implement onBindViewHolder to bind the data between rv and list
    override fun onBindViewHolder(holder: CartItemViewHolder, position: Int) {
        holder.apply {
            cartItemName.text = selectedItems[position].name
            cartItemDescription.text = selectedItems[position].description

        }
    }

    override fun getItemCount(): Int {
        return selectedItems.size
    }
}