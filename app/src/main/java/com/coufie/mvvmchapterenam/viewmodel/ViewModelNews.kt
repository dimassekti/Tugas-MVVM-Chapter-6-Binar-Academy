package com.coufie.mvvmchapterenam.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.coufie.mvvmchapterenam.model.getAllNews
import com.coufie.mvvmchapterenam.model.getAllNewsItem
import com.coufie.mvvmchapterenam.network.ApiClient
import retrofit2.Call
import retrofit2.Response

class ViewModelNews : ViewModel() {

    lateinit var liveDataNews : MutableLiveData<List<getAllNewsItem>>

    init {
        liveDataNews = MutableLiveData()
    }

    fun getLiveDataNewss() : MutableLiveData<List<getAllNewsItem>>{
        return liveDataNews
    }

    fun getDataNews(){
        ApiClient.instance.getAllNews()
            .enqueue(object : retrofit2.Callback<List<getAllNewsItem>>{
                override fun onResponse(
                    call: Call<List<getAllNewsItem>>,
                    response: Response<List<getAllNewsItem>>
                ) {
                    if(response.isSuccessful){
                        liveDataNews.postValue(response.body())
                    }else{
                        liveDataNews.postValue(null)

                    }

                }

                override fun onFailure(call: Call<List<getAllNewsItem>>, t: Throwable) {
                    liveDataNews.postValue(null)
                }

            })
    }
}