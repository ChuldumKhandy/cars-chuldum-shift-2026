package com.example.cars.rent.data.remote.enums

import kotlinx.serialization.Serializable

@Serializable
enum class CarBodyType {
    sedan,
    suv,
    coupe,
    hatchback,
    cabriolet
}