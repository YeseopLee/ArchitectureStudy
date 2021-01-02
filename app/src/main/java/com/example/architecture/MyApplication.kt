package com.example.architecture

import android.app.Application
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.architecture.repository.SearchRepository
import com.example.architecture.repository.SearchRepositoryImpl
import com.example.architecture.repository.remote.SearchRemoteDataSource
import com.example.architecture.repository.remote.SearchRemoteDataSourceImpl
import com.example.architecture.ui.search.SearchViewModel
import com.example.howareyou.network.RetrofitClient
import com.example.howareyou.network.ServiceApi

class MyApplication : Application() {

    private lateinit var service: ServiceApi
    private lateinit var searchRemoteDataSource: SearchRemoteDataSource
    lateinit var searchRepository: SearchRepository

    override fun onCreate() {
        super.onCreate()
        inject()
    }

    private fun inject() {
        service =  RetrofitClient.client!!.create(ServiceApi::class.java)
        searchRemoteDataSource = SearchRemoteDataSourceImpl(service)
        searchRepository = SearchRepositoryImpl(searchRemoteDataSource)
    }

}

