package com.example.architecture.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.architecture.MyApplication
import com.example.architecture.R
import com.example.architecture.databinding.FragmentSearchBinding
import com.example.architecture.ui.BaseFragment
import com.example.architecture.ui.adapter.SearchAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding>(R.layout.fragment_search) {

    private lateinit var searchAdapter: SearchAdapter

    private val searchViewModel by viewModels<SearchViewModel>()

//    private val searchViewModel: SearchViewModel by viewModels {
//        object : ViewModelProvider.Factory {
//            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//                return SearchViewModel(myApplication.searchRepository) as T
//            }
//        }
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = searchViewModel
        initAdapter()
    }

    private fun initAdapter() {
        searchAdapter = SearchAdapter()
        binding.searchRecyclerview.adapter = searchAdapter
    }

}