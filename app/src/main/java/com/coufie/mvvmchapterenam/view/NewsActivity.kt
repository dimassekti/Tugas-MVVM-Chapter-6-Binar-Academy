package com.coufie.mvvmchapterenam.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.coufie.mvvmchapterenam.R
import com.coufie.mvvmchapterenam.view.adapter.NewsAdapter
import com.coufie.mvvmchapterenam.viewmodel.ViewModelNews
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity() {

    lateinit var newsAdapter : NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        newsAdapter = NewsAdapter()

        rv_news.layoutManager = LinearLayoutManager(this)
        rv_news.adapter = newsAdapter
        initViewModel()
    }

    fun initViewModel(){
        val viewModel = ViewModelProvider(this).get(ViewModelNews::class.java)
        viewModel.getLiveDataNewss().observe(this, Observer {
            if(it != null){
                newsAdapter.setNewsList(it)
                newsAdapter.notifyDataSetChanged()
            }else{

            }

        })
        viewModel.getDataNews()
    }
}