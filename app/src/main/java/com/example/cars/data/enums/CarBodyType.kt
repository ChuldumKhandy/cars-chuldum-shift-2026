package com.example.cars.data.enums

import kotlinx.serialization.Serializable

@Serializable
enum class CarBodyType {
    sedan,
    suv,
    coupe,
    hatchback,
    cabriolet
}