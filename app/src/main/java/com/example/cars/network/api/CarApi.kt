package com.example.cars.network.api

import com.example.cars.data.ApiResponseDto
import com.example.cars.data.CarDto
import retrofit2.http.GET

interface CarApi {
    @GET("info")
    suspend fun getCars(): ApiResponseDto<List<CarDto>>
}