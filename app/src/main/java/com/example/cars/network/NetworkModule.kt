package com.example.cars.network

import com.example.cars.network.api.CarApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

object NetworkConstants {
    const val BASE_URL = "https://juniorsbootcamp.ru/api/cars"
    const val TIMEOUT_SECONDS = 10L
    const val READ_TIMEOUT = 10L
    const val WRITE_TIMEOUT = 10L
}

object NetworkModule {

    private val json = Json { ignoreUnknownKeys = true }
    private val converterFactory = json.asConverterFactory("application/json; charset=UTF8".toMediaType())

    private val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .connectTimeout(NetworkConstants.TIMEOUT_SECONDS, TimeUnit.SECONDS)
        .readTimeout(NetworkConstants.READ_TIMEOUT, TimeUnit.SECONDS)
        .writeTimeout(NetworkConstants.WRITE_TIMEOUT, TimeUnit.SECONDS)
        .build()

    private val retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(NetworkConstants.BASE_URL)
        .addConverterFactory(converterFactory)
        .build()

    val carApi: CarApi by lazy { retrofit.create(CarApi::class.java) }
}