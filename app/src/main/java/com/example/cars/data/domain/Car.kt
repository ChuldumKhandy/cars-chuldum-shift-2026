package com.example.cars.data.domain

data class Car(
    val id: String,
    val name: String,
    val brand: String,
    val coverImageUrl: String?,
    val transmission: String,
    val price: Int,
    val location: String,
    val color: String,
    val bodyType: String,
    val steering: String
)
