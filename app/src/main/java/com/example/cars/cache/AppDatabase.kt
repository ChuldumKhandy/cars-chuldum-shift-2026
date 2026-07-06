package com.example.cars.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cars.data.local.CarDao
import com.example.cars.data.local.CarEntity

@Database(
    entities = [CarEntity::class],
    version = 1,
    exportSchema = false
)

abstract class AppDatabase: RoomDatabase() {
    abstract fun carDao(): CarDao
}