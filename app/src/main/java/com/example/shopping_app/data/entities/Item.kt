package com.example.shopping_app.data.entities

import java.io.Serializable
import java.time.temporal.TemporalAmount


data class Item
(
        val name:String,
        val description:String,
        val price:Double,
        val imageSrc:Int,
        var isAdded:Boolean = false,
        var amount: Int = 1
) :Serializable
