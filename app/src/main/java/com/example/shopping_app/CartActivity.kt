package com.example.shopping_app


import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shopping_app.adapters.CartItemAdapter
import com.example.shopping_app.data.entities.Item


class CartActivity: AppCompatActivity() {
    val CHANNEL_ID = "channelID"
    val CHANNEL_NAME = "Order"
    val NOTIFICATION_ID = 0

    //todo: implement  notification
    override fun onCreate(savedInstanceState: Bundle?) {
        val selectedItems: List<Item> = getSelectedItems()


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        //notification
        createNotificationChannel()




        val totalAmountText:TextView = findViewById(R.id.total_amount)
        val rvCart = findViewById<RecyclerView>(R.id.rv_Cart)
        val adapter = CartItemAdapter(selectedItems)
        rvCart.adapter = adapter
        rvCart.layoutManager = LinearLayoutManager(this)
        val shareBtn: Button = findViewById(R.id.share_btn)
        shareBtn.setOnClickListener {
            val totalOrderCost = getTotalOrderCost(selectedItems)
            totalAmountText.text = "$$totalOrderCost"
            notify(totalOrderCost)
            shareOrder(totalOrderCost)
        }


    }





    private fun getSelectedItems(): List<Item> {
        val intent = intent
        val selectedItemListSerialized = intent.getSerializableExtra("SelectedItemList")
        return selectedItemListSerialized as List<Item>
    }

    private fun getTotalOrderCost(items:List<Item>):Double{
        var totalPrice = 0.0
        items.forEach { item -> totalPrice+=item.ItemTotalPrice  }
        return  totalPrice
    }

    private fun shareOrder(totalOrderCost:Double){
        val userData = getSharedPreferences(getString(R.string.sharedPreference), MODE_PRIVATE)
        val username = userData.getString("Username", "user not found")?: "not set"
        val shareText = "Hi, I am $username.\nI just placed an order costs $$totalOrderCost  using Shopping App, try it its FREE!!"
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, shareText)
            type = "text/plain"
        }
    val shareIntent = Intent.createChooser(sendIntent, null)
    startActivity(shareIntent)
    }



    private fun createNotificationChannel(){
        if (Build.VERSION.SDK_INT >=Build.VERSION_CODES.O){
            val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH).apply {
                lightColor = Color.BLUE
                enableLights(true)
            }
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }

    }



    //todo implement share functionality in notification and when clicking go to an activity/screen that shows a confirmation message
    private fun notify(totalOrderCost: Double){
        val intent = Intent(this, MainActivity::class.java)
        val pendingIntent = TaskStackBuilder.create(this).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        }
        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("Order Confirmation")
                .setContentText("Your order costs $$totalOrderCost")
                .setSmallIcon(R.drawable.app_logo_foreground)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent)
                .build()
        val notificationManager = NotificationManagerCompat.from(this)
        notificationManager.notify(NOTIFICATION_ID, notification)
    }



}