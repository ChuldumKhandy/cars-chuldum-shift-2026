package com.example.cars.rent.data.remote.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class CarColor(val value: String) {

    @SerialName("black")
    BLACK("black"),

    @SerialName("white")
    WHITE("white"),

    @SerialName("red")
    RED("red"),

    @SerialName("silver")
    SILVER("silver"),

    @SerialName("blue")
    BLUE("blue"),

    @SerialName("grey")
    GREY("grey"),

    @SerialName("orange")
    ORANGE("orange");

    companion object {
        fun fromValue(value: String): CarColor =
            entries.firstOrNull { it.value == value }
                ?: throw IllegalArgumentException("Unknown CarTransmission: $value")
    }

}