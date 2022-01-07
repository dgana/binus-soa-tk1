package com.example.soa_kotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView

internal class CustomAdapter(private var itemsList: ArrayList<Items>) :
    RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {
    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var name: TextView = view.findViewById(R.id.txt_name)
        var price: TextView = view.findViewById(R.id.txt_price)
        var qty: TextView = view.findViewById(R.id.txt_qty)
    }
    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.text_row_item, parent, false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val items = itemsList[position]
        holder.name.text = "Name = "+ items.getName()
        holder.price.text = "Price = "+ items.getPrice().toString()
        holder.qty.text = "Quantity = "+ items.getQty().toString()+" "+items.getUnit()
    }
    override fun getItemCount(): Int {
        return itemsList.size
    }
}