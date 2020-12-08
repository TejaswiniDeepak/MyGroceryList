package com.example.basicroom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mygrocerylist.AddItems
import com.example.mygrocerylist.Database.ItemDao
import com.example.mygrocerylist.Database.Items
import com.example.mygrocerylist.MainActivity

@Database(entities = [Items::class],version = 2)
abstract class GroceryDatabase: RoomDatabase() {
    abstract fun itemDao():ItemDao
    companion object {

        @Volatile
        private var INSTANCE: GroceryDatabase? = null

        fun getInstance(context:Context): GroceryDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context,
                        GroceryDatabase::class.java,
                        "sleep_history_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}