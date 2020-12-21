package com.example.architecture.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.architecture.R
import com.example.architecture.data.model.RepoSearchResponse


class SearchAdapter(val context: Context, val searchArray: ArrayList<RepoSearchResponse.RepoItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when(viewType) {
            0 -> {
                var view = LayoutInflater.from(context).inflate(R.layout.item_search, parent, false)
                CustomViewHolder(view)
            }
            else -> throw RuntimeException("에러")
        }

        //return CustomViewHolder(view)
    }

    inner class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun getItemCount(): Int {
        return searchArray.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        var view = holder.itemView

        val iv_profile = view.findViewById<ImageView>(R.id.search_imageview_profile)
        val tv_fullName = view.findViewById<TextView>(R.id.search_textview_fullName)
        val tv_owner = view.findViewById<TextView>(R.id.search_textview_owner)

        tv_fullName.text = searchArray[position].full_name
        tv_owner.text = searchArray[position].owner.login

        Glide.with(view).load(searchArray[position].owner.avatar_url).into(iv_profile)


    }

}