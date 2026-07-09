package com.example.cars.core.cache

import android.content.Context
import androidx.room.Room
import com.example.cars.rent.data.local.CarDao

object DatabaseModule {

    @Volatile
    private var appContext: Context? = null

    fun init(context: Context) {
        appContext = context.applicationContext
    }

    val database: AppDatabase by lazy {
        Room.databaseBuilder(
            checkNotNull(appContext) {
                "DatabaseModule.init() must be called before accessing database"
            },
            AppDatabase::class.java,
            "cars.db"
        ).build()
    }

    val carDao: CarDao by lazy {
        database.carDao()
    }
}