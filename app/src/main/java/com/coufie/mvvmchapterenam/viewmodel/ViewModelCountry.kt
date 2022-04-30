package com.coufie.mvvmchapterenam.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.coufie.mvvmchapterenam.model.getAllCountryItem
import com.coufie.mvvmchapterenam.network.CountryApi
import retrofit2.Call
import retrofit2.Response

class ViewModelCountry : ViewModel(){

    lateinit var liveDataCountry : MutableLiveData<List<getAllCountryItem>>

    init{
        liveDataCountry = MutableLiveData()
    }

    fun getLiveDataCountryy() : MutableLiveData<List<getAllCountryItem>>{
        return liveDataCountry
    }

    fun getDataCountry(){
        CountryApi.instance.getAllCountry()
            .enqueue(object : retrofit2.Callback<List<getAllCountryItem>>{
                override fun onResponse(
                    call: Call<List<getAllCountryItem>>,
                    response: Response<List<getAllCountryItem>>
                ) {
                    if(response.isSuccessful){
                        liveDataCountry.postValue(response.body())
                    }else{
                        liveDataCountry.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<getAllCountryItem>>, t: Throwable) {
                    liveDataCountry.postValue(null)
                }

            })
    }

}