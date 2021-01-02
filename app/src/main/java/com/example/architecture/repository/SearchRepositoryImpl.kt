package com.example.architecture.repository

import com.example.architecture.data.model.RepoSearchResponse
import com.example.architecture.repository.local.Search
import com.example.architecture.repository.local.SearchLocalDataSource
import com.example.architecture.repository.remote.SearchRemoteDataSource
import com.example.howareyou.network.ServiceApi

class SearchRepositoryImpl (
    private val searchLocalDataSource: SearchLocalDataSource,
    private val searchRemoteDataSource: SearchRemoteDataSource
) : SearchRepository {


    override suspend fun searchRepo(query: String): RepoSearchResponse {

        return searchRemoteDataSource.searchRepo(query)
    }
}