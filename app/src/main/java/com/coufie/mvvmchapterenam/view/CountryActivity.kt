package com.coufie.mvvmchapterenam.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.coufie.mvvmchapterenam.R
import com.coufie.mvvmchapterenam.view.adapter.CountryAdapter
import com.coufie.mvvmchapterenam.viewmodel.ViewModelCountry
import kotlinx.android.synthetic.main.activity_country.*

class CountryActivity : AppCompatActivity() {

    lateinit var countryAdapter : CountryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country)

        countryAdapter = CountryAdapter()
        rv_countries.layoutManager = LinearLayoutManager(this)
        rv_countries.adapter = countryAdapter
        initCountryViewModel()



    }

    fun initCountryViewModel(){
        val viewModel = ViewModelProvider(this).get(ViewModelCountry::class.java)
        viewModel.getLiveDataCountryy().observe(this, Observer {
            if(it != null){
                countryAdapter.setCountryList(it)
                countryAdapter.notifyDataSetChanged()
            }else{

            }

        })
        viewModel.getDataCountry()
    }

}