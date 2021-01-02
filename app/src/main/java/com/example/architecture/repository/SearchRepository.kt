package com.example.architecture.repository

import com.example.architecture.data.model.RepoSearchResponse
import com.example.architecture.repository.local.Search

interface SearchRepository {

    suspend fun searchRepo(
            query: String
    ) : RepoSearchResponse

}