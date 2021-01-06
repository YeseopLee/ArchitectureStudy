package com.example.architecture

import android.app.Application
import com.example.architecture.repository.SearchRepository
import com.example.architecture.repository.SearchRepositoryImpl
import com.example.architecture.repository.remote.SearchRemoteDataSource
import com.example.architecture.repository.remote.SearchRemoteDataSourceImpl
import com.example.howareyou.network.ServiceApi
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {

    private lateinit var service: ServiceApi
    private lateinit var searchRemoteDataSource: SearchRemoteDataSource
    lateinit var searchRepository: SearchRepository

    override fun onCreate() {
        super.onCreate()
        inject()
    }

    private fun inject() {
//        searchRemoteDataSource = SearchRemoteDataSourceImpl(service)
//        searchRepository = SearchRepositoryImpl(searchRemoteDataSource)
    }

}

