package com.example.cars.core

sealed interface DataState<out T> {
    data object Loading: DataState<Nothing>
    data class Success<T>(val data: T): DataState<T>
    data class Error(val error: DataError, val cachedData: Any? = null): DataState<Nothing>
}