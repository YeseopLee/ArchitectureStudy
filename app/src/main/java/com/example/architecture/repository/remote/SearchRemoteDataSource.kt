package com.example.architecture.repository.remote

import com.example.architecture.data.model.RepoSearchResponse

interface SearchRemoteDataSource {
    suspend fun searchRepo(
            query: String
    ) : RepoSearchResponse
}