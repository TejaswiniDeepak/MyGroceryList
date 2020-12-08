package com.example.mygrocerylist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mygrocerylist.Database.Items
import kotlinx.android.synthetic.main.rv_listaddedbyuser.view.*

class AdapterItems(var displayList:List<Items>): RecyclerView.Adapter<AdapterItems.AdapterList>() {
    class AdapterList(itemView:View):RecyclerView.ViewHolder(itemView)
    {
        var itemid=itemView.slno
        var itemname=itemView.item_name
        var itemquantity=itemView.qty
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
        holder.itemid.text=displayList[position].id.toString()


    }

    override fun getItemCount(): Int {
   return displayList.size
    }
}