package com.example.architecture.repository.local

class MainLocalDataSourceImpl (private val mainDao: MainDao) : MainLocalDataSource {
    override suspend fun insertInit(main: ArrayList<Main>) {
        mainDao.insertInit(main)
    }

    override suspend fun showInit(): ArrayList<Main> {
        return mainDao.showInit()
    }

}