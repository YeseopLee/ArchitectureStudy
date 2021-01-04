package com.example.architecture.repository

import androidx.compose.ui.viewinterop.viewModel
import androidx.lifecycle.viewModelScope
import com.example.architecture.data.model.RepoSearchResponse
import com.example.architecture.repository.local.Main
import com.example.architecture.repository.local.MainLocalDataSource
import com.example.architecture.repository.remote.MainRemoteDataSource
import kotlinx.coroutines.*

class MainRepositoryImpl(
    private val mainRemoteDataSource: MainRemoteDataSource
) : MainRepository {
    override suspend fun initMain() : RepoSearchResponse {

        return mainRemoteDataSource.initMain()
    }


}