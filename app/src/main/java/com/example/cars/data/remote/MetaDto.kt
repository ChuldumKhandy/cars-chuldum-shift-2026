package com.example.cars.data.remote

import kotlinx.serialization.Serializable

@Serializable
data class MetaDto(
    val total: Int,
    val page: Int,
    val limit: Int,
    val totalPages: Int
)