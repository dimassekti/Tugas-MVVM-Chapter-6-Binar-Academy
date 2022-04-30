package com.coufie.mvvmchapterenam.network

import com.coufie.mvvmchapterenam.model.getAllNewsItem
import com.coufie.mvvmchapterenam.model.getAllStaffItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("news")
    fun getAllNews() : Call<List<getAllNewsItem>>

    @GET("staf")
    fun getAllStaf() : Call<List<getAllStaffItem>>
}
