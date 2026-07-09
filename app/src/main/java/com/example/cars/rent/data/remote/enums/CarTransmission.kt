package com.example.cars.rent.data.remote.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class CarTransmission(val value: String) {

    @SerialName("automatic")
    AUTOMATIC("automatic"),

    @SerialName("manual")
    MANUAL("manual");

    companion object {
        fun fromValue(value: String): CarTransmission =
            entries.firstOrNull { it.value == value }
                ?: throw IllegalArgumentException("Unknown CarTransmission: $value")
    }
}