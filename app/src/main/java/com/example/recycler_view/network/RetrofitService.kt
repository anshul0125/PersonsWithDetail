package com.example.recycler_view.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    val retrofitApiService : ApiService
    private const val BaseUrl =  "https://api.github.com/"
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofitApiService = retrofit.create(ApiService::class.java)
    }

}