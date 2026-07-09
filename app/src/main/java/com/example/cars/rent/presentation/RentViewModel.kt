package com.example.cars.rent.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cars.core.DataState
import com.example.cars.rent.data.repository.CarRepository
import com.example.cars.rent.domain.Car
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RentViewModel(
    private val repository: CarRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<RentUiState>(RentUiState.Idle)
    val uiState: StateFlow<RentUiState> = _uiState.asStateFlow()

    fun loadCars() {
        if (_uiState.value is RentUiState.Success)
            return

        viewModelScope.launch {
            repository.getCars().collect { state ->
                _uiState.value = when (state) {
                    DataState.Loading -> RentUiState.Loading
                    is DataState.Success -> RentUiState.Success(state.data)
                    is DataState.Error -> RentUiState.Error(
                        state.error,
                        state.cachedData as? List<Car>
                    )
                }
            }
        }
    }
}