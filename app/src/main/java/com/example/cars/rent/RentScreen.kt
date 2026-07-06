package com.example.cars.rent

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.cars.data.RepositoryModule
import com.example.cars.data.remote.CarDto
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.lazy.items

@Composable
fun RentScreen(modifier: Modifier = Modifier) {

    val viewModel: RentViewModel = viewModel(
        factory = viewModelFactory {
            initializer { RentViewModel(RepositoryModule.carRepository) }
        }
    )

    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadCars()
    }

    when (val state = state) {
        RentUiState.Idle -> {
            Text("Idle")
        }

        RentUiState.Loading -> {
            CircularProgressIndicator()
        }

        is RentUiState.Error -> {
            Column {
                Text("Ошибка: ${state.message}")
                if (!state.cachedCars.isNullOrEmpty()) {
                    Text(
                        text = "Показаны сохранённые данные",
                        style = MaterialTheme.typography.labelMedium
                    )
                    LazyColumn(modifier = modifier.padding(16.dp)) {
                        items(state.cachedCars) { car ->
                            CarItem(car)
                        }
                    }
                }
            }
        }

        is RentUiState.Success -> {
            LazyColumn(
                modifier = modifier.padding(16.dp)
            ) {
                items(state.cars) { car ->
                    CarItem(car)
                }
            }
        }
    }
}

@Composable
fun CarItem(car: CarDto) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = car.name,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}