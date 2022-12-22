package com.example.recycler_view.ui


import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import com.example.recycler_view.DetailsAdapter
import com.example.recycler_view.OnItemListener
import com.example.recycler_view.R
import com.example.recycler_view.network.RetrofitService
import com.example.recycler_view.network.model.User
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

lateinit var recycler: RecyclerView
lateinit var adapter: DetailsAdapter

class MainActivity : AppCompatActivity(), OnItemListener {

    //    private var detailsItem: List<DetailsItem>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler = findViewById(R.id.recyclerView)
        recycler.layoutManager = LinearLayoutManager(this, HORIZONTAL, false)

        getDetail()


    }

    private fun getDetail() {
        val details = RetrofitService.retrofitApiService.getUsers()
        details.enqueue(object : Callback<ArrayList<User>> {
            override fun onResponse(
                call: Call<ArrayList<User>>,
                response: Response<ArrayList<User>>
            ) {
//                Log.d("ANSHUL", "Output is: -")
                loadDataOnUi(response.body())
            }

            override fun onFailure(
                call: Call<ArrayList<User>>,
                t: Throwable
            ) {
                Log.d("ANSHUL", "Error Occured!!" + t.message)

            }

        })
    }

    private fun loadDataOnUi(details: ArrayList<User>?) {
        if (details != null) {
//            Log.d("ANSHUL", "Output is: -" + details.toString())
            recycler.layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = DetailsAdapter(this@MainActivity, details, this@MainActivity)
            recycler.adapter = adapter
        }
    }

    override fun onItemCLick(position: Int, user: User) {
//        Toast.makeText(applicationContext, item.id.toString(), Toast.LENGTH_LONG).show()
        Snackbar.make(recycler, "Your Node Id is:- ${user.node_id}",  Snackbar.LENGTH_LONG).show()
        val login : String = user.login
        val intent = Intent(this@MainActivity, KnowMoreActivity::class.java)
        intent.putExtra("LOGIN", login)
        startActivity(intent)
    }

}