package com.kurotkin.cryptocurrencyapp

import android.support.v7.widget.RecyclerView
import android.view.View

abstract class BaseAdapter<VH: BaseAdapter.BaseViewHolder> : RecyclerView.Adapter<VH>() {
    var items: ArrayList<Any> = ArrayList()

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bild(getItem(position))
    }

    fun getItem(position: Int): Any = items[position]

    fun add(newItem: Any) {
        items.add(newItem)
    }

    fun add(newItems: List<Any>) {
        items.addAll(newItems)
    }

    abstract class BaseViewHolder(protected val view: View) : RecyclerView.ViewHolder(view){
        abstract fun bild(item: Any)
    }
}