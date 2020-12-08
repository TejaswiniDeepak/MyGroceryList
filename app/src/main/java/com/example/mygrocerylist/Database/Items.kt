package com.example.mygrocerylist.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ItemTable")
data class Items (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo(name = "ItemName")
    val itemName:String,
    @ColumnInfo(name = "Quantity")
    val quantity:Int

)