package com.example.architecture

import android.app.Application
import android.util.Log
import com.example.architecture.repository.SearchRepository
import com.example.architecture.repository.SearchRepositoryImpl
import com.example.architecture.repository.local.SearchDao
import com.example.architecture.repository.local.SearchDatabase
import com.example.architecture.repository.local.SearchLocalDataSource
import com.example.architecture.repository.local.SearchLocalDataSourceImpl
import com.example.architecture.repository.remote.SearchRemoteDataSource
import com.example.architecture.repository.remote.SearchRemoteDataSourceImpl
import com.example.howareyou.network.RetrofitClient
import com.example.howareyou.network.ServiceApi

class MyApplication : Application() {

    private lateinit var service: ServiceApi
    private lateinit var searchRemoteDataSource: SearchRemoteDataSource
    private lateinit var searchLocalDataSource: SearchLocalDataSource
    private lateinit var searchDao: SearchDao
    lateinit var searchRepository: SearchRepository

    override fun onCreate() {
        super.onCreate()
        inject()
    }

    private fun inject() {
        service =  RetrofitClient.client!!.create(ServiceApi::class.java)
        searchDao = SearchDatabase.getInstance(this).searchDao()
        searchLocalDataSource = SearchLocalDataSourceImpl(searchDao)
        searchRemoteDataSource = SearchRemoteDataSourceImpl(service)
        searchRepository = SearchRepositoryImpl(searchLocalDataSource, searchRemoteDataSource)
    }
}