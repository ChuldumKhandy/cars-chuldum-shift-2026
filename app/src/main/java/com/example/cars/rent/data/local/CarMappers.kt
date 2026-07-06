package com.example.cars.rent.data.local

import kotlinx.serialization.json.Json
import com.example.cars.rent.data.remote.enums.CarBodyType
import kotlinx.serialization.encodeToString
import com.example.cars.network.NetworkConstants
import com.example.cars.rent.data.remote.dto.CarDto
import com.example.cars.rent.data.remote.dto.CarMediaDto
import com.example.cars.rent.data.remote.enums.CarBrand
import com.example.cars.rent.data.remote.enums.CarColor
import com.example.cars.rent.data.remote.enums.CarSteering
import com.example.cars.rent.data.remote.enums.CarTransmission
import com.example.cars.rent.domain.Car

private val json = Json { ignoreUnknownKeys = true }

fun CarDto.toEntity(): CarEntity = CarEntity (
    id = id,
    name = name,
    brand = brand.name,
    imageUrl = json.encodeToString(media),
    transmission = transmission.name,
    price = price,
    location = location,
    color = color.name,
    bodyType = bodyType.name,
    steering = steering.name
)

fun CarDto.toDomain(): Car {
    val cover = media.firstOrNull { it.isCover } ?: media.firstOrNull()

    return Car(
        id = id,
        name = name,
        brand = brand.name,
        coverImageUrl = cover?.url?.let { NetworkConstants.MEDIA_BASE_URL + it },
        transmission = transmission.name,
        price = price,
        location = location,
        color = color.name,
        bodyType = bodyType.name,
        steering = steering.name
    )
}

fun CarEntity.toDto(): CarDto = CarDto(
    id = id,
    name = name,
    brand = CarBrand.valueOf(brand),
    media = json.decodeFromString<List<CarMediaDto>>(imageUrl),
    transmission = CarTransmission.valueOf(transmission),
    price = price,
    location = location,
    color = CarColor.valueOf(color),
    bodyType = CarBodyType.valueOf(bodyType),
    steering = CarSteering.valueOf(steering)
)