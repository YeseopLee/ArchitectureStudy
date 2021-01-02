package com.example.architecture.repository

import com.example.architecture.data.model.RepoSearchResponse
import com.example.architecture.repository.remote.SearchRemoteDataSource
import com.example.howareyou.network.ServiceApi

class SearchRepositoryImpl (
    private val searchRemoteDataSource: SearchRemoteDataSource
) : SearchRepository {


    override suspend fun searchRepo(query: String): RepoSearchResponse {

        // local 데이터가 존재해야 한다면 이곳에 분기를 만들어야한다.
        return searchRemoteDataSource.searchRepo(query)
    }
}