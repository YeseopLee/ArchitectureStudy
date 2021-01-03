package com.example.architecture.repository

import androidx.compose.ui.viewinterop.viewModel
import androidx.lifecycle.viewModelScope
import com.example.architecture.data.model.RepoSearchResponse
import com.example.architecture.repository.local.Main
import com.example.architecture.repository.local.MainLocalDataSource
import com.example.architecture.repository.remote.MainRemoteDataSource
import kotlinx.coroutines.*

class MainRepositoryImpl(
    private val mainLocalDataSource: MainLocalDataSource,
    private val mainRemoteDataSource: MainRemoteDataSource,
) : MainRepository {
    lateinit var result1 : RepoSearchResponse
    lateinit var result2 : Main
    override suspend fun initMain() {


//        GlobalScope.launch {
//            val a = async(Dispatchers.Default){
//                if(mainLocalDataSource.showInit().isNotEmpty()){
//
//                }
//            }
//
//            val b = async(Dispatchers.Default){
//
//            }
//            a.await()
//            b.await()
//        }
    }


}