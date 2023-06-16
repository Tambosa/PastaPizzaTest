package com.example.pastapizzatest.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = arrayOf(
        PastaEntity::class,
    ),
    version = 1,
    exportSchema = false,
)

abstract class RoomDb : RoomDatabase() {
    abstract fun pastaDao(): PastaDao
}