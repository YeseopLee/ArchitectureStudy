package com.example.architecture.di.module

import com.example.architecture.repository.SearchRepository
import com.example.architecture.repository.SearchRepositoryImpl
import com.example.architecture.repository.remote.SearchRemoteDataSource
import com.example.architecture.repository.remote.SearchRemoteDataSourceImpl
import com.example.howareyou.network.ServiceApi
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class RepoBindModule {

    @Binds
    abstract fun bindSearchRemote(remoteDataSource: SearchRemoteDataSourceImpl) : SearchRemoteDataSource

    @Binds
    abstract fun bindSearchRepo(searchRepo: SearchRepositoryImpl) : SearchRepository
}