package com.example.cars.network.api

import com.example.cars.data.remote.ApiResponseDto
import com.example.cars.data.remote.CarDto
import retrofit2.http.GET

interface CarApi {
    @GET("info")
    suspend fun getCars(): ApiResponseDto<List<CarDto>>
}