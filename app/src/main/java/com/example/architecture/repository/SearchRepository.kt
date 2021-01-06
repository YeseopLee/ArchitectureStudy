package com.example.architecture.repository

import com.example.architecture.data.model.RepoSearchResponse
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

interface SearchRepository {

    suspend fun searchRepo(
            query: String
    ) : RepoSearchResponse

}