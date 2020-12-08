package com.example.mygrocerylist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.basicroom.GroceryDatabase
import com.example.mygrocerylist.Database.Items
import kotlinx.android.synthetic.main.activity_add_items.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadList()
        fab_btn.setOnClickListener {
            startActivity(Intent(this,AddItems::class.java))


        }


    }

    override fun onResume()
    {
        super.onResume()
        loadList()

    }

    private fun loadList()

    {
        Toast.makeText(this,"List Loaded", Toast.LENGTH_SHORT).show()
        val db: GroceryDatabase = GroceryDatabase.getInstance(this)
        lifecycleScope.launch {

    /**var ItemList = db.itemDao().getAllItems()
    var i = 0
    var count = db.itemDao().countRows()
    while (i <= count) {
        Log.i("Added Items", "$ItemList")
        //Log.i("Added Items", "$ItemList.itemName")
        //Log.i("Added Items", "$ItemList.quantity")
        i++
    }**/
    val itemList = withContext(Dispatchers.IO) { // runs on background thread
        db.itemDao().getAllItems()
    }
            recyclerViewMain.adapter=AdapterItems(itemList)
            recyclerViewMain.layoutManager=LinearLayoutManager(this@MainActivity)

//recyclerViewMain.layoutManager=LinearLayoutManager(this@MainActivity)

}




    }
}