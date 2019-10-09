package com.kurotkin.cryptocurrencyapp.activities

import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
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
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.action_about -> {
                showInfo()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showInfo(){
        var bundle: Bundle? = null
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
            val v = findViewById<View>(R.id.action_about)
            if (v != null) {
                val options = ActivityOptions.makeSceneTransitionAnimation(this, v, "transition")
                bundle = options.toBundle()
            }
        }

        val intent = Intent(this, AboutActivity::class.java)
        if (bundle == null) {
            startActivity(intent)
        } else {
            startActivity(intent, bundle)
        }
    }
}