package com.example.cars.core.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cars.rent.data.local.CarDao
import com.example.cars.rent.data.local.CarEntity

@Database(
    entities = [CarEntity::class],
    version = 1,
    exportSchema = false
)

abstract class AppDatabase: RoomDatabase() {
    abstract fun carDao(): CarDao
}