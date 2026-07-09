package com.example.cars.core

sealed interface DataError {
    data object Network: DataError
    data class Server(val reason: String?): DataError
    data class Http(val code: Int): DataError
    data class Unknown(val throwable: Throwable): DataError
}