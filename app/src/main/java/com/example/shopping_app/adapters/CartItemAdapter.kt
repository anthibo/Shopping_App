package com.example.shopping_app.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.shopping_app.R
import com.example.shopping_app.R.layout.cart_item
import com.example.shopping_app.data.entities.Item
import org.w3c.dom.Text

class CartItemAdapter(val selectedItems:List<Item>):RecyclerView.Adapter<CartItemAdapter.CartItemViewHolder>() {
    inner  class CartItemViewHolder(cartItemView: View):RecyclerView.ViewHolder(cartItemView){
        val cartItemName: TextView = itemView.findViewById(R.id.cart_item_name)
        val cartItemDescription: TextView = itemView.findViewById(R.id.cart_item_description)
        val itemPrice: TextView = itemView.findViewById(R.id.price)
        val totalPrice: TextView = itemView.findViewById(R.id.total_price)
        val itemImg: ImageView = itemView.findViewById(R.id.cart_item_img)
        val plus:Button = itemView.findViewById(R.id.plus)
        val minus:Button = itemView.findViewById(R.id.minus)
        val cartItemAmount:TextView = itemView.findViewById(R.id.amount)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(cart_item, parent, false)

        return CartItemViewHolder(view)
    }
//bind the views of cart_items.xml to the adapter
    override fun onBindViewHolder(holder: CartItemViewHolder, position: Int) {
        holder.apply {
            cartItemName.text = selectedItems[position].name
            cartItemDescription.text = selectedItems[position].description
            itemImg.setImageResource(selectedItems[position].imageSrc)
            itemPrice.text = "$${selectedItems[position].price}"
            totalPrice.text = "Total: $${selectedItems[position].ItemTotalPrice}"
            cartItemAmount.text = "${selectedItems[position].amount}"
            //add one item
            plus.setOnClickListener{
               val amount = ++selectedItems[position].amount
                val price = selectedItems[position].price
                cartItemAmount.text = "${selectedItems[position].amount}"
                selectedItems[position].ItemTotalPrice = amount*price
                totalPrice.text = "Total: $${selectedItems[position].ItemTotalPrice}"
            }
            //remove one item
            minus.setOnClickListener {
                if (selectedItems[position].amount > 1) {
                    val amount = --selectedItems[position].amount
                    val price = selectedItems[position].price
                    cartItemAmount.text = "${selectedItems[position].amount}"
                    selectedItems[position].ItemTotalPrice = amount * price
                    totalPrice.text = "Total: $${selectedItems[position].ItemTotalPrice}"
                }
            }


        }
    }

    override fun getItemCount(): Int {
        return selectedItems.size
    }



}