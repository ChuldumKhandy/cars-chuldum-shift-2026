package com.example.cars.rent.data.remote

import com.example.cars.rent.data.remote.dto.ApiResponseDto
import com.example.cars.rent.data.remote.dto.CarDto
import retrofit2.http.GET

interface CarApi {
    @GET("info")
    suspend fun getCars(): ApiResponseDto<List<CarDto>>
}