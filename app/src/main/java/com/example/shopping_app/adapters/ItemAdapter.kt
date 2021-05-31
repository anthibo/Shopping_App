package com.example.shopping_app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.shopping_app.R
import com.example.shopping_app.R.layout.item
import com.example.shopping_app.data.entities.Item
import  android.widget.TextView

class ItemAdapter(val items:List<Item>):RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    inner class ItemViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val itemName:TextView = itemView.findViewById(R.id.item_name)
        val itemDescription:TextView = itemView.findViewById(R.id.item_description)
        val itemPrice:TextView = itemView.findViewById(R.id.item_price)
        val itemImg:ImageView = itemView.findViewById(R.id.item_img)
        val btn:Button =    itemView.findViewById(R.id.addCart_btn)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(item, parent, false)

        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.apply {
            itemName.text = items[position].name
            itemDescription.text = items[position].description
            itemPrice.text = "$${items[position].price}"
            itemImg.setImageResource(items[position].imageSrc)

            //Add item to cart or  undo
            btn.setOnClickListener{
                if (!items[position].isAdded){
                    items[position].isAdded = true
                    btn.text = "Added"
                }
                else{
                    items[position].isAdded = false
                    btn.text = "Add to cart"
                }

            }

        }
    }

    override fun getItemCount(): Int {
            return items.size
        }
}