package com.kurotkin.cryptocurrencyapp.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kurotkin.cryptocurrencyapp.R
import kotlinx.android.synthetic.main.activity_about.*



class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        actionBar?.setHomeButtonEnabled(true)

        buttonRateApp.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=${applicationContext.packageName}")))
        }
    }
}
