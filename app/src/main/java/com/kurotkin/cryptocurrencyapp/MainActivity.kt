package com.kurotkin.cryptocurrencyapp

import android.content.res.Resources
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apiService = RetrofitGetInterface.create()
        apiService.getCryptocurrency()
            .observeOn(AndroidSchedulers.mainThread())  // Говорим в какой поток вернуть
            .subscribeOn(Schedulers.io())               // Выбераем io - для работы с данными и интернетом
            .subscribe({
                    result -> arrayListInit(result)     // Здесь у нас калбек
            }, { error ->
                error.printStackTrace()
            })

        recyclerView.adapter = RecyclerViewAdapter(result, resources)
        recyclerView.layoutManager = LinearLayoutManager(this)

    }
}