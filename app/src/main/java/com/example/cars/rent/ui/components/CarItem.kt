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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.cars.R
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
            "automatic" -> stringResource(R.string.automatic)
            "manual" -> stringResource(R.string.manual)
            else -> car.transmission
        }
        val engineVolume = extractEngineVolume(car.name)

        CarInfoBlock(
            title = car.name,
            subtitle = if (engineVolume != null) {
                stringResource(R.string.engine_volume, transmissionLabel, engineVolume)
            } else {
                transmissionLabel
            }
        )

        val rentalPrice =  car.price * rentalDays

        CarInfoBlock(
            title = stringResource(R.string.car_price, car.price),
            subtitle = stringResource(R.string.rent_price, rentalPrice, rentalDays)
        )
    }
}