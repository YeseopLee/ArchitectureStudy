package com.example.architecture.repository

import com.example.architecture.data.model.RepoSearchResponse
import com.example.architecture.repository.local.Main

interface MainRepository {
    suspend fun initMain() : RepoSearchResponse
}