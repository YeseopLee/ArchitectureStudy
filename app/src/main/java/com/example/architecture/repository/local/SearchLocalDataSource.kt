package com.example.architecture.repository.local

interface SearchLocalDataSource {
    fun insertAll(search: ArrayList<Search>)
    fun getAll() : ArrayList<Search>
}