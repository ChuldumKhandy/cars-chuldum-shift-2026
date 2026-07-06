package com.example.cars.data

import com.example.cars.cache.DatabaseModule
import com.example.cars.network.NetworkModule

object RepositoryModule {
    val carRepository: CarRepository by lazy {
        CarRepository(NetworkModule.carApi, DatabaseModule.carDao)
    }
}