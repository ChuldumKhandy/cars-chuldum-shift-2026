package com.example.cars.rent.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class MetaDto(
    val total: Int,
    val page: Int,
    val limit: Int,
    val totalPages: Int
)