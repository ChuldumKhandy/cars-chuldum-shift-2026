package com.example.cars.rent.presentation

import com.example.cars.core.DataError
import com.example.cars.rent.domain.Car

sealed interface RentUiState {
    data object Idle: RentUiState
    data object Loading: RentUiState
    data class Success(val cars: List<Car>): RentUiState
    data class Error(val error: DataError, val cachedCars: List<Car>? = null): RentUiState
}