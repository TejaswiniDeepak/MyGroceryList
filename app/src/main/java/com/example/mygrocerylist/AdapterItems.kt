package com.example.mygrocerylist

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.basicroom.GroceryDatabase
import com.example.mygrocerylist.Database.Items
import kotlinx.android.synthetic.main.rv_listaddedbyuser.view.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AdapterItems(var displayList:List<Items>): RecyclerView.Adapter<AdapterItems.AdapterList>() {

    val db = Room.databaseBuilder(
      ,GroceryDatabase::class.java, "sleep_historydatabase"
    ).build()
    class AdapterList(itemView:View):RecyclerView.ViewHolder(itemView)

    {

        var itemid=itemView.slno
        var itemname=itemView.item_name
        var itemquantity=itemView.qty
        var checkbox=itemView.checkbox1
        var btndelete=itemView.btn_delete
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterList {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.rv_listaddedbyuser,
            parent, false)
        return AdapterList(view)
    }

    override fun onBindViewHolder(holder: AdapterList, position: Int) {
        holder.itemname.text= displayList[position].itemName
        holder.itemquantity.text= displayList[position].quantity.toString()
        holder.itemid.text=displayList[position].gid.toString()

        val db = Room.databaseBuilder(
                applicationContext@AdapterItems,
                GroceryDatabase::class.java, "sleep_historydatabase"
        ).build()
        /**if(holder.checkbox.isChecked)
        {
            Log.i("checkbox message","Box checked")

        }

        else
        {
            Log.i("checkbox message","Box  NOT checked")
        }**/

        holder.btndelete.setOnClickListener{
            GlobalScope.launch {
                var numberOfRows=db.itemDao().deleteId(displayList[position].gid)
                Log.i("Delete","itemDeleted")

            }

        }


    }

    override fun getItemCount(): Int {
   return displayList.size
    }
}