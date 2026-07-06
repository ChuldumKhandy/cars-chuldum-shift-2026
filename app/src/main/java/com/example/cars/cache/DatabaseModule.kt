package com.example.cars.cache

import android.content.Context
import androidx.room.Room
import com.example.cars.data.local.CarDao

object DatabaseModule {
    lateinit var database: AppDatabase

    fun init(context: Context) {
        database = Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "cars.db"
        ).build()
    }

    val carDao: CarDao by lazy { database.carDao() }
}