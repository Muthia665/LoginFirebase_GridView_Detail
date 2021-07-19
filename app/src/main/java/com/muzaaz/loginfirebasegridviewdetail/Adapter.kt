package com.muzaaz.loginfirebasegridviewdetail

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AdapterList (private val list: ArrayList<Model>): RecyclerView.Adapter<AdapterList.ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.listitem, parent, false)

        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = list[position]
        holder.tvname.text = data.name
        Glide.with(holder.itemView.context).load(data.photo).into(holder.imgPhoto)

        holder.itemView.setOnClickListener {
            var intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("name", data.name)
            intent.putExtra("photo", data.photo)
            intent.putExtra("detail", data.detail)
            holder.itemView.context.startActivity(intent)
        }
    }

    class ListViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var tvname: TextView = view.findViewById(R.id.txt_item)
        val imgPhoto: ImageView = view.findViewById(R.id.img_item)
    }
}