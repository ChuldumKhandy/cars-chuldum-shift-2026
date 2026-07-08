package com.example.cars.rent.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.cars.R

@Composable
fun SearchField(
    value: String,
    onValueChange: (String) -> Unit,
    onTapFilter: () -> Unit
) {

    Column {

        FieldHeader(stringResource(R.string.search))

        Spacer(Modifier.height(4.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                modifier = Modifier.weight(1f),
                singleLine = true,
                decorationBox = { innerTextField ->

                    Row(
                        modifier = Modifier
                            .height(40.dp)
                            .border(
                                1.dp,
                                MaterialTheme.colorScheme.outline,
                                RoundedCornerShape(20.dp)
                            )
                            .padding(horizontal = 14.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            painterResource(R.drawable.search),
                            null,
                            tint = MaterialTheme.colorScheme.outline
                        )

                        Spacer(Modifier.width(8.dp))

                        Box {

                            if (value.isEmpty()) {
                                Text(
                                    stringResource(R.string.search_placeholder),
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.outline
                                )
                            }

                            innerTextField()
                        }
                    }
                }
            )

            Spacer(Modifier.width(8.dp))

            IconButton(
                onClick = onTapFilter,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.secondary)
            ) {
                Icon(
                    painterResource(R.drawable.filter),
                    null
                )
            }
        }
    }
}