package com.example.architecture.data.model

data class UserGetResponse(
    val login: String,
    val avatar_url: String,
    val blog: String,
    val followers: Int,
    val following: Int
)