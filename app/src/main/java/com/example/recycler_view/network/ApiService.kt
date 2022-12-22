package com.example.recycler_view.network

import com.example.recycler_view.network.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
     @GET("users")
     fun getUsers(): Call<ArrayList<User>>

     @GET("/users/{login}")
     fun getUserDetail(@Path("login") login: String): Call<User>

}
