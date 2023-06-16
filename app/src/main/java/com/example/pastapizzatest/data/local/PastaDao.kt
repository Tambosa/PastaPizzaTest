package com.example.pastapizzatest.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PastaDao {

    @Query("SELECT * FROM ${RoomConst.TABLE_PASTA}")
    suspend fun getAll(): List<PastaEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPasta(pasta: PastaEntity)
}
