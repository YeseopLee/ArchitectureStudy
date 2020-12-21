package com.example.architecture.data.model

data class UserGetResponse(
    val login: String,
    val name: String,
    val url: String,
    val html_url: String,

    val avatar_url: String,
    val blog: String,
    val company: String,
    val followers: Int,
    val following: Int,
    val created_at: String
)