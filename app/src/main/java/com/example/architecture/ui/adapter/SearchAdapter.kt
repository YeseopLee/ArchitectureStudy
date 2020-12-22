package com.example.architecture.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.architecture.R
import com.example.architecture.data.model.RepoSearchResponse
import com.example.architecture.databinding.ItemSearchBinding
import com.example.architecture.ui.MainActivity
import com.example.architecture.ui.model.SearchData
import com.example.architecture.util.Utils


class SearchAdapter(val context: Context, val searchArray: ArrayList<RepoSearchResponse.RepoItem>) : RecyclerView.Adapter<SearchAdapter.CustomViewHolder>(){

    //클릭 인터페이스 정의
    interface ItemClickListener {
        fun onClick(view: View, position: Int)
    }

    //클릭리스너 선언
    private lateinit var itemClickListner: ItemClickListener

    //클릭리스너 등록 매소드
    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListner = itemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {

        val binding = ItemSearchBinding.inflate(LayoutInflater.from(context), parent, false)
        return CustomViewHolder(binding)
    }

    class CustomViewHolder(val binding : ItemSearchBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data : RepoSearchResponse.RepoItem){
            binding.searchitem = data
        }
    }

    override fun getItemCount(): Int {
        return searchArray.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        var view = holder.itemView

        val iv_profile = view.findViewById<ImageView>(R.id.search_imageview_profile)

        holder.onBind(searchArray[position])
//        val tv_fullName = view.findViewById<TextView>(R.id.search_textview_fullName)
//        val tv_owner = view.findViewById<TextView>(R.id.search_textview_owner)
//
//        tv_fullName.text = searchArray[position].full_name
//        tv_owner.text = searchArray[position].owner.login

        //view에 onClickListner를 달고, 그 안에서 직접 만든 itemClickListener를 연결시킨다
        holder.itemView.setOnClickListener {
            itemClickListner.onClick(it, position)
        }

    }


}