package com.coufie.mvvmchapterenam.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.coufie.mvvmchapterenam.R
import com.coufie.mvvmchapterenam.viewmodel.ViewModelNews
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_news.setOnClickListener {
            startActivity(Intent(this, NewsActivity::class.java))
        }

        btn_country.setOnClickListener {
            startActivity(Intent(this, CountryActivity::class.java))
        }


    }


}