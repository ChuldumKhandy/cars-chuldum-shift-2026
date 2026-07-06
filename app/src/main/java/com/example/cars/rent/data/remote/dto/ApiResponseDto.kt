package com.example.cars.rent.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponseDto<T>(
    val success: Boolean,
    val reason: String? = null,
    val data: T,
    val meta: MetaDto? = null
)