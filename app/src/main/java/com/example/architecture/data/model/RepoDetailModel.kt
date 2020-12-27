package com.example.architecture.data.model

data class RepoDetailModel(

    val full_name: String,
    val watchers_count: Int,
    val stargazers_count: Int,
    val forks_count: Int,
    val language: String?,
    val login: String,
    val avatar_url: String,
    val blog: String,
    val followers: Int,
    val following: Int

)

