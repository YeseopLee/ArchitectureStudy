package com.example.architecture.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.architecture.data.model.RepoSearchResponse
import com.example.architecture.databinding.ItemSearchBinding


class SearchAdapter : RecyclerView.Adapter<SearchAdapter.CustomViewHolder>(){

    var searchArray = ArrayList<RepoSearchResponse.RepoItem>()

    //클릭 인터페이스 정의
    interface ItemClickListener {
        fun onClick(view: View, position: Int, searchArray: ArrayList<RepoSearchResponse.RepoItem>)
    }

    //클릭리스너 선언
    private lateinit var itemClickListner: ItemClickListener

    //클릭리스너 등록 매소드
    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListner = itemClickListener
    }

    fun setItem(data: ArrayList<RepoSearchResponse.RepoItem>){
        this.searchArray.clear()
        this.searchArray.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {

        val binding = ItemSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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

        holder.onBind(searchArray[position])

        //view에 onClickListner를 달고, 그 안에서 직접 만든 itemClickListener를 연결시킨다
        holder.itemView.setOnClickListener {
            itemClickListner.onClick(it, position, searchArray)
        }

    }


}