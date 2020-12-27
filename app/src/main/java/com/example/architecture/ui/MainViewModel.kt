package com.example.architecture.ui

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.example.architecture.R
import com.example.architecture.data.model.RepoGetResponse
import com.example.architecture.data.model.RepoSearchResponse
import com.example.architecture.data.model.UserGetResponse
import com.example.architecture.ui.search.SearchFragment
import com.example.howareyou.network.RetrofitClient
import com.example.howareyou.network.ServiceApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    init {

     }

}

