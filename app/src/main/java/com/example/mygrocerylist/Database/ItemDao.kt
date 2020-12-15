package com.example.mygrocerylist.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ItemDao {

    @Insert
    fun insertItems(Item:Items)

    @Query("SELECT *FROM ItemTable")
    fun getAllItems():List<Items>

    @Query("DELETE FROM ItemTable")
    fun deleteAllItems():Int

    @Query("DELETE FROM ItemTable where gid=:id")
    fun deleteId(id:Int):Int

    @Query("SELECT COUNT(*) FROM ItemTable")
    fun countRows():Int

}