package com.example.architecture.repository.local

interface MainLocalDataSource {
    suspend fun insertInit(main: ArrayList<Main>)
    suspend fun showInit() : ArrayList<Main>
}