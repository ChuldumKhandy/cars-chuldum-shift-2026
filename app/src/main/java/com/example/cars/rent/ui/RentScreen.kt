package com.example.cars.rent.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import com.example.cars.rent.data.repository.RepositoryModule
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.lazy.items
import com.example.cars.rent.presentation.RentUiState
import com.example.cars.rent.presentation.RentViewModel

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
                            CarItem(
                                car,
                                rentalDays = 14 //TODO()
                            )
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
                    CarItem(
                        car,
                        rentalDays = 14 //TODO()
                    )
                }
            }
        }
    }
}