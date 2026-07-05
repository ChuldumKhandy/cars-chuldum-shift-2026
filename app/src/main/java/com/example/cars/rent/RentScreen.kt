package com.example.cars.rent

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.cars.network.NetworkModule

@Composable
fun RentScreen(modifier: Modifier = Modifier) {

    val viewModel: RentViewModel = viewModel(
        factory = viewModelFactory {
            initializer { RentViewModel(NetworkModule.carApi) }
        }
    )

    val state by viewModel.uiState.collectAsState()

    Column(modifier = modifier.padding(16.dp)) {
        Button(onClick = { viewModel.loadCars() }) {
            Text("Load cars")
        }

        Text(
            text = when (val s = state) {
                RentUiState.Idle -> "Нажми кнопку, чтобы загрузить машины"
                RentUiState.Loading -> "Загрузка..."
                is RentUiState.Success -> "Получено машин: ${s.cars.size}\n${s.cars.firstOrNull()?.name}"
                is RentUiState.Error -> "Ошибка: ${s.message}"
            }
        )
    }

}