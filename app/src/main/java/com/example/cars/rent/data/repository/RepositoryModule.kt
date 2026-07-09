package com.example.cars.rent.data.repository

import com.example.cars.core.cache.DatabaseModule
import com.example.cars.core.network.NetworkModule

object RepositoryModule {
    val carRepository: CarRepository by lazy {
        CarRepository(NetworkModule.carApi, DatabaseModule.carDao)
    }
}