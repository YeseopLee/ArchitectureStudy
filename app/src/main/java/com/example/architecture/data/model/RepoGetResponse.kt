package com.example.architecture.data.model

data class RepoGetResponse(
    val full_name: String,
    val watchers_count: Int,
    val stargazers_count: Int,
    val forks_count: Int,
    val language: String?
)