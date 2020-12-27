package com.example.architecture.util

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.architecture.R
import com.example.architecture.data.model.RepoSearchResponse
import com.example.architecture.ui.MainActivity
import com.example.architecture.ui.MainViewModel
import com.example.architecture.ui.adapter.SearchAdapter
import com.example.architecture.ui.detail.DetailFragment
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
            override fun onClick(view: View, position: Int, searchArray: ArrayList<RepoSearchResponse.RepoItem>) {
                val bundle = bundleOf("owner" to searchArray[position].owner.login, "name" to searchArray[position].name)
                view.findNavController().navigate(R.id.action_searchFragment_to_detailFragment, bundle)
            }
        })
    }
}

