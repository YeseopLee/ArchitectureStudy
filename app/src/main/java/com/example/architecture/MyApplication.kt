package com.example.architecture

import android.app.Application
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.architecture.repository.MainRepository
import com.example.architecture.repository.MainRepositoryImpl
import com.example.architecture.repository.SearchRepository
import com.example.architecture.repository.SearchRepositoryImpl
import com.example.architecture.repository.local.MainDao
import com.example.architecture.repository.local.MainDatabase
import com.example.architecture.repository.local.MainLocalDataSource
import com.example.architecture.repository.local.MainLocalDataSourceImpl
import com.example.architecture.repository.remote.MainRemoteDataSource
import com.example.architecture.repository.remote.MainRemoteDataSourceImpl
import com.example.architecture.repository.remote.SearchRemoteDataSource
import com.example.architecture.repository.remote.SearchRemoteDataSourceImpl
import com.example.architecture.ui.search.SearchViewModel
import com.example.howareyou.network.RetrofitClient
import com.example.howareyou.network.ServiceApi

class MyApplication : Application() {

    private lateinit var service: ServiceApi
    private lateinit var searchRemoteDataSource: SearchRemoteDataSource
    private lateinit var mainLocalDataSource: MainLocalDataSource
    private lateinit var mainRemoteDataSource: MainRemoteDataSource
    private lateinit var mainDao: MainDao
    lateinit var searchRepository: SearchRepository
    lateinit var mainRepository: MainRepository

    override fun onCreate() {
        super.onCreate()
        inject()
    }

    private fun inject() {
        service =  RetrofitClient.client!!.create(ServiceApi::class.java)
        //mainDao = MainDatabase.getInstance(this).mainDao()
        searchRemoteDataSource = SearchRemoteDataSourceImpl(service)
        mainRemoteDataSource = MainRemoteDataSourceImpl(service)
        //mainLocalDataSource = MainLocalDataSourceImpl(mainDao)
        searchRepository = SearchRepositoryImpl(searchRemoteDataSource)
        //mainRepository = MainRepositoryImpl(mainLocalDataSource,mainRemoteDataSource)
        mainRepository = MainRepositoryImpl(mainRemoteDataSource)
    }

}

