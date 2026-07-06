package com.example.cars.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cars")
data class CarEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val brand: String,
    val imageUrl: String,
    val transmission: String,
    val price: Int,
    val location: String,
    val color: String,
    val bodyType: String,
    val steering: String,

    val cachedAt: Long = System.currentTimeMillis()
)
