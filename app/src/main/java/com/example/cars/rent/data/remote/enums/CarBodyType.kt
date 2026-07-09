package com.example.cars.rent.data.remote.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class CarBodyType(val value: String) {
    @SerialName("sedan")
    SEDAN("sedan"),

    @SerialName("suv")
    SUV("suv"),

    @SerialName("coupe")
    COUPE("coupe"),

    @SerialName("hatchback")
    HATCHBACK("hatchback"),

    @SerialName("cabriolet")
    CABRIOLET("cabriolet");

    companion object {
        fun fromValue(value: String): CarBodyType =
            entries.firstOrNull { it.value == value }
                ?: throw IllegalArgumentException("Unknown CarTransmission: $value")
    }
}