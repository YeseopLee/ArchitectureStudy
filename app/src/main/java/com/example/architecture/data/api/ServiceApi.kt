package com.example.howareyou.network

import com.example.architecture.data.model.RepoGetResponse
import com.example.architecture.data.model.RepoSearchResponse
import com.example.architecture.data.model.UserGetResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*


interface ServiceApi {

    @GET("search/repositories?q=kotlin")
    suspend fun mainRepo(): RepoSearchResponse

    @GET("search/repositories")
    suspend fun searchRepo(@Query("q") query: String): RepoSearchResponse

    @GET("repos/{owner}/{name}")
    suspend fun getRepo(@Path("owner") owner: String, @Path("name") name: String): RepoGetResponse

    @GET("users/{name}")
    suspend fun getUser(@Path("name") name: String): UserGetResponse
}