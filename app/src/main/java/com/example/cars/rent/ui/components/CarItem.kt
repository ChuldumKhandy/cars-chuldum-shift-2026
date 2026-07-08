package com.example.cars.rent.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.cars.core.ui.theme.imageBg
import com.example.cars.rent.domain.Car
import com.example.cars.rent.ui.extractEngineVolume

@Composable
fun CarItem(
    car: Car,
    rentalDays: Long,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier
        .fillMaxWidth()
        .padding(top = 40.dp)
    ) {
        AsyncImage(
            model = car.coverImageUrl,
            contentDescription = car.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(126.dp)
                .background(imageBg, RoundedCornerShape(24.dp))
                .clip(RoundedCornerShape(24.dp)),
            contentScale = ContentScale.Fit
        )

        val transmissionLabel = when (car.transmission.lowercase()) {
            "automatic" -> "Автомат"
            "manual" -> "Механика"
            else -> car.transmission
        }
        val engineVolume = extractEngineVolume(car.name)

        CarInfoBlock(
            title = car.name,
            subtitle = if (engineVolume != null) {
                "$transmissionLabel, $engineVolume л"
            } else {
                transmissionLabel
            }
        )

        CarInfoBlock(
            title = "${car.price} ₽",
            subtitle = "${car.price * rentalDays} ₽ за $rentalDays дней"
        )
    }
}