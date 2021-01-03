package com.example.architecture.repository.remote

import com.example.architecture.data.model.RepoSearchResponse
import com.example.howareyou.network.ServiceApi

class MainRemoteDataSourceImpl (private val service: ServiceApi) : MainRemoteDataSource {
    override suspend fun initMain() : RepoSearchResponse{
        return service.mainRepo()
    }


}
