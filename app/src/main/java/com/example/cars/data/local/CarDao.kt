package com.example.cars.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CarDao {
    @Query("SELECT * FROM cars ORDER BY cachedAt DESC")
    suspend fun getCars(): List<CarEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCars(cars: List<CarEntity>)

    @Query("DELETE FROM cars")
    suspend fun clear()
}