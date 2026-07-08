package com.example.cars.rent.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cars.core.ui.theme.primary

@Composable
fun RentHeader(
    search: String,
    startDate: String,
    endDate: String,
    onSearchChange: (String) -> Unit,
    onTapFilter: () -> Unit,
    onTapStartDate: () -> Unit,
    onTapEndDate: () -> Unit,
    onTapButton: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {

        Spacer(Modifier.height(32.dp))

        Text(
            text = "Аренда машины",
            style = MaterialTheme.typography.titleMedium,
            color = primary
        )

        Spacer(Modifier.height(24.dp))

        SearchField(
            value = search,
            onValueChange = onSearchChange,
            onTapFilter = onTapFilter
        )

        Spacer(Modifier.height(20.dp))

        DateField(
            label = "Начало аренды",
            value = startDate,
            onClick = onTapStartDate
        )

        Spacer(Modifier.height(16.dp))

        DateField(
            label = "Окончание аренды",
            value = endDate,
            onClick = onTapEndDate
        )

        Spacer(Modifier.height(24.dp))

        Button(
            onClick = onTapButton,
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            shape = RoundedCornerShape(26.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Text(
                "Найти машину",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }

        Spacer(Modifier.height(20.dp))
    }
}