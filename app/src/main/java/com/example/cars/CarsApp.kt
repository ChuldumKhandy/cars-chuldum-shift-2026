package com.example.cars

import android.app.Application
import android.content.Context
import com.example.cars.cache.DatabaseModule

class CarsApp: Application() {
    override fun onCreate() {
        super.onCreate()

        DatabaseModule.init(this)
    }
}

object AppContextHolder {
    lateinit var appContext: Context
        private set

    fun init(context: Context) {
        appContext = context.applicationContext
    }
}