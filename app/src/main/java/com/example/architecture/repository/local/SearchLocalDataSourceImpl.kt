package com.example.architecture.repository.local

import com.example.architecture.data.model.RepoSearchResponse

class SearchLocalDataSourceImpl (private val searchDao: SearchDao) : SearchLocalDataSource {
    override fun insertAll(search: ArrayList<Search>) {
        searchDao.insertAll(search)
    }

    override fun getAll(): ArrayList<Search> {
        return searchDao.getAll()
    }

}