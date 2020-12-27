package com.example.architecture.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.architecture.R
import com.example.architecture.databinding.FragmentSearchBinding
import com.example.architecture.ui.MainViewModel
import com.example.architecture.ui.adapter.SearchAdapter

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var vm : SearchViewModel
    private lateinit var searchAdapter : SearchAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_search,container, false)
        binding.lifecycleOwner = this
        vm = ViewModelProvider(this).get(SearchViewModel::class.java)
        binding.viewModel = vm

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
    }

    private fun initAdapter(){
        searchAdapter = SearchAdapter()
        binding.searchRecyclerview.adapter = searchAdapter
    }

}