package com.example.cars.data.remote

import com.example.cars.data.remote.enums.CarBodyType
import kotlinx.serialization.Serializable
import com.example.cars.data.remote.enums.CarBrand
import com.example.cars.data.remote.enums.CarColor
import com.example.cars.data.remote.enums.CarSteering
import com.example.cars.data.remote.enums.CarTransmission

@Serializable
data class CarDto(
    val id: String,
    val name: String,
    val brand: CarBrand,
    val media: List<CarMediaDto>,
    val transmission: CarTransmission,
    val price: Int,
    val location: String,
    val color: CarColor,
    val bodyType: CarBodyType,
    val steering: CarSteering
)