package com.example.howareyou.network

import com.example.architecture.data.model.RepoGetResponse
import com.example.architecture.data.model.RepoSearchResponse
import com.example.architecture.data.model.UserGetResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*


interface ServiceApi {

    @GET("search/repositories")
    fun searchRepo(@Query("q") query: String): Call<RepoSearchResponse>

    @GET("repos/{owner}/{name}")
    fun getRepo(@Path("owner") owner: String, @Path("name") name: String): Call<RepoGetResponse>

    @GET("users/{name}")
    fun getUser(@Path("name") name: String): Call<UserGetResponse>
}