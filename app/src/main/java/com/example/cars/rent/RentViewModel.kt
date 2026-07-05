package com.example.cars.rent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cars.network.api.CarApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException

class RentViewModel(
    private val api: CarApi
) : ViewModel() {

    private val _uiState = MutableStateFlow<RentUiState>(RentUiState.Idle)
    val uiState: StateFlow<RentUiState> = _uiState.asStateFlow()

    fun loadCars() {
        viewModelScope.launch {
            _uiState.value = RentUiState.Loading
            _uiState.value = try {
                val response = api.getCars()

                if (response.success) {
                    RentUiState.Success(response.data)
                } else {
                    RentUiState.Error(response.reason)
                }
            } catch (e: IOException) {
                RentUiState.Error("Нет подключения к сети")
            } catch (e: HttpException) {
                RentUiState.Error("Ошибка сервера: ${e.code()}")
            } catch (e: Exception) {
                RentUiState.Error(e.message ?: "Неизвестная ошибка")
            }
        }
    }

}