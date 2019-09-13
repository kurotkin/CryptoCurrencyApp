package com.kurotkin.cryptocurrencyapp.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.kurotkin.cryptocurrencyapp.R
import com.kurotkin.cryptocurrencyapp.fragments.CurrenciesListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .add(R.id.container, CurrenciesListFragment(), null)
                .commit()
        }


//        val apiService = RetrofitGetInterface.create()
//        apiService.getCryptocurrency()
//            .observeOn(AndroidSchedulers.mainThread())  // Говорим в какой поток вернуть
//            .subscribeOn(Schedulers.io())               // Выбераем io - для работы с данными и интернетом
//            .subscribe({
//                    result -> arrayListInit(result)     // Здесь у нас калбек
//            }, { error ->
//                error.printStackTrace()
//            })
//
//        recyclerView.adapter = RecyclerViewAdapter(result, resources)
//        recyclerView.layoutManager = LinearLayoutManager(this)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.action_about -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}