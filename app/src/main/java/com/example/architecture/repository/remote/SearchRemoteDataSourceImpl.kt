package com.example.architecture.repository.remote

import androidx.lifecycle.viewModelScope
import com.example.architecture.data.model.RepoSearchResponse
import com.example.howareyou.network.ServiceApi
import kotlinx.coroutines.launch

class SearchRemoteDataSourceImpl (private val service: ServiceApi) : SearchRemoteDataSource {
    override suspend fun searchRepo(query: String): RepoSearchResponse {
        val searchRepoInfo = service.searchRepo(query)
        return searchRepoInfo
    }
}


