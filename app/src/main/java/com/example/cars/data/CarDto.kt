package com.example.cars.data

import com.example.cars.data.enums.CarBodyType
import kotlinx.serialization.Serializable
import com.example.cars.data.enums.CarBrand
import com.example.cars.data.enums.CarColor
import com.example.cars.data.enums.CarSteering
import com.example.cars.data.enums.CarTransmission

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