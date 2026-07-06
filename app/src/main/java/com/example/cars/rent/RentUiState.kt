package com.example.cars.rent

import com.example.cars.data.domain.Car

sealed interface RentUiState {
    data object Idle: RentUiState
    data object Loading: RentUiState
    data class Success(val cars: List<Car>): RentUiState
    data class Error(val message: String?, val cachedCars: List<Car>? = null): RentUiState
}