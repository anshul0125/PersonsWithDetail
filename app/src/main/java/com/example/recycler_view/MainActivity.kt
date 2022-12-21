package com.example.recycler_view

//import kotlinx.coroutines.DefaultExecutor.enqueue
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

lateinit var recycler: RecyclerView
lateinit var adapter: DetailsAdapter
//var detailsItem: MutableList<DetailsItem>? = arrayListOf()


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
        val details = detailsService.detailsInterface.getDetails()
        details.enqueue(object : Callback<ArrayList<DetailsItem>> {
            override fun onResponse(
                call: Call<ArrayList<DetailsItem>>,
                response: Response<ArrayList<DetailsItem>>
            ) {
//                Log.d("ANSHUL", "Output is: -")
                loadDataOnUi(response.body())
            }

            override fun onFailure(
                call: Call<ArrayList<DetailsItem>>,
                t: Throwable
            ) {
                Log.d("ANSHUL", "Error Occured!!" + t.message)

            }

        })
    }

    private fun loadDataOnUi(details: ArrayList<DetailsItem>?) {
        if (details != null) {
//            Log.d("ANSHUL", "Output is: -" + details.toString())
            recycler.layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = DetailsAdapter(this@MainActivity, details, this@MainActivity)
            recycler.adapter = adapter
        }
    }

    override fun onItemCLick(position: Int, item: DetailsItem) {
//        Toast.makeText(applicationContext, item.id.toString(), Toast.LENGTH_LONG).show()
        Snackbar.make(recycler, "Your Node Id is:- ${item.node_id}",  Snackbar.LENGTH_LONG).show()
        val login : String = item.login
        val intent = Intent(this@MainActivity, knowMore::class.java)
        intent.putExtra("LOGIN", login)
        startActivity(intent)
    }

}