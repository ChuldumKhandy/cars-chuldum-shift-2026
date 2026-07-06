package com.example.cars.rent.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class CarMediaDto(
    val url: String,
    val isCover: Boolean
)
