package com.example.recycler_view

import retrofit2.Call
//import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
//import retrofit2.create
import retrofit2.http.GET

interface DetailsApi{
    @GET("users")
    fun getDetails() : Call<ArrayList<DetailsItem>>
}

object detailsService{

    val detailsInterface : DetailsApi
    const val BaseUrl =  "https://api.github.com/"

    init {

        val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        detailsInterface = retrofit.create(DetailsApi::class.java)






    }




}

