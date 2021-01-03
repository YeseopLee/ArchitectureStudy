package com.example.architecture.repository.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MainDao  {

    @Insert()
    fun insertInit(search: ArrayList<Main>)

    @Query("SELECT * FROM main")
    fun showInit() : ArrayList<Main>
}