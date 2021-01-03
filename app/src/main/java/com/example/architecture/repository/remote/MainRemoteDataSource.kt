package com.example.architecture.repository.remote

import com.example.architecture.data.model.RepoSearchResponse
import com.example.architecture.repository.local.Main

interface MainRemoteDataSource {
    suspend fun initMain() : RepoSearchResponse
}