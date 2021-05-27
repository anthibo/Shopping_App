package com.example.shopping_app;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shopping_app.data.entities.Item;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.io.Serializable;
import java.util.List;
//todo: implement the activity
public class CartActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        List<Item> selectedItems = getSelectedItems();
        Log.d("CHECK", selectedItems.toString());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

    }


    //get the selected item data as a serialized object and covert it back to an Item list.
    private List<Item> getSelectedItems(){
        Intent intent = getIntent();
        Serializable selectedItemListSerialized = intent.getSerializableExtra("SelectedItemList");
        List<Item> selectedItems = (List<Item>) selectedItemListSerialized;
        return selectedItems;

    }
}