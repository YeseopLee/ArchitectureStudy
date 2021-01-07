package com.example.architecture

import android.app.Application
import com.example.architecture.repository.SearchRepository
import com.example.architecture.repository.SearchRepositoryImpl
import com.example.architecture.repository.remote.SearchRemoteDataSource
import com.example.architecture.repository.remote.SearchRemoteDataSourceImpl
import com.example.architecture.util.PreferenceDB
import com.example.architecture.util.PreferenceUtil
import com.example.howareyou.network.ServiceApi
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {

    // SharedPref 사용
    companion object {
        lateinit var prefs : PreferenceDB
    }

    override fun onCreate() {
        prefs = PreferenceDB(applicationContext)
        super.onCreate()
    }

}

