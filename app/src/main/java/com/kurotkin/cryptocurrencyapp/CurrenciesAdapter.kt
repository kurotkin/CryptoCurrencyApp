package com.kurotkin.cryptocurrencyapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item.view.*

class CurrenciesAdapter: BaseAdapter<CurrenciesAdapter.CurrencyVewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyVewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return CurrencyVewHolder(v)
    }

    class CurrencyVewHolder(view: View) : BaseAdapter.BaseViewHolder(view) {
        init {
            itemView.setOnClickListener {

            }
        }

        override fun bild(item: Any) {
            let {
                item as Currency
                Glide.with(view.context).load(item.image).into(view.ivCurrencyIcon)
                view.tvCurrencySym.text = item.symbol
                view.tvCurrencyName.text = item.name
                view.tvCurrencyMarketCap.text = item.marketCap
                view.tvCurrencyPrice.text = item.price.toString()
            }
        }
    }
}