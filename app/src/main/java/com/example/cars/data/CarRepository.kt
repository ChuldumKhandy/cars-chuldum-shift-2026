package com.example.cars.data

import com.example.cars.data.domain.Car
import com.example.cars.data.local.CarDao
import com.example.cars.data.local.toDomain
import com.example.cars.data.local.toDto
import com.example.cars.data.local.toEntity
import com.example.cars.data.remote.CarDto
import com.example.cars.network.api.CarApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException

class CarRepository(
    private val api: CarApi,
    private val dao: CarDao
) {

    fun getCars(): Flow<DataState<List<Car>>> = flow {
        emit(DataState.Loading)

        val cached = dao.getCars().map { it.toDto().toDomain() }

        if (cached.isNotEmpty()) {
            emit(DataState.Success(cached))
        }

        try {
            val response = api.getCars()

            if (response.success) {
                dao.clear()
                dao.insertCars(response.data.map { it.toEntity() })
                emit(DataState.Success(response.data.map { it.toDomain() }))
            } else {
                emit(DataState.Error(response.reason ?: "Ошибка сервера", cached.ifEmpty { null }))
            }
        } catch (e: IOException) {
            emit(DataState.Error("Нет подключения к сети", cached.ifEmpty { null }))
        } catch (e: HttpException) {
            emit(DataState.Error("Ошибка сервера: ${e.code()}", cached.ifEmpty { null }))
        } catch (e: Exception) {
            emit(DataState.Error(e.message ?: "Неизвестная ошибка", cached.ifEmpty { null }))
        }
    }
}