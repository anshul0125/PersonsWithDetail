package com.example.recycler_view

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class knowMore : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_know_more)
        val login: String? = intent.getStringExtra("URL")


//        intent.putExtra("URL", login)

        val name: TextView = findViewById(R.id.name)
        val followers : TextView = findViewById(R.id.followers)
        val following : TextView = findViewById(R.id.following)
        val details = InsideService.detailsInterface.getDetails()

        details.enqueue(object : Callback<InPerson> {
            override fun onResponse(call: Call<InPerson>, response: Response<InPerson>) {
//                getStatus(response.body())
                Log.d("ANSHUL", "Output is: -" + response.body()?.name.toString())
                name.text = response.body()?.name.toString()
                followers.text = response.body()?.followers.toString()
                following.text = response.body()?.following.toString()
            }

            override fun onFailure(call: Call<InPerson>, t: Throwable) {
                Log.d("ANSHUL", "Error Occured!!" + t.message)
            }


        })


//        getDetail()
    }

//    private fun getDetail() {
//
//        val details = InsideService.detailsInterface.getDetails()
////        val details = InsideService.URL
////        println(details)
//        details.enqueue(object : Callback<InPerson> {
//            override fun onResponse(call: Call<InPerson>, response: Response<InPerson>) {
////                getStatus(response.body())
//                Log.d("ANSHUL", "Output is: -" + response.body()?.name.toString())
//
//
//
//            }
//
//            override fun onFailure(call: Call<InPerson>, t: Throwable) {
//                Log.d("ANSHUL", "Error Occured!!" + t.message)
//            }
//
//
//        })
//        Log.d("ANSHUL", "Error Occured!!")
//        println("HEY " + " There")




//    }


}


