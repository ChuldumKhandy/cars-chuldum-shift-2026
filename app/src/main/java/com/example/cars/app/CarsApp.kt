package com.example.cars.app

import android.app.Application
import com.example.cars.core.cache.DatabaseModule

class CarsApp: Application() {
    override fun onCreate() {
        super.onCreate()

        DatabaseModule.init(this)
    }
}