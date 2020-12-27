package com.example.architecture.util

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.architecture.data.model.RepoSearchResponse
import com.example.architecture.ui.MainActivity
import com.example.architecture.ui.adapter.SearchAdapter
import com.example.architecture.ui.search.SearchViewModel

object BindingAdapter {

    @BindingAdapter("imgRes")
    @JvmStatic
    fun setImageResource(v : ImageView, imageUrl : String?){
        Glide.with(v.context).load(imageUrl).into(v)
    }

    @BindingAdapter("searchData")
    @JvmStatic
    fun bindRecyclerView(recyclerView: RecyclerView, data: ArrayList<RepoSearchResponse.RepoItem>?) {
        val adapter = recyclerView.adapter as SearchAdapter
        if (data != null) {
            adapter.setItem(data)
        }
    }

    @BindingAdapter("itemClickListener")
    @JvmStatic
    fun clickRecyclerView(recyclerView: RecyclerView, viewModel : SearchViewModel){
        val adapter = recyclerView.adapter as SearchAdapter
        adapter.setItemClickListener(object : SearchAdapter.ItemClickListener{
            override fun onClick(view: View, position: Int) {
                Log.e("???","???")
            }
        })
    }
}