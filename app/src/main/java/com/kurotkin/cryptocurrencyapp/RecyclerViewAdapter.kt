package com.kurotkin.cryptocurrencyapp

import android.content.res.Resources
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item.view.*

class RecyclerViewAdapter(private val result: List<ResponseItem>, val resources: Resources): RecyclerView.Adapter<RecyclerViewAdapter.CardViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CardViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount()= result.size

    override fun onBindViewHolder(holder: CardViewHolder, position: Int)  = holder.bind(result, position, resources)


    class CardViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        fun bind(result: List<ResponseItem>, position: Int, resources: Resources) {
            val responseItem: ResponseItem = result.get(position)

            itemView.symbol.text = responseItem.symbol
            itemView.name.text = responseItem.name

        }
    }

}