package com.example.architecture.repository

import com.example.architecture.data.BaseResponse
import com.example.architecture.data.model.RepoDetailModel
import com.example.architecture.data.model.RepoSearchResponse

interface RepoRepository {

    fun searchRepo(query: String, callback: BaseResponse<RepoSearchResponse>)

    fun getDetail(owner: String, name: String, callback: BaseResponse<RepoDetailModel>)

}