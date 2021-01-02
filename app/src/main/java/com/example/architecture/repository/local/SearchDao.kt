package com.example.architecture.repository.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SearchDao{

    @Insert
    fun insertAll(vararg search : ArrayList<Search>)

    @Query("SELECT * FROM search")
    fun getAll(): ArrayList<Search>

}