package com.example.architecture.repository.remote

import com.example.architecture.data.model.RepoSearchResponse
import com.example.howareyou.network.ServiceApi
import javax.inject.Inject
import javax.inject.Singleton


class SearchRemoteDataSourceImpl @Inject constructor (private val service: ServiceApi) : SearchRemoteDataSource {
    override suspend fun searchRepo(query: String): RepoSearchResponse {
        return service.searchRepo(query)
    }
}


