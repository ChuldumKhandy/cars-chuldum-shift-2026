package com.example.cars.rent.data.remote.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class CarBrand(val value: String) {

    @SerialName("haval")
    HAVAL("haval"),

    @SerialName("hyundai")
    HYUNDAI("hyundai"),

    @SerialName("volkswagen")
    VOLKSWAGEN("volkswagen"),

    @SerialName("kia")
    KIA("kia"),

    @SerialName("geely")
    GEELY("geely"),

    @SerialName("mercedes")
    MERCEDES("mercedes"),

    @SerialName("garden_car")
    GARDEN_CAR("garden_car"),

    @SerialName("grocery_cart")
    GROCERY_CART("grocery_cart"),

    @SerialName("haier")
    HAIER("haier"),

    @SerialName("invalid")
    INVALID("invalid");

    companion object {
        fun fromValue(value: String): CarBrand =
            entries.firstOrNull { it.value == value }
                ?: throw IllegalArgumentException("Unknown CarBrand: $value")
    }
}