package com.example.recycler_view
//
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class DetailsAdapter(val context: Context, val detailItems: MutableList<DetailsItem>, val listener: OnItemListener) :
    RecyclerView.Adapter<DetailsAdapter.DetailViewHolder>() {

    class DetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var login: TextView = itemView.findViewById(R.id.login)
        var photo: ImageView = itemView.findViewById(R.id.imageView)
        var but: Button = itemView.findViewById(R.id.button)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_details, parent, false)
        return DetailViewHolder(view)
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        val item = detailItems[position]
        holder.login.text = item.login

        Glide.with(context)
            .load(item.avatar_url)
            .override(300, 350)
            .into(holder.photo)
        holder.but.setOnClickListener {
            listener.onItemCLick(position, item)
        }

        Log.e("ANSHUL", "onBindViewHolder: ${item.id}")
    }

    override fun getItemCount(): Int {
        return detailItems.size
    }

}

interface OnItemListener{
    fun onItemCLick(position: Int, item: DetailsItem)
}
