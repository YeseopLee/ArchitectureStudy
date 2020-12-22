package com.example.architecture.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BindingAdapter {

    @BindingAdapter("imgRes")
    @JvmStatic
    fun setImageResource(v : ImageView, imageUrl : String?){
        Glide.with(v.context).load(imageUrl).into(v)
    }
}