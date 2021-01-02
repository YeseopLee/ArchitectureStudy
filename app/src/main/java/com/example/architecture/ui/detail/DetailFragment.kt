package com.example.architecture.ui.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.architecture.R
import com.example.architecture.databinding.FragmentDetailBinding
import com.example.architecture.ui.MainViewModel
import com.example.architecture.ui.search.SearchViewModel
import com.example.howareyou.network.ServiceApi

class DetailFragment : Fragment() {


    private lateinit var binding: FragmentDetailBinding
    private lateinit var vm: DetailViewModel

    lateinit var owner: String
    lateinit var name: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        owner = arguments?.getString("owner")!!
        name = arguments?.getString("name")!!

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        binding.lifecycleOwner = this
        vm = ViewModelProvider(this, viewModelFactory { DetailViewModel(owner, name) }).get(DetailViewModel::class.java)
        binding.viewModel = vm
        return binding.root


    }

    protected inline fun <VM : ViewModel> viewModelFactory(crossinline f: () -> VM) =
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(aClass: Class<T>): T = f() as T
            }

}