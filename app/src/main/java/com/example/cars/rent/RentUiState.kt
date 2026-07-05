package com.example.cars.rent

import com.example.cars.data.CarDto

sealed interface RentUiState {
    data object Idle: RentUiState
    data object Loading: RentUiState
    data class Success(val cars: List<CarDto>): RentUiState
    data class Error(val message: String?): RentUiState
}