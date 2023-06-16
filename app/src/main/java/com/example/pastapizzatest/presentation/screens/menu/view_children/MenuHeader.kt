package com.example.pastapizzatest.presentation.screens.menu.view_children

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.pastapizzatest.R

@Composable
fun MenuHeader(modifier: Modifier) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.SpaceBetween) {
        Text(
            text = "Москва",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null)
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(R.drawable.qr_code),
            contentDescription = "qr_code"
        )
    }
}