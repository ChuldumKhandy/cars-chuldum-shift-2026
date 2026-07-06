package com.example.cars.data.remote

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponseDto<T>(
    val success: Boolean,
    val reason: String? = null,
    val data: T,
    val meta: MetaDto? = null
)