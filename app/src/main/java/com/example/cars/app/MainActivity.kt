package com.example.cars.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.cars.rent.ui.RentScreen
import com.example.cars.core.ui.theme.Carschuldumshift2026Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Carschuldumshift2026Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RentScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}