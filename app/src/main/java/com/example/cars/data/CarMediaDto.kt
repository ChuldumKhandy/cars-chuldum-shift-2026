package com.example.cars.data

import kotlinx.serialization.Serializable

@Serializable
data class CarMediaDto(
    val url: String,
    val isCover: Boolean
)
