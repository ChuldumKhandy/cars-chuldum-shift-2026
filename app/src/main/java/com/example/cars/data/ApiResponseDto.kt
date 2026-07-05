package com.example.cars.data

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponseDto<T>(
    val success: Boolean,
    val reason: String,
    val data: T,
    val meta: MetaDto? = null
)