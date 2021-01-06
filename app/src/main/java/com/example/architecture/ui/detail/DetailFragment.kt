package com.example.architecture.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.architecture.R
import com.example.architecture.databinding.FragmentDetailBinding
import com.example.architecture.ui.BaseFragment
import com.example.architecture.ui.search.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding>(R.layout.fragment_detail) {

    private val detailViewModel by viewModels<DetailViewModel>()

    lateinit var owner: String
    lateinit var name: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        owner = arguments?.getString("owner")!!
        name = arguments?.getString("name")!!

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //detailViewModel = ViewModelProvider(this, viewModelFactory { DetailViewModel(owner, name) }).get(DetailViewModel::class.java)
        binding.viewModel = detailViewModel
    }

//    protected inline fun <VM : ViewModel> viewModelFactory(crossinline f: () -> VM) =
//            object : ViewModelProvider.Factory {
//                override fun <T : ViewModel> create(aClass: Class<T>): T = f() as T
//            }

}