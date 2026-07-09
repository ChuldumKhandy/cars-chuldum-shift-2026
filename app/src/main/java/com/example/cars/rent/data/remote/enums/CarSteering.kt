package com.example.cars.rent.data.remote.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class CarSteering(val value: String) {

    @SerialName("left")
    LEFT("left"),

    @SerialName("right")
    RIGHT("right");

    companion object {
        fun fromValue(value: String): CarSteering =
            entries.firstOrNull { it.value == value }
                ?: throw IllegalArgumentException("Unknown CarTransmission: $value")
    }
}