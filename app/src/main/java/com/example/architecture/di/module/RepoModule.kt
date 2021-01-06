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
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepoModule {

    @Singleton
    @Provides
    fun provideSearchRemoteDataSource(serviceApi: ServiceApi) = SearchRemoteDataSourceImpl(serviceApi)

    @Singleton
    @Provides
    fun provideSearchRepo(searchRemoteDataSource: SearchRemoteDataSource) = SearchRepositoryImpl(searchRemoteDataSource)
}