package com.example.architecture.repository.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "search")
data class Search(
    @PrimaryKey(autoGenerate = false)
    @SerializedName("total_count")
    val total_count: Int,
    @SerializedName("full_name")
    val full_name: String,
    @SerializedName("login")
    val login: String,
    @SerializedName("avatar_url")
    val avatar_url: String
)