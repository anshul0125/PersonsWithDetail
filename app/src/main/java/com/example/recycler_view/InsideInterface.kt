package com.example.recycler_view
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface InsideApi {
    @GET("defunkt")
    fun getDetails() : Call<InPerson>
}

object InsideService{

//    val URL = knowMore().intent.getStringExtra("URL")

    val detailsInterface : InsideApi
    val BaseUrl = "https://api.github.com/users/"

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        detailsInterface = retrofit.create(InsideApi::class.java)

    }



}