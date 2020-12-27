package com.example.architecture.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.architecture.R
import com.example.architecture.databinding.FragmentDetailBinding
import com.example.howareyou.network.ServiceApi

class DetailFragment : Fragment() {


    private lateinit var mParam1: String
    private lateinit var mParam2: String

    private lateinit var binding: FragmentDetailBinding
    private lateinit var vm : DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = requireArguments().getString("owner").toString()
            mParam2 = requireArguments().getString("name").toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        vm = ViewModelProvider(this, viewModelFactory { DetailViewModel("owner","name") }).get(DetailViewModel::class.java)
        binding.viewModel = vm
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    protected inline fun <VM : ViewModel> viewModelFactory(crossinline f: () -> VM) =
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(aClass: Class<T>):T = f() as T
        }


}