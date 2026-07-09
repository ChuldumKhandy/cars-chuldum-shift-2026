package com.example.cars.core.network

import com.example.cars.rent.data.remote.CarApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

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