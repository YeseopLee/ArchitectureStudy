package com.example.architecture.repository

import com.example.architecture.data.model.RepoSearchResponse
interface SearchRepository {

    suspend fun searchRepo(
            query: String
    ) : RepoSearchResponse

}