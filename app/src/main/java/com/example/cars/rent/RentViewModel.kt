package com.example.cars.rent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cars.data.CarRepository
import com.example.cars.data.DataState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import com.example.cars.data.domain.Car

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
                        state.message,
                        state.cachedData as? List<Car>
                    )
                }
            }
        }
    }

}