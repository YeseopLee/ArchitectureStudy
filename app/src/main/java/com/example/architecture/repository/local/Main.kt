package com.example.architecture.repository.local

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "main")
data class Main(
    @PrimaryKey var id: Int,
    val total_count: Int,
    val full_name: String,
    val login: String,
    val avatar_url: String
)
