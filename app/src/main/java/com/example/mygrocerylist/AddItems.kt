package com.example.mygrocerylist

import android.content.ClipData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.basicroom.GroceryDatabase


import com.example.mygrocerylist.Database.Items
import kotlinx.android.synthetic.main.activity_add_items.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddItems : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_items)

        val db: GroceryDatabase = GroceryDatabase.getInstance(this)
        button2.setOnClickListener {
        GlobalScope.launch {

                db.itemDao().insertItems(
                    Items(
                        slno.text.toString().toInt(),
                        ItemName.text.toString(),
                        NumberofItems.text.toString().toInt()
                    )
                )

                var ItemList = db.itemDao().getAllItems()
                var i = 0
                var count = db.itemDao().countRows()
                while (i <= count) {
                    Log.i("Added Items", "$ItemList")
                    //Log.i("Added Items", "$ItemList.itemName")
                    //Log.i("Added Items", "$ItemList.quantity")
                    i++
                }
            }
            Toast.makeText(this@AddItems,"Items Added",Toast.LENGTH_SHORT).show()
        }
    }
}